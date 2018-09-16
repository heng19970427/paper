package com.zr.controller;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zr.pojo.PageResult;
import com.zr.pojo.Paper;
import com.zr.pojo.Response;
import com.zr.service.PaperService;
import com.zr.utils.WordGeneratorUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/paper")
public class PaperController {

	@Autowired
	private PaperService paperService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Paper> findAll(){
		return paperService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return paperService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param paper
	 * @return
	 */
	@RequestMapping("/add")
	public Response add(@RequestBody Paper paper){
		try {
			paperService.add(paper);
			return new Response(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param paper
	 * @return
	 */
	@RequestMapping("/update")
	public Response update(@RequestBody Paper paper){
		try {
			paperService.update(paper);
			return new Response(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public ResponseEntity<byte[]> findOne(Integer id,HttpServletRequest request,HttpServletResponse response) throws IOException {
		//查询对应的试卷
		Paper paper = paperService.findOne(id);

		//  接受的是UTF-8
		request.setCharacterEncoding("utf-8");

		//获取项目根目录
		String path=request.getServletContext().getRealPath("WEB-INF/"+paper.getPath());

		//获取文件名
		String filename=paper.getPapername()+".doc";

		File file = null;

		HttpHeaders headers =null;

		try {

			System.out.println(filename);//myfiles
			file =new File(path);

			//请求头
			headers =new HttpHeaders();

			String fileName1 =new String(filename.getBytes("UTF-8"),"iso-8859-1");//解决文件名乱码
			//通知浏览器以attachment（下载方式）打开图片
			headers.setContentDispositionFormData("attachment",fileName1);

			//application/octet-stream二进制流数据（最常见的文件下载）。
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

		} catch (Exception e) {

			throw new RuntimeException(e);

		}
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Response delete(Integer [] ids){
		try {
			paperService.delete(ids);
			return new Response(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "删除失败");
		}
	}
	
	/**
	 * 查询+分页
	 * @param paper
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody Paper paper, int page, int rows  ){
		return paperService.findPage(paper, page, rows);
	}

	/**
	* @Description:  id
	* @Param: [id] 模板Id paperName 试卷名称
	* @return: java.lang.String
	* @Author: Zr
	* @Date: 2018/9/4
	*/
	@RequestMapping("/createPaper")
	public String createPaper(@RequestBody Paper paper, HttpServletResponse response, HttpServletRequest request){
		String paperName = paper.getPapername();
		//获取模板id，获取之后制空，试卷还没插入。没有id
		Map<String, String> paperInfoMap = paperService.createPaper(paper.getPaId(),paperName);
		paper.setPaId(null);
		File file = null;
		InputStream fin = null;
		ServletOutputStream out = null;
		OutputStream os=null;
		try {
			//调用工具类WordGenerator的createDoc方法生成Word文档
			file = WordGeneratorUtil.createDoc(paperInfoMap,"paper1",paperName);
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
			String filepath="papers/"+fileName2;
			paper.setPath(filepath);

			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			paper.setCreatetime(dateFormat.parse(dateFormat.format(new Date())));
			paperService.add(paper);

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
}
