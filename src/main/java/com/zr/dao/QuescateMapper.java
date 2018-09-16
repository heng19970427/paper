package com.zr.dao;

import com.zr.pojo.Quescate;
import com.zr.pojo.QuescateExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface QuescateMapper {
    int countByExample(QuescateExample example);

    int deleteByExample(QuescateExample example);

    int deleteByPrimaryKey(Integer qId);

    int insert(Quescate record);

    int insertSelective(Quescate record);

    List<Quescate> selectByExample(QuescateExample example);

    Quescate selectByPrimaryKey(Integer qId);

    int updateByExampleSelective(@Param("record") Quescate record, @Param("example") QuescateExample example);

    int updateByExample(@Param("record") Quescate record, @Param("example") QuescateExample example);

    int updateByPrimaryKeySelective(Quescate record);

    int updateByPrimaryKey(Quescate record);

    List<Map> selectQuescateListSelect();

    List<Map> selectQuescateListSelect(Quescate quescate);
}