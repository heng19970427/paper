package com.zr.dao;

import com.zr.BaseTest;
import com.zr.pojo.Bigques;
import com.zr.pojo.Option;
import com.zr.pojo.Selectques;
import com.zr.utils.JsonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BigMapperTest extends BaseTest{

    @Autowired
    private BigquesMapper bigquesMapper;

    @Test
    public void testAdd(){

        Random random=new Random();

        List<Option> optionList=new ArrayList<>();
        optionList.add(new Option("第一小题"));
        optionList.add(new Option("第二小题"));
        optionList.add(new Option("第三小题"));
        try{
            for(int i=0;i<200;i++){
                Bigques bigques=new Bigques();
                bigques.setOption(JsonUtil.toJsonString(optionList));
                bigques.setpId(4);
                bigques.setcId(1);
                bigques.setkId(1);
                bigques.setQcId(11);
                bigques.setDifficultylevel(random.nextInt(5)+1);
                bigques.setTitle("编写程序实现对给定的 4 个整数从大到小的顺序排列。");
                bigques.setAnswer("public class HomeWork01 {\n" +
                        "    static int number=4;        //输入4个数存放在数组中                   \n" +
                        "    static int[] t1 = new int[number];           \n" +
                        "    public static void main(String[] args) {\n" +
                        "        HomeWork01 jiejie=new HomeWork01();\n" +
                        "        jiejie.shunxun();\n" +
                        "    }");
                bigques.setDescription("测试题目");
                bigques.setSelectednum(0);
                bigquesMapper.insert(bigques);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
