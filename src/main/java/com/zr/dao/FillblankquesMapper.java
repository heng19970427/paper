package com.zr.dao;

import com.zr.pojo.Fillblankques;
import com.zr.pojo.FillblankquesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FillblankquesMapper {
    int countByExample(FillblankquesExample example);

    int deleteByExample(FillblankquesExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(Fillblankques record);

    int insertSelective(Fillblankques record);

    List<Fillblankques> selectByExample(FillblankquesExample example);

    Fillblankques selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") Fillblankques record, @Param("example") FillblankquesExample example);

    int updateByExample(@Param("record") Fillblankques record, @Param("example") FillblankquesExample example);

    int updateByPrimaryKeySelective(Fillblankques record);

    int updateByPrimaryKey(Fillblankques record);
}