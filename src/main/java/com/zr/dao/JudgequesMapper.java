package com.zr.dao;

import com.zr.pojo.Judgeques;
import com.zr.pojo.JudgequesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JudgequesMapper {
    int countByExample(JudgequesExample example);

    int deleteByExample(JudgequesExample example);

    int deleteByPrimaryKey(Integer jId);

    int insert(Judgeques record);

    int insertSelective(Judgeques record);

    List<Judgeques> selectByExample(JudgequesExample example);

    Judgeques selectByPrimaryKey(Integer jId);

    int updateByExampleSelective(@Param("record") Judgeques record, @Param("example") JudgequesExample example);

    int updateByExample(@Param("record") Judgeques record, @Param("example") JudgequesExample example);

    int updateByPrimaryKeySelective(Judgeques record);

    int updateByPrimaryKey(Judgeques record);
}