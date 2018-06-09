package com.zr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("error")
public class ErrorController {

    @RequestMapping("notFound")
    public String notFound(){
        return "erroe404";
    }

    @RequestMapping("badRequest")
    public String badRequest(){
        return "error400";
    }

    @RequestMapping("severError")
    public String serverError(){
        return "error500";
    }
}
