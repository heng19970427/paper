package com.zr.service;
import java.util.List;

import com.zr.dao.QuescateMapper;
import com.zr.pojo.Quescate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class QuescateServiceImpl {

	@Autowired
	private QuescateMapper quescateMapper;
	
	/**
	 * 查询全部
	 */
	public List<Quescate> findAll() {
		return quescateMapper.selectByExample(null);
	}

	/**
	 * 增加
	 */

	public void add(Quescate quescate) {
		quescateMapper.insert(quescate);		
	}

	
	/**
	 * 修改
	 */

	public void update(Quescate quescate){
		quescateMapper.updateByPrimaryKey(quescate);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */

	public Quescate findOne(int id){
		return quescateMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */

	public void delete(int[] ids) {
		for(int id:ids){
			quescateMapper.deleteByPrimaryKey(id);
		}		
	}
}
