package com.example.homework21.Controller;

import com.example.homework21.ApiException;
import com.example.homework21.DTO.AddressDetailDTO;
import com.example.homework21.Model.Address;
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
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    private final Address_Service address_service;

    private final Course_Service course_service;


    @GetMapping("/get")
    public ResponseEntity getTeacher() {
        List<Teacher> teacher = teacherService.get_Teacher();
        return ResponseEntity.status(200).body(teacher);
    }


    @PostMapping("/add")
    public ResponseEntity add_method(@Valid @RequestBody Teacher teacher, Errors errors) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @Valid @RequestBody Teacher teacher) {
        teacherService.updatTeacher(id, teacher);
        return ResponseEntity.status(200).body("Teacher deatils updated");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {

        teacherService.deleteTeacher(id);

        return ResponseEntity.status(200).body("Teacher Details Deleted");
    }


    //Add Address Details to Teacher
    @PostMapping("/Address")
    public ResponseEntity add_details(@Valid @RequestBody AddressDetailDTO address_DTO, Errors errors) {
        teacherService.add_details(address_DTO);
        return ResponseEntity.status(200).body("Teacher Address added");
    }

    //Upadte Teacher Address Details
    @PutMapping("/updateadress/{id}")
    public ResponseEntity<String> updateTeacherAddress(@Valid @RequestBody AddressDetailDTO addressDTO, @PathVariable Integer id) {
        teacherService.updateTeacherAddress(addressDTO, id);
        return ResponseEntity.status(200).body("Teacher Address added");
    }

    //Delete Teacher Address Details
    @PutMapping("/deleteadress/{id}")
    public ResponseEntity deleteTeacherAddress(@PathVariable Integer id) {
        teacherService.deleteTeacherAddress(id);
        return ResponseEntity.status(200).body("Teacher Address deleted");
    }
    //Create endpoint that takes teacher id and return All teacher details

    @GetMapping("/getDeatails/{id}")
    public ResponseEntity get_TeacherDetails(@Valid @RequestBody AddressDetailDTO addressDTO, @PathVariable Integer id) {
        List<Teacher> teacher = teacherService.get_TeacherDetails(id, addressDTO);
        return ResponseEntity.status(200).body(teacher);
    }

    @PutMapping("/{course_id}/teachcer/{teacher_id}")
    public ResponseEntity CoursesTeachByTeacher(@PathVariable Integer teacher_id, @PathVariable Integer course_id) {
        teacherService.CoursesTeachByTeacher(teacher_id, course_id);
        return ResponseEntity.status(200).body("Every teacher have many courses");

    }

    //Create endpoint that take course id and return the teacher name for that class
    @GetMapping("/search/{course_id}/{teacher_id}")

    public ResponseEntity SearchByCoursId(@PathVariable Integer teacher_id, @PathVariable Integer course_id) {
        Teacher teacher = teacherService.SearchByCoursId(teacher_id, course_id);
        return ResponseEntity.status(200).body(teacher.getName());


    }
}