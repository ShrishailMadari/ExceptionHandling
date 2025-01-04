package com.shyloostyle.jpaIntegration.repository;

import com.shyloostyle.jpaIntegration.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public interface CourseRepository extends JpaRepository<Course, Serializable> {
}
