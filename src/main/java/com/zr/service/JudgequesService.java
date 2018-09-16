package com.zr.service;
import java.util.List;

import com.github.pagehelper.Page;
import com.zr.dao.JudgequesMapper;
import com.zr.pojo.Judgeques;
import com.zr.pojo.JudgequesExample;
import com.zr.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class JudgequesService {

	@Autowired
	private JudgequesMapper judgequesMapper;
	
	/**
	 * 查询全部
	 */
	public List<Judgeques> findAll() {
		return judgequesMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Judgeques> page=   (Page<Judgeques>) judgequesMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */

	public void add(Judgeques judgeques) {
		judgequesMapper.insert(judgeques);		
	}

	
	/**
	 * 修改
	 */

	public void update(Judgeques judgeques){
		judgequesMapper.updateByPrimaryKey(judgeques);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Judgeques findOne(Integer id){
		return judgequesMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			judgequesMapper.deleteByPrimaryKey(id);
		}		
	}

	public PageResult findPage(Judgeques judgeques, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		JudgequesExample example=new JudgequesExample();
		JudgequesExample.Criteria criteria = example.createCriteria();
		
		if(judgeques!=null){			
						if(judgeques.getTitle()!=null && judgeques.getTitle().length()>0){
				criteria.andTitleLike("%"+judgeques.getTitle()+"%");
			}
			if(judgeques.getAnswer()!=null && judgeques.getAnswer().length()>0){
				criteria.andAnswerLike("%"+judgeques.getAnswer()+"%");
			}
			if(judgeques.getDescription()!=null && judgeques.getDescription().length()>0){
				criteria.andDescriptionLike("%"+judgeques.getDescription()+"%");
			}
	
		}
		
		Page<Judgeques> page= (Page<Judgeques>)judgequesMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
