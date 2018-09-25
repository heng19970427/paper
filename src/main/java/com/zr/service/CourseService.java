package com.zr.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zr.dao.CourseMapper;
import com.zr.pojo.Course;
import com.zr.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;

    public void deleteCourse(int[] ids){
        for (int c_id :ids){
            courseMapper.deleteCourse(c_id);
        }
    }

    public void addCourse(Course course){
        courseMapper.insertCourse(course);
    }

    public List<Course> queryAllCourse(){
        return courseMapper.queryAllCourse();
    }

    public Course findOne(int c_id){
        return courseMapper.selectCourseById(c_id);
    }

    public void updateCourse(Course course){
        courseMapper.updateCourse(course);
    }


    /**
     * 按分页查询
     */
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Course> page= (Page<Course>) courseMapper.queryAllCourse();
        return new PageResult(page.getTotal(), page.getResult());
    }


    public List<Map> getCourseOptionList() {
       return courseMapper.selectCourseOptionList();
    }

    public int getCourseNum() {
        return courseMapper.queryAllCourse().size();
    }
}
