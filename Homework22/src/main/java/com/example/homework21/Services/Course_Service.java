package com.example.homework21.Services;

import com.example.homework21.ApiException;
import com.example.homework21.Controller.CourseCountroller;
import com.example.homework21.Model.Course;
import com.example.homework21.Model.Teacher;
import com.example.homework21.Repository.Course_Repository;
import com.example.homework21.Repository.Teacher_Repository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Course_Service {

    private final Course_Repository course_repository;
    private final Teacher_Repository teacher_repository;

    public List<Course> getCourses() {
        return course_repository.findAll();
    }
    public void addCourses( Course course){
        course_repository.save(course);
    }

    public void updateCourses(Integer id, Course courses){
        Course course = course_repository.findCourseById(id);
        if(course == null)
        {
            throw  new ApiException("Course not found");
        }
        course.setName(courses.getName());
         course_repository.save(course);
    }

    public void deleteCourse(Integer id){
        Course course = course_repository.findCourseById(id);
        if(course == null)
        {
            throw  new ApiException("Course not found");
        }
        course_repository.delete(course);
    }


}
