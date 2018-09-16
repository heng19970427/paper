package com.zr.service;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zr.dao.CourseMapper;
import com.zr.dao.QuescateMapper;
import com.zr.pojo.Course;
import com.zr.pojo.PageResult;
import com.zr.pojo.Quescate;
import com.zr.pojo.QuescateExample;
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

	@Autowired
    private CourseMapper courseMapper;
	/**
	 * 查询全部
	 */
	public List<Quescate> findAll() {
		return quescateMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */

	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<Quescate> page=   (Page<Quescate>) quescateMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
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


	public PageResult findPage(Quescate quescate, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		QuescateExample example=new QuescateExample();
		QuescateExample.Criteria criteria = example.createCriteria();
		if(quescate!=null){
			if(quescate.getcId()!=null){
				criteria.andCIdEqualTo(quescate.getcId());
			}

		}

        List<Quescate> quescateList = quescateMapper.selectByExample(example);
		for (Quescate quescate1:quescateList){
            Course course = courseMapper.selectCourseById(quescate1.getcId());
            quescate1.setCourse(course);
        }
        Page<Quescate> page= (Page<Quescate>)quescateList;
		return new PageResult(page.getTotal(), page.getResult());
	}


	public List<Map> getQuescateListSelect(Quescate quescate) {
		return quescateMapper.selectQuescateListSelect(quescate);
	}
}
