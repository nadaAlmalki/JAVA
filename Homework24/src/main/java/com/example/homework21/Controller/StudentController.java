package com.example.homework21.Controller;

import com.example.homework21.Model.Student;
import com.example.homework21.Model.Teacher;
import com.example.homework21.Services.Course_Service;
import com.example.homework21.Services.Student_Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.naming.ldap.PagedResultsControl;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final Student_Service student_service;
    private final Course_Service course_service;


    @GetMapping("/get")
    public ResponseEntity getStudent() {
        List<Student > student = student_service.getStudent();
        return ResponseEntity.status(200).body(student);
    }


    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student, Errors errors) {
        student_service.addStudent(student);
        return ResponseEntity.status(200).body("student added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updatStudent(@PathVariable Integer id, @Valid @RequestBody  Student student) {
        student_service.updatStudent(id, student);
        return ResponseEntity.status(200).body("student deatils updated");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {

        student_service.deleteStudent(id);

        return ResponseEntity.status(200).body("student Details Deleted");
    }


    //Create endpoint that takes class id and return the student list
    @GetMapping("/liststd/{course_id}")
    public ResponseEntity ListStudents(@PathVariable Integer course_id) {
        List<Student> student = student_service.ListStudents(course_id);
        return ResponseEntity.status(200).body(student);
    }

    @PutMapping("/update/{id}/{major}")
    //Create endpoint that takes student id and major and change the student major ( changing the major will drop all the cousres that the student attended to )
    public ResponseEntity updatMajor(@PathVariable Integer id, @PathVariable String major, @Valid @RequestBody  Student student){

            student_service.updatMajor(id, major, student);
            return ResponseEntity.status(200).body("student deatils updated");

        }
    }
