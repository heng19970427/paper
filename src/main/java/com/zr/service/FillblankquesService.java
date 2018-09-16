package com.zr.service;
import java.util.List;

import com.zr.dao.FillblankquesMapper;
import com.zr.pojo.FillblankquesExample;
import com.zr.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zr.pojo.Fillblankques;
import org.springframework.stereotype.Service;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class FillblankquesService {

	@Autowired
	private FillblankquesMapper fillblankquesMapper;
	
	/**
	 * 查询全部
	 */
	public List<Fillblankques> findAll() {
		return fillblankquesMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Fillblankques> page=   (Page<Fillblankques>) fillblankquesMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	public void add(Fillblankques fillblankques) {
		fillblankquesMapper.insert(fillblankques);		
	}

	
	/**
	 * 修改
	 */
	public void update(Fillblankques fillblankques){
		fillblankquesMapper.updateByPrimaryKey(fillblankques);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Fillblankques findOne(Integer id){
		return fillblankquesMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			fillblankquesMapper.deleteByPrimaryKey(id);
		}		
	}
	
	

	public PageResult findPage(Fillblankques fillblankques, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		FillblankquesExample example=new FillblankquesExample();
		FillblankquesExample.Criteria criteria = example.createCriteria();
		
		if(fillblankques!=null){			
						if(fillblankques.getTitle()!=null && fillblankques.getTitle().length()>0){
				criteria.andTitleLike("%"+fillblankques.getTitle()+"%");
			}
			if(fillblankques.getAnswer()!=null && fillblankques.getAnswer().length()>0){
				criteria.andAnswerLike("%"+fillblankques.getAnswer()+"%");
			}
			if(fillblankques.getDescription()!=null && fillblankques.getDescription().length()>0){
				criteria.andDescriptionLike("%"+fillblankques.getDescription()+"%");
			}
	
		}
		
		Page<Fillblankques> page= (Page<Fillblankques>)fillblankquesMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
