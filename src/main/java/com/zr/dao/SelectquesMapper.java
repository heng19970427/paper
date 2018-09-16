package com.zr.dao;

import com.zr.pojo.Selectques;
import com.zr.pojo.SelectquesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SelectquesMapper {
    int countByExample(SelectquesExample example);

    int deleteByExample(SelectquesExample example);

    int deleteByPrimaryKey(Integer sId);

    int insert(Selectques record);

    int insertSelective(Selectques record);

    List<Selectques> selectByExample(SelectquesExample example);

    Selectques selectByPrimaryKey(Integer sId);

    int updateByExampleSelective(@Param("record") Selectques record, @Param("example") SelectquesExample example);

    int updateByExample(@Param("record") Selectques record, @Param("example") SelectquesExample example);

    int updateByPrimaryKeySelective(Selectques record);

    int updateByPrimaryKey(Selectques record);
}