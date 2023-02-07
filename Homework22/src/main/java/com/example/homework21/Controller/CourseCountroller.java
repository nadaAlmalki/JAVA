package com.example.homework21.Controller;

import com.example.homework21.Model.Course;
import com.example.homework21.Model.Teacher;
import com.example.homework21.Services.Address_Service;
import com.example.homework21.Services.Course_Service;
import com.example.homework21.Services.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseCountroller {
    private final Course_Service course_service;
    private final TeacherService teacherService;
    private final Address_Service address_service;


    @GetMapping("/get")
    public ResponseEntity getcourse() {
       List<Course> courses = course_service.getCourses();
        return ResponseEntity.status(200).body(courses);
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course, Errors errors){
        course_service.addCourses(course);
        return ResponseEntity.status(200).body("courses added");
    }


   @PutMapping("/update/{id}")
 public ResponseEntity updateCourse(@PathVariable Integer id, @Valid @RequestBody Course courses){
        course_service.updateCourses(id, courses);
       return ResponseEntity.status(200).body("Courses updated");
   }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){

        course_service.deleteCourse(id);

        return ResponseEntity.status(200).body("Courses Deleted");
    }

}


