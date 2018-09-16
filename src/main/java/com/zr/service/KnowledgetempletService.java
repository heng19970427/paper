package com.zr.service;
import java.util.ArrayList;
import java.util.List;

import com.zr.dao.KnowledgeMapper;
import com.zr.dao.KnowledgetempletMapper;
import com.zr.pojo.Knowledge;
import com.zr.pojo.KnowledgetempletExample;
import com.zr.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zr.pojo.Knowledgetemplet;
import org.springframework.stereotype.Service;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class KnowledgetempletService{

	@Autowired
	private KnowledgetempletMapper knowledgetempletMapper;

	@Autowired
	private KnowledgeMapper knowledgeMapper;
	/**
	 * 查询全部
	 */

	public List<Knowledgetemplet> findAll() {
		return knowledgetempletMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Knowledgetemplet> page=   (Page<Knowledgetemplet>) knowledgetempletMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	public void add(Knowledgetemplet knowledgetemplet) {
		knowledgetempletMapper.insert(knowledgetemplet);		
	}

	
	/**
	 * 修改
	 */
	public void update(Knowledgetemplet knowledgetemplet){
		knowledgetempletMapper.updateByPrimaryKey(knowledgetemplet);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Knowledgetemplet findOne(Integer id){
		return knowledgetempletMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			knowledgetempletMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
	/**
	* @Description: 分页
	* @Param: [knowledgetemplet, pageNum, pageSize]
	* @return: com.zr.pojo.PageResult
	* @Author: Zr
	* @Date: 2018/8/31
	*/
	public PageResult findPage(Knowledgetemplet knowledgetemplet, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		KnowledgetempletExample example=new KnowledgetempletExample();
		KnowledgetempletExample.Criteria criteria = example.createCriteria();
		
		if(knowledgetemplet!=null){			
				
		}
		
		Page<Knowledgetemplet> page= (Page<Knowledgetemplet>)knowledgetempletMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}


    public void adds(List<Knowledgetemplet> knowledgetemplets) {
		for (Knowledgetemplet knowTemp:knowledgetemplets){
			knowledgetempletMapper.insert(knowTemp);
		}
    }

    public List<Knowledgetemplet> updateKnow(Integer[] kIds){
        List<Knowledgetemplet> knowledgetempletList=new ArrayList<Knowledgetemplet>();
        for(int i=0;i<kIds.length;i++){
            Knowledge knowledge = knowledgeMapper.selectByPrimaryKey(kIds[i]);
            Knowledgetemplet knowledgetemplet=new Knowledgetemplet();
            knowledgetemplet.setKnowledge(knowledge);
            knowledgetempletList.add(knowledgetemplet);
        }
        return knowledgetempletList;
    }
}
