package com.zr.service;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.zr.dao.BigquesMapper;
import com.zr.dao.QuescateMapper;
import com.zr.pojo.*;
import com.zr.pojo_group.BigGroup;
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
public class BigquesService  {

	@Autowired
	private BigquesMapper bigquesMapper;

	@Autowired
    private QuescateMapper quescateMapper;
	/**
	 * 查询全部
	 */

	public List<Bigques> findAll() {
		return bigquesMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */

	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Bigques> page=   (Page<Bigques>) bigquesMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */

	public void add(BigGroup bigGroup) throws JsonProcessingException {
		Bigques bigques = bigGroup.getBigques();
		String jsonString = JsonUtil.toJsonString(bigGroup.getOptionList());
		bigques.setOption(jsonString);

        Integer qcId = bigques.getQcId();
        Integer cId = quescateMapper.selectByPrimaryKey(qcId).getcId();
        bigques.setcId(cId);
        bigques.setpId(4);
        bigques.setSelectednum(0);
        bigquesMapper.insert(bigques);
	}
	
	/**
	 * 修改
	 */

	public void update(BigGroup bigGroup) throws JsonProcessingException {
		Bigques bigques = bigGroup.getBigques();
		String jsonString = JsonUtil.toJsonString(bigGroup.getOptionList());
		bigques.setOption(jsonString);
		bigquesMapper.updateByPrimaryKey(bigques);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */

	public BigGroup findOne(Integer id) throws IOException {
		Bigques bigques = bigquesMapper.selectByPrimaryKey(id);
		return new BigGroup(bigques, JsonUtil.toListObject(bigques.getOption(), List.class,Option.class));
	}

	/**
	 * 批量删除
	 */

	public void delete(Integer[] ids) {
		for(Integer id:ids){
			bigquesMapper.deleteByPrimaryKey(id);
		}		
	}
	
	

	public PageResult findPage(Bigques bigques, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		BigquesExample example=new BigquesExample();
		BigquesExample.Criteria criteria = example.createCriteria();
		
		if(bigques!=null){
			if(bigques.getcId()!=null){
				criteria.andCIdEqualTo(bigques.getcId());
			}
			if(bigques.getQcId()!=null){
				criteria.andQcIdEqualTo(bigques.getQcId());
			}
		}
		Page<Bigques> page= (Page<Bigques>)bigquesMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
