package com.shyloostyle.jpaIntegration.controller;

import com.shyloostyle.jpaIntegration.model.Course;
import com.shyloostyle.jpaIntegration.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Integer id){
        Course courseById = courseService.getCourseById(id);
        return new ResponseEntity<>(courseById, HttpStatus.OK);
    }

    @PutMapping("/course/{id}")
    public ResponseEntity<Course> updateCourseById(@PathVariable Integer id, @RequestBody Course updatedCourse) {
        // Fetch the existing course by ID
        Course existingCourse = courseService.getCourseById(id);
        if (existingCourse != null) {
            // Update the details of the existing course
            existingCourse.setName(updatedCourse.getName());
            existingCourse.setPrice(updatedCourse.getPrice());
            existingCourse.setLocation(updatedCourse.getLocation());
            // Save the updated course back to the database
            Course updatedCourseResult = courseService.courseUpdate(existingCourse);

            return new ResponseEntity<>(updatedCourseResult, HttpStatus.OK);
        } else {
            // Return 404 if the course is not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/course/all")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> allCourse = courseService.getAllCourse();
        return new ResponseEntity<>(allCourse, HttpStatus.OK);
    }

    @PostMapping(value = "/create", produces = "application/json",consumes = "application/json")
    public ResponseEntity<Course> creatingCourse(@RequestBody Course course){
        Course courseCreated = courseService.createCourse(course);
        return new ResponseEntity<>(courseCreated,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable  Integer id){
        courseService.deleteById(id);
        return new ResponseEntity<>("Course By:"+id+"deleted",HttpStatus.OK);
    }
}
