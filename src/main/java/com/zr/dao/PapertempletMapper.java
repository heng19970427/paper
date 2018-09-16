package com.zr.dao;

import com.zr.pojo.Papertemplet;
import com.zr.pojo.PapertempletExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PapertempletMapper {
    int countByExample(PapertempletExample example);

    int deleteByExample(PapertempletExample example);

    int deleteByPrimaryKey(Integer ptId);

    int insert(Papertemplet record);

    int insertSelective(Papertemplet record);

    List<Papertemplet> selectByExample(PapertempletExample example);

    Papertemplet selectByPrimaryKey(Integer ptId);

    int updateByExampleSelective(@Param("record") Papertemplet record, @Param("example") PapertempletExample example);

    int updateByExample(@Param("record") Papertemplet record, @Param("example") PapertempletExample example);

    int updateByPrimaryKeySelective(Papertemplet record);

    int updateByPrimaryKey(Papertemplet record);
}