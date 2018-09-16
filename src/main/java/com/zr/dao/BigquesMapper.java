package com.zr.dao;

import com.zr.pojo.Bigques;
import com.zr.pojo.BigquesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BigquesMapper {
    int countByExample(BigquesExample example);

    int deleteByExample(BigquesExample example);

    int deleteByPrimaryKey(Integer bId);

    int insert(Bigques record);

    int insertSelective(Bigques record);

    List<Bigques> selectByExample(BigquesExample example);

    Bigques selectByPrimaryKey(Integer bId);

    int updateByExampleSelective(@Param("record") Bigques record, @Param("example") BigquesExample example);

    int updateByExample(@Param("record") Bigques record, @Param("example") BigquesExample example);

    int updateByPrimaryKeySelective(Bigques record);

    int updateByPrimaryKey(Bigques record);
}