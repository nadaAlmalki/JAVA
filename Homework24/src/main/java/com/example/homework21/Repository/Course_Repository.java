package com.example.homework21.Repository;

import com.example.homework21.Model.Course;
import com.example.homework21.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface Course_Repository extends JpaRepository<Course, Integer> {
    Course findCourseById(Integer id);

     /* @Query("")
    List<Course> getStudentCourses(Long studentId);*/
    Course deleteCourseById(Integer id);

   Course deleteCoursesByStudentId(Integer id);



}
