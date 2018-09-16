package com.zr.controller;
import java.io.IOException;
import java.util.List;

import com.zr.pojo.PageResult;
import com.zr.pojo.Response;
import com.zr.pojo.Selectques;
import com.zr.pojo_group.SelectGroup;
import com.zr.service.SelectquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/selectques")
public class SelectquesController {

	@Autowired
	private SelectquesService selectquesService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Selectques> findAll(){
		return selectquesService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return selectquesService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param selectGroup
	 * @return
	 */
	@RequestMapping("/add")
	public Response add(@RequestBody SelectGroup selectGroup){
		try {
			selectquesService.add(selectGroup);
			return new Response(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param selectGroup
	 * @return
	 */
	@RequestMapping("/update")
	public Response update(@RequestBody SelectGroup selectGroup){
		try {
			selectquesService.update(selectGroup);
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
	public SelectGroup findOne(Integer id) throws IOException {
		return selectquesService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Response delete(Integer [] ids){
		try {
			selectquesService.delete(ids);
			return new Response(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "删除失败");
		}
	}
	
	/**
	 * 查询+分页
	 * @param selectques
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody Selectques selectques, int page, int rows  ){
		return selectquesService.findPage(selectques, page, rows);		
	}
	
}
