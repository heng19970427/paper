package com.zr.controller;

import com.zr.pojo.Course;
import com.zr.pojo.Knowledge;
import com.zr.pojo.PaperTemplet;
import com.zr.service.BaseService;
import com.zr.service.PaperTempletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
@RequestMapping("paperTemplate")
public class PaperTemplateController {
    @Autowired
    private PaperTempletService templetService;

    @Autowired
    ServletContext servletContext;

    @Autowired
    private BaseService baseService;

    @RequestMapping("showTemp")
    public String showPage(String c_id,Model model){
        List<Course> courseList=baseService.queryAllCourse();
        List<PaperTemplet> paperTempletList=templetService.queryAllPaperTemp(c_id);

        model.addAttribute("courseList",courseList);
        model.addAttribute("paperTempletList",paperTempletList);

        return "paperTemplate";
    }

    @RequestMapping("createTemp1")
    public @ResponseBody
    List<Knowledge> createTemp1(PaperTemplet paperTemplet){
        servletContext.setAttribute("paperTemplet",paperTemplet);
        return templetService.createTemp1(String.valueOf(paperTemplet.getCourse().getC_id()));
    }

    @RequestMapping("createTemp2")
    public @ResponseBody
    String createTemp2(PaperTemplet paperTemplet2){
        PaperTemplet paperTemplet1= (PaperTemplet) servletContext.getAttribute("paperTemplet");
        //将知识点模板封装到试卷模板
        paperTemplet1.setKnowledgeTemplets(paperTemplet2.getKnowledgeTemplets());
        //将试卷模板持久化
        templetService.saveTemplet(paperTemplet1);
        //清空appliction域的模板
        servletContext.removeAttribute("paperTemplet");
        return "OK";
    }

    @RequestMapping("delTemp")
    public @ResponseBody
    String delTemp(String pt_id){
        templetService.delTemp(pt_id);
        return "OK";
    }

    @RequestMapping("editTemp")
    public @ResponseBody
    String editTemp(String pt_id){
        PaperTemplet paperTemplet=templetService.editTemp(pt_id);
        return "OK";
    }



    public PaperTempletService getTempletService() {
        return templetService;
    }

    public void setTempletService(PaperTempletService templetService) {
        this.templetService = templetService;
    }
}
