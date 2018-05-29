package com.zr.test;

import com.zr.pojo.QuesCate;
import com.zr.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class ServiceTest {
    @Autowired
    QuestionService service;

    @Test
    public void test1(){
        for (QuesCate cate : service.queryQuesCate()) {
            System.out.println(cate);
        }
    }


    public QuestionService getService() {
        return service;
    }

    public void setService(QuestionService service) {
        this.service = service;
    }
}
