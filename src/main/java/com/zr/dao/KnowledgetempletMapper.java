package com.zr.dao;

import com.zr.pojo.Knowledgetemplet;
import com.zr.pojo.KnowledgetempletExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KnowledgetempletMapper {
    int countByExample(KnowledgetempletExample example);

    int deleteByExample(KnowledgetempletExample example);

    int deleteByPrimaryKey(Integer ktId);

    int insert(Knowledgetemplet record);

    int insertSelective(Knowledgetemplet record);

    List<Knowledgetemplet> selectByExample(KnowledgetempletExample example);

    Knowledgetemplet selectByPrimaryKey(Integer ktId);

    int updateByExampleSelective(@Param("record") Knowledgetemplet record, @Param("example") KnowledgetempletExample example);

    int updateByExample(@Param("record") Knowledgetemplet record, @Param("example") KnowledgetempletExample example);

    int updateByPrimaryKeySelective(Knowledgetemplet record);

    int updateByPrimaryKey(Knowledgetemplet record);
}