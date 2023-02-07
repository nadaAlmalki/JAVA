package com.example.homework21.Repository;

import com.example.homework21.Model.Course;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Course_Repository extends JpaRepository<Course, Integer> {
    Course findCourseById(Integer id);
}
