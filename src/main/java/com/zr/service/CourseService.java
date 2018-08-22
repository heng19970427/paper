package com.zr.service;

import com.zr.dao.CourseMapper;
import com.zr.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;

    public void deleteCourse(int c_id){
        courseMapper.deleteCourse(c_id);
    }

    public void addCourse(Course course){
        courseMapper.insertCourse(course);
    }

    public List<Course> queryAllCourse(){
        return courseMapper.queryAllCourse();
    }

    public void updateCourse(Course course){
        courseMapper.updateCourse(course);
    }

    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }
}
