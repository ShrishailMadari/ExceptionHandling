package com.shyloostyle.jpaIntegration.service;

import com.shyloostyle.jpaIntegration.model.Course;

import java.util.List;

public interface CourseService {
    Course getCourseById(Integer id);
    List<Course> getAllCourse();
    Course createCourse(Course course);
    void deleteById(Integer id);
    Course courseUpdate(Course course);
}
