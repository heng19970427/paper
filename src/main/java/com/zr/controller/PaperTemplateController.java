package com.zr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("paperTemplate")
public class PaperTemplateController {
    @RequestMapping("showTemp")
    public String showPage(){
        return "paperTemplate";
    }
}
