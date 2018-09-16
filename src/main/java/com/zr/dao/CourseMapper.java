package com.zr.dao;

import com.zr.pojo.Course;

import java.util.List;
import java.util.Map;

public interface CourseMapper {
    void insertCourse(Course course);

    void deleteCourse(int c_id);

    void updateCourse(Course course);

    List<Course> queryAllCourse();

    Course selectCourseById(int c_id);

    List<Map> selectCourseOptionList();
}
