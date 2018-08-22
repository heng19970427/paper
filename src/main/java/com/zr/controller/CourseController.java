package com.zr.controller;

import com.zr.pojo.Course;
import com.zr.pojo.Knowledge;
import com.zr.pojo.Quescate;
import com.zr.service.BaseService;
import com.zr.service.CourseService;
import com.zr.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("course")
@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private BaseService baseService;

    @Autowired
    private KnowledgeService knowledgeService;
    @RequestMapping("courseInfo")
    public String courseInfo(Course course,Model model){
        List<Course> courseList = courseService.queryAllCourse();
        List<Quescate> quesCateList = baseService.queryQuesCateByCId(String.valueOf(course.getC_id()));
        List<Knowledge> knowledgeList = knowledgeService.queryKnowledgeList(course.getC_id());

        model.addAttribute("courseList",courseList);
        model.addAttribute("quesCateSize",quesCateList.size());
        model.addAttribute("KnowledgeSize",knowledgeList.size());
        return "courseInfo";
    }

    @RequestMapping("addCourse")
    @ResponseBody
    public String addCourse(Course course){
        courseService.addCourse(course);
        return "OK";
    }

    @RequestMapping("deleteCourse")
    @ResponseBody
    public String deleteCourse(int c_id){
        courseService.deleteCourse(c_id);
        return "OK";
    }
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
}
