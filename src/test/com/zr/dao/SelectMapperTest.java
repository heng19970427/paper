package com.zr.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zr.BaseTest;
import com.zr.pojo.Option;
import com.zr.pojo.Selectques;
import com.zr.utils.JsonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectMapperTest extends BaseTest {
    @Autowired
    private SelectquesMapper selectquesMapper;

    @Test
    public void testAdd(){

        Random random=new Random();

        List<Option> optionList=new ArrayList<>();
        optionList.add(new Option("A.测试选项"));
        optionList.add(new Option("B.测试选项"));
        optionList.add(new Option("C.测试选项"));
        optionList.add(new Option("D.测试选项"));
        try{
            for(int i=0;i<200;i++){
                Selectques selectques=new Selectques();
                selectques.setOption(JsonUtil.toJsonString(optionList));
                selectques.setpId(1);
                selectques.setcId(1);
                selectques.setkId(1);
                selectques.setQcId(11);
                selectques.setDifficultylevel(random.nextInt(5)+1);
                selectques.setTitle("请选择正确选项");
                selectques.setAnswer("A");
                selectques.setDescription("测试题目");
                selectques.setSelectednum(0);
                selectquesMapper.insert(selectques);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
