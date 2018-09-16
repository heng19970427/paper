package com.zr.controller;

import com.zr.pojo.Fillblankques;
import com.zr.pojo.PageResult;
import com.zr.pojo.Response;
import com.zr.service.FillblankquesService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/fillblankques")
public class FillblankquesController {

	@Autowired
	private FillblankquesService fillblankquesService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Fillblankques> findAll(){
		return fillblankquesService.findAll();
	}

	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return fillblankquesService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param fillblankques
	 * @return
	 */
	@RequestMapping("/add")
	public Response add(@RequestBody Fillblankques fillblankques){
		try {
			fillblankquesService.add(fillblankques);
			return new Response(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param fillblankques
	 * @return
	 */
	@RequestMapping("/update")
	public Response update(@RequestBody Fillblankques fillblankques){
		try {
			fillblankquesService.update(fillblankques);
			return new Response(true, "修改成功");
		} catch (Exception e){
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
	public Fillblankques findOne(Integer id){
		return fillblankquesService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Response delete(Integer[] ids){
		try {
			fillblankquesService.delete(ids);
			return new Response(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param fillblankques
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody Fillblankques fillblankques, int page, int rows  ){
		return fillblankquesService.findPage(fillblankques, page, rows);		
	}
}
