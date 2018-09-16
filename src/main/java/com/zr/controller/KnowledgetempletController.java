package com.zr.controller;
import java.util.List;

import com.zr.pojo.*;
import com.zr.pojo_group.PapertempletGroup;
import com.zr.service.KnowledgetempletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/knowledgetemplet")
public class KnowledgetempletController {
	@Autowired
	private KnowledgetempletService knowledgetempletService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Knowledgetemplet> findAll(){
		return knowledgetempletService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return knowledgetempletService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param knowledgetemplet
	 * @return
	 */
	@RequestMapping("/add")
	public Response add(@RequestBody Knowledgetemplet knowledgetemplet){
		try {
			knowledgetempletService.add(knowledgetemplet);
			return new Response(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param knowledgetemplet
	 * @return
	 */
	@RequestMapping("/update")
	public Response update(@RequestBody Knowledgetemplet knowledgetemplet){
		try {
			knowledgetempletService.update(knowledgetemplet);
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
	public Knowledgetemplet findOne(Integer id){
		return knowledgetempletService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Response delete(Integer[] ids){
		try {
			knowledgetempletService.delete(ids);
			return new Response(true, "删除成功");
		}catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param knowledgetemplet
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody Knowledgetemplet knowledgetemplet, int page, int rows  ){
		return knowledgetempletService.findPage(knowledgetemplet, page, rows);		
	}

	@RequestMapping("/adds")
	public Response adds(@RequestBody List<Knowledgetemplet> knowledgetemplets  ){

		try {
			knowledgetempletService.adds(knowledgetemplets);
			return new Response(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "删除失败");
		}
	}

	@RequestMapping("updateKnow")
	@ResponseBody
	public List<Knowledgetemplet> updateKnow(Integer[] kIds){
		return knowledgetempletService.updateKnow(kIds);
	}
}
