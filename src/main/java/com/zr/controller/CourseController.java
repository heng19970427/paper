package com.zr.controller;

import com.zr.pojo.*;
import com.zr.service.CourseService;
import com.zr.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("course")
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("update")
    public Response update(@RequestBody Course course){
        try {
            courseService.updateCourse(course);
            return new Response(true ,"更新成功");
        }catch (Exception e){
            return new Response(false,"更新失败");
        }

    }

    @RequestMapping("findAll")
    public List<Course> findAll(){
        return courseService.queryAllCourse();
    }

    @RequestMapping("findOne")
    public Course findOne(int id){
        return courseService.findOne(id);
    }

    @RequestMapping("addCourse")
    public Response addCourse(@RequestBody Course course){
        try {
            courseService.addCourse(course);
            return new Response(true,"更新成功");
        }catch (Exception e){
            return new Response(true,"更新失败");
        }
    }

    @RequestMapping("deleteCourse")
    public String deleteCourse(int[] ids){
        courseService.deleteCourse(ids);
        return "OK";
    }

    /**
     * 查询+分页
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(int page, int rows){
        return courseService.findPage( page, rows);
    }

    @RequestMapping("getCourseOptionList")
    public List<Map> getCourseOptionList(){
        List<Map> courseOptionList = courseService.getCourseOptionList();
        return courseOptionList;
    }

    @RequestMapping("getCourseNum")
    public int getCourseNum(){
        return courseService.getCourseNum();
    }

}

