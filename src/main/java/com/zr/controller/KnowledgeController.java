package com.zr.controller;

import com.zr.pojo.Course;
import com.zr.pojo.Knowledge;
import com.zr.service.CourseService;
import com.zr.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("knowledge")
public class KnowledgeController {
    @Autowired
    private KnowledgeService knowledgeService;


    @Autowired
    private CourseService courseService;

    @RequestMapping("knowledgeInfo")
    public String knowledgeInfo(Model model,Integer c_id) {
        List<Knowledge> knowledgeList = knowledgeService.queryKnowledgeList(c_id);
        List<Course> courseList = courseService.queryAllCourse();

        model.addAttribute("knowledgeList",knowledgeList);
        model.addAttribute("courseList",courseList);
        return "knowledgeInfo";
    }

    @RequestMapping("getAllKnowledge")
    @ResponseBody
    public List<Knowledge> getAllKnowledge(){
        return knowledgeService.getAllKnowledge();
    }

    @RequestMapping("deleteKnowledge")
    @ResponseBody
    public String deleteKnowledge(int k_id){
        knowledgeService.deleteKnowledge(k_id);
        return "OK";
    }

    @RequestMapping("addKnowledge")
    @ResponseBody
    public String addKnowledge(Knowledge knowledge){
        knowledgeService.addKnowledge(knowledge);
        return "OK";
    }

    public void setKnowledgeService(KnowledgeService knowledgeService) {
        this.knowledgeService = knowledgeService;
    }



    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
}
