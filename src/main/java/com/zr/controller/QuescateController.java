package com.zr.controller;

import com.zr.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("quescate")
public class QuescateController {
    @Autowired
    private BaseService baseService;

    @RequestMapping("quescateInfo")
    public String quescateInfo(){
        //baseService.
        return "/WEB-INF/admin/quescateInfo.jsp";
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }
}
