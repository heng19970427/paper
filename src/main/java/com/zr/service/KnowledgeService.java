package com.zr.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zr.dao.CourseMapper;
import com.zr.dao.KnowledgeMapper;
import com.zr.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class KnowledgeService {
    @Autowired
    private KnowledgeMapper knowledgeMapper;

    @Autowired
    private CourseMapper courseMapper;

    public List<Knowledge> getAllKnowledge(){
        return knowledgeMapper.selectByExample(null);
    }

    public void addKnowledge(Knowledge knowledge){
        knowledgeMapper.insert(knowledge);
    }

    public void deleteKnowledge(int[] ids){
        for (int i=0;i<ids.length;i++){
            knowledgeMapper.deleteByPrimaryKey(ids[i]);
        }

    }

    public void updateKnowledge(Knowledge knowledge){
        knowledgeMapper.updateByPrimaryKey(knowledge);
    }

    public List<Knowledge> queryKnowledgeList(Integer c_id){
        KnowledgeExample knowledgeExample=new KnowledgeExample();
        KnowledgeExample.Criteria criteria = knowledgeExample.createCriteria();
        criteria.andCIdEqualTo(c_id);
        return knowledgeMapper.selectByExample(knowledgeExample);
    }

    public PageResult findPage(Knowledge knowledge, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        if(knowledge!=null){
            if(knowledge.getcId()!=null){
                KnowledgeExample knowledgeExample=new KnowledgeExample();
                KnowledgeExample.Criteria criteria = knowledgeExample.createCriteria();
                criteria.andCIdEqualTo(knowledge.getcId());
                Page<Knowledge> page= (Page<Knowledge>)knowledgeMapper.selectByExample(knowledgeExample);
                return new PageResult(page.getTotal(), page.getResult());
            }
        }
        List<Knowledge> knowledgeList = knowledgeMapper.selectByExample(null);
        for(Knowledge knowledge1:knowledgeList){
            Course course = courseMapper.selectCourseById(knowledge1.getcId());
            knowledge1.setCourse(course);
        }
        Page<Knowledge> page= (Page<Knowledge>)knowledgeList;
        return new PageResult(page.getTotal(), page.getResult());
    }

    public Knowledge findOne(int id){
        Knowledge knowledge = knowledgeMapper.selectByPrimaryKey(id);
        Course course = courseMapper.selectCourseById(knowledge.getcId());
        knowledge.setCourse(course);
        return knowledge;
    }

    public List<Map> getKnowledgeOption(Knowledge knowledge){
        return knowledgeMapper.selectKnowledgeOption(knowledge);
    }

}
