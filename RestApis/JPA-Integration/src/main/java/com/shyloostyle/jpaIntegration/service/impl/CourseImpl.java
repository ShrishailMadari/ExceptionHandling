package com.shyloostyle.jpaIntegration.service.impl;

import com.shyloostyle.jpaIntegration.model.Course;
import com.shyloostyle.jpaIntegration.repository.CourseRepository;
import com.shyloostyle.jpaIntegration.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course createCourse(Course course) {
        System.out.println("Data saved");
        if (course != null){
        return courseRepository.save(course);
    }
        return course;
    }

    @Override
    public void deleteById(Integer id) {
        courseRepository.deleteById(id);
        System.out.println("course deleted");
    }

    @Override
    public Course courseUpdate(Course course) {
        return courseRepository.save(course);
    }

}
