package com.zr.service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zr.dao.QuescateMapper;
import com.zr.dao.SelectquesMapper;
import com.zr.pojo.*;
import com.zr.pojo_group.SelectGroup;
import com.zr.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import org.springframework.stereotype.Service;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SelectquesService {

	@Autowired
	private SelectquesMapper selectquesMapper;

	@Autowired
	private QuescateMapper quescateMapper;
	/**
	 * 查询全部
	 */

	public List<Selectques> findAll() {
		return selectquesMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */

	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Selectques> page=   (Page<Selectques>) selectquesMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 * @param selectGroup
	 */

	public void add(SelectGroup selectGroup) throws JsonProcessingException {
		Selectques selectques = selectGroup.getSelectques();
		List<Option> optionList = selectGroup.getOptionList();
		String optionJson = JsonUtil.toJsonString(optionList);
		selectques.setOption(optionJson);
		selectques.setpId(1);
		selectques.setSelectednum(0);
		System.out.println(optionJson);
		selectquesMapper.insert(selectques);
	}

	
	/**
	 * 修改
	 */

	public void update(SelectGroup selectGroup) throws JsonProcessingException {
		Selectques selectques = selectGroup.getSelectques();
		String jsonString = JsonUtil.toJsonString(selectGroup.getOptionList());
		selectques.setOption(jsonString);
		selectquesMapper.updateByPrimaryKey(selectques);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return Selectques
	 */

	public SelectGroup findOne(Integer id) throws IOException {
		Selectques selectques = selectquesMapper.selectByPrimaryKey(id);
		Quescate quescate=quescateMapper.selectByPrimaryKey(selectques.getQcId());
		selectques.setQuescate(quescate);
		List<Option> optionList=JsonUtil.toListObject(selectques.getOption(), ArrayList.class,Option.class);
		SelectGroup selectGroup=new SelectGroup();
		selectGroup.setSelectques(selectques);
		selectGroup.setOptionList(optionList);
		return selectGroup;
	}

	/**
	 * 批量删除
	 */

	public void delete(Integer[] ids) {
		for(Integer id:ids){
			selectquesMapper.deleteByPrimaryKey(id);
		}		
	}
	
	

	public PageResult findPage(Selectques selectques, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		SelectquesExample example=new SelectquesExample();
		SelectquesExample.Criteria criteria = example.createCriteria();
		if(selectques!=null){
			if(selectques.getcId()!=null){
				criteria.andCIdEqualTo(selectques.getcId());
			}
			if(selectques.getQcId()!=null){
				criteria.andQcIdEqualTo(selectques.getQcId());
			}
		}
		Page<Selectques> page= (Page<Selectques>)selectquesMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
