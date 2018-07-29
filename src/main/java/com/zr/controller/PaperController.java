package com.zr.controller;

import com.zr.pojo.Paper;
import com.zr.pojo.PaperTemplet;
import com.zr.service.PaperService;
import com.zr.service.PaperTempletService;
import com.zr.utils.WordGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("paper")
public class PaperController {

    @Autowired
    private PaperTempletService templetService;

    @Autowired
    private PaperService paperService;

    @RequestMapping("createPaper")
    public String createPaper(String pt_id, String paperName, Model model, HttpServletResponse response, HttpServletRequest request){
        //查询使用那一套模板生成试卷
        PaperTemplet paperTemplet = templetService.queryPaperTempByPtId(pt_id);
        //根据模板将生成的试卷信息封装成Map返回
        Map<String,String> map =paperService.createPaper(paperTemplet,paperName);

        File file = null;
        InputStream fin = null;
        ServletOutputStream out = null;
        OutputStream os=null;
        try {
            //调用工具类WordGenerator的createDoc方法生成Word文档
            file = WordGeneratorUtil.createDoc(map,"paper1",paperName);
            String fileName1=new String((paperName+".doc").getBytes("UTF-8"),"iso-8859-1");
            String fileName2=paperName+".doc";
            //响应头post中文乱码问题
            //response.setHeader("Content-type", "text/html;charset=UTF-8");
            fin = new FileInputStream(file);
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/msword");
            response.addHeader("Content-Disposition", "attachment;filename="+fileName1);
            //将文件保存到服务器
            String savePath=request.getServletContext().getRealPath("WEB-INF/papers/");

            //将文件路径写入数据库
            Paper paper=new Paper();
            paper.setPaperName(paperName);
            String filepath="papers/"+fileName2;
            paper.setPath(filepath);
            paperService.savePaper(paper);

            File saveFileDir = new File(savePath);
            if(!saveFileDir.exists()){
                //不存在就创建目录
                saveFileDir.mkdirs();
            }
            //指向浏览器的输出流
            out = response.getOutputStream();
            //指向服务器的输出流
            os=new FileOutputStream(new File(savePath+fileName2));
            byte[] buffer = new byte[1024];//缓冲区
            int bytesToRead = -1;
            //通过循环将读入的Word文件输出到浏览器和服务器
            while((bytesToRead = fin.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
                os.write(buffer,0,bytesToRead);
            }
            out.flush();
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if(fin != null) {
                try {
                    fin.close();
                    if(out != null) out.close();
                    if(file != null) file.delete(); // 删除临时文件
                    if(os!=null) os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public PaperTempletService getTempletService() {
        return templetService;
    }

    public void setTempletService(PaperTempletService templetService) {
        this.templetService = templetService;
    }

    public PaperService getPaperService() {
        return paperService;
    }

    public void setPaperService(PaperService paperService) {
        this.paperService = paperService;
    }
}
