package com.zr.controller;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.zr.pojo.Bigques;
import com.zr.pojo.Option;
import com.zr.pojo.PageResult;
import com.zr.pojo.Response;
import com.zr.pojo_group.BigGroup;
import com.zr.service.BigquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/bigques")
public class BigquesController {

	@Autowired
	private BigquesService bigquesService;

	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Bigques> findAll(){
		return bigquesService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return bigquesService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param bigGroup
	 * @return
	 */
	@RequestMapping("/add")
	public Response add(@RequestBody BigGroup bigGroup){
		try {
            ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
            Validator validator = vf.getValidator();
            Set<ConstraintViolation<Bigques>> bigquesVali = validator.validate(bigGroup.getBigques());
			int errorCount=bigquesVali.size();
			Response response = BigGroup.dataValidate(bigGroup.getOptionList());
			if(errorCount>0 || !response.isSuccess()){
				for (ConstraintViolation<Bigques> constraintViolation : bigquesVali) {
					return new Response(false,constraintViolation.getMessage());
				}
				return response;
			}
			bigquesService.add(bigGroup);
			return new Response(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param bigGroup
	 * @return
	 */
	@RequestMapping("/update")
	public Response update(@RequestBody BigGroup bigGroup){
		try {
			bigquesService.update(bigGroup);
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
	public BigGroup findOne(Integer id) throws IOException {
		return bigquesService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Response delete(Integer [] ids){
		try {
			bigquesService.delete(ids);
			return new Response(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param bigques
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody Bigques bigques, int page, int rows  ){
		return bigquesService.findPage(bigques, page, rows);		
	}
	
}
