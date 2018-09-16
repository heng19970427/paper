package com.zr.controller;
import java.util.List;
import java.util.Set;

import com.zr.pojo.Bigques;
import com.zr.pojo.PageResult;
import com.zr.pojo.Papertemplet;
import com.zr.pojo_group.BigGroup;
import com.zr.pojo_group.PapertempletGroup;
import com.zr.pojo.Response;
import com.zr.service.PapertempletService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/papertemplet")
public class PapertempletController {

	@Autowired
	private PapertempletService papertempletService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Papertemplet> findAll(){
		return papertempletService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return papertempletService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param papertempletGroup
	 * @return
	 */
	@RequestMapping("/add")
	public Response add(@RequestBody PapertempletGroup papertempletGroup){
		try {
			ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
			Validator validator = vf.getValidator();
			Set<ConstraintViolation<Papertemplet>> paperTempValidate = validator.validate(papertempletGroup.getPapertemplet());
			int errorCount=paperTempValidate.size();
			Response response = PapertempletGroup.dataValidate(papertempletGroup.getKnowledgetempletList(),papertempletGroup.getPapertemplet());
			if(errorCount>0 || !response.isSuccess()){
				for (ConstraintViolation<Papertemplet> constraintViolation : paperTempValidate) {
					return new Response(false,constraintViolation.getMessage());
				}
				return response;
			}
			papertempletService.add(papertempletGroup);
			return new Response(true, "模板创建成功");
		}catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "模板创建失败，信息不完整");
		}
	}
	
	/**
	 * 修改
	 * @param papertempletGroup
	 * @return
	 */
	@RequestMapping("/update")
	public Response update(@RequestBody PapertempletGroup papertempletGroup){
		try {
			papertempletService.update(papertempletGroup);
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
	public PapertempletGroup findOne(Integer id){
		return papertempletService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Response delete(Integer [] ids){
		try {
			papertempletService.delete(ids);
			return new Response(true, "删除成功");
		}catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "删除失败");
		}
	}
	
	/**
	 * 查询+分页
	 * @param papertemplet
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody Papertemplet papertemplet, int page, int rows  ){
		return papertempletService.findPage(papertemplet, page, rows);
	}

	@RequestMapping("/updatePaperTempSelect")
	public PapertempletGroup updatePaperTempSelect(@RequestBody PapertempletGroup papertempletGroup){
		return papertempletService.updatePaperTempSelect(papertempletGroup);
	}

//	@RequestMapping("/createPaper")
//	public String createPaper(){
//
//	}
}
