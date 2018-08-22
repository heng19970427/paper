package com.zr.dao;

import com.zr.pojo.Course;

import java.util.List;

public interface CourseMapper {
    void insertCourse(Course course);

    void deleteCourse(int c_id);

    void updateCourse(Course course);

    List<Course> queryAllCourse();
}
