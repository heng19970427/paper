package com.zr.controller;

import com.zr.pojo.PaperTemplet;
import com.zr.service.PaperService;
import com.zr.service.PaperTempletService;
import com.zr.utils.WordGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
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
    public String createPaper(String pt_id,String paperName,Model model, HttpServletResponse response){
        //查询使用那一套模板生成试卷
        PaperTemplet paperTemplet = templetService.queryPaperTempByPtId(pt_id);
        //根据模板将生成的试卷信息封装成Map返回
        Map<String,String> map =paperService.createPaper(paperTemplet,paperName);
        map.put("paperName","测试模板");
        map.put("selectQuesScore","45");
        map.put("selectQues","下列哪个标准类模板不能使用通用算法algorithm中定义的sort算法( )<w:br/>A.vector<w:br/>B.list<w:br/>C.deque<w:br/>D.string");
        File file = null;
        InputStream fin = null;
        ServletOutputStream out = null;
        try {
            //调用工具类WordGenerator的createDoc方法生成Word文档
            file = WordGeneratorUtil.createDoc(map, paperName);
            fin = new FileInputStream(file);
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/msword");
            response.addHeader("Content-Disposition", "attachment;filename="+paperName+".doc");

            out = response.getOutputStream();
            byte[] buffer = new byte[1024];//缓冲区
            int bytesToRead = -1;
            // 通过循环将读入的Word文件的内容输出到浏览器中
            while((bytesToRead = fin.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if(fin != null) {
                try {
                    fin.close();
                    if(out != null) out.close();
                    if(file != null) file.delete(); // 删除临时文件
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return "null";
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
