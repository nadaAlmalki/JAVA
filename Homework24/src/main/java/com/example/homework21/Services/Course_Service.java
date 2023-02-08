package com.example.homework21.Services;

import com.example.homework21.ApiException;
import com.example.homework21.Model.Course;
import com.example.homework21.Model.Student;
import com.example.homework21.Repository.Course_Repository;
import com.example.homework21.Repository.Student_Repository;
import com.example.homework21.Repository.Teacher_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Course_Service {

    private final Course_Repository course_repository;
    private final Teacher_Repository teacher_repository;
    private final Student_Repository student_repository;

    public List<Course> getCourses() {
        return course_repository.findAll();
    }

    public void addCourses(Course course) {
        course_repository.save(course);
    }

    public void updateCourses(Integer id, Course courses) {
        Course course = course_repository.findCourseById(id);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        course.setName(courses.getName());
        course_repository.save(course);
    }

    public void deleteCourse(Integer id) {
        Course course = course_repository.findCourseById(id);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        course_repository.delete(course);
    }


    public void assignCourseToStudent(Integer student_id, Integer course_id) {
        Student student = student_repository.findStudentById(student_id);
        Course course = course_repository.findCourseById(course_id);
        if (student == null || course == null) {
            throw new ApiException("Wrong Data");
        }
        student.getCourse().add(course);
        course.getStudent().add(student);
        student_repository.save(student);
        course_repository.save(course);
    }




}