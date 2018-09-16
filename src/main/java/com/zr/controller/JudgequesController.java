package com.zr.controller;

import com.zr.pojo.Judgeques;
import com.zr.pojo.PageResult;
import com.zr.pojo.Response;
import com.zr.service.JudgequesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/judgeques")
public class JudgequesController {
	@Autowired
	private JudgequesService judgequesService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Judgeques> findAll(){
		return judgequesService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return judgequesService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param judgeques
	 * @return
	 */
	@RequestMapping("/add")
	public Response add(@RequestBody @Validated Judgeques judgeques, BindingResult bindingResult){
		try {
			int errorCount=bindingResult.getErrorCount();

			if(errorCount>0){
				FieldError titleError=bindingResult.getFieldError("title");
				FieldError difficultylevelError=bindingResult.getFieldError("difficultylevel");
				FieldError answerError=bindingResult.getFieldError("answer");
				if(titleError!=null){
					return new Response(false, titleError.getDefaultMessage());
				}
				if(difficultylevelError!=null){
					return new Response(false, difficultylevelError.getDefaultMessage());
				}
				if(answerError!=null){
					return new Response(false, answerError.getDefaultMessage());
				}
			}
			judgequesService.add(judgeques);
			return new Response(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param judgeques
	 * @return
	 */
	@RequestMapping("/update")
	public Response update(@RequestBody Judgeques judgeques){
		try {
			judgequesService.update(judgeques);
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
	public Judgeques findOne(Integer id){
		return judgequesService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Response delete(Integer[] ids){
		try {
			judgequesService.delete(ids);
			return new Response(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param judgeques
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody Judgeques judgeques, int page, int rows  ){
		return judgequesService.findPage(judgeques, page, rows);		
	}
}
