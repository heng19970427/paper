package com.zr.dao;

import com.zr.pojo.*;

import java.util.List;

public interface BaseMapper{
    //查询所有科目
    List<Course> queryAllCourse();
    //查询所有试题类型
    List<ProbCate> queryAllProbCate();
    //根据课程id查询所有知识点
    List<Knowledge> queryKnowledgeList(String c_id);
    //根据c_id和p_id查询具体类型集合
    List<QuesCate> queryQuesCate(QueryVo qv);
    //根据c_id查询具体类型集合
    List<QuesCate> queryQuesCateByCId(String c_id);
    //根据q_id查询具体类型
    QuesCate queryQuesCateByQId(String q_id);
    //根据名字或k_id查询知识点
    Knowledge queryKnowledge(String knowledgeName);
}
