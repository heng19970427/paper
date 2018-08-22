package com.zr.dao;


import com.zr.pojo.Knowledge;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KnowledgeMapper {
    List<Knowledge> queryAllKnowledge();

    void deleteKnowledge(int k_id);

    void insertKnowledge(Knowledge knowledge);

    void updateKnowledge(Knowledge knowledge);

    //根据课程id查询所有知识点
    List<Knowledge> queryKnowledgeList(@Param("c_id") Integer c_id);
}
