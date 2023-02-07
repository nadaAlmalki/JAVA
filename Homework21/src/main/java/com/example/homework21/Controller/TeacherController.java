package com.example.homework21.Controller;

import com.example.homework21.DTO.AddressDetailDTO;
import com.example.homework21.DTO.TeacherDetailDTO;
import com.example.homework21.Model.Address;
import com.example.homework21.Model.Teacher;
import com.example.homework21.Services.Address_Service;
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


    @GetMapping("/get")
    public ResponseEntity getTeacher() {
        List<Teacher> teacher = teacherService.get_Teacher();
        return ResponseEntity.status(200).body(teacher);
    }
    @PostMapping("/addteacher")
    public ResponseEntity add_method(@Valid @RequestBody Teacher teacher, Errors errors){
       teacherService.add_method(teacher);
        return ResponseEntity.status(200).body("Teacher added");
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody TeacherDetailDTO teacher_DTO, Errors errors){
        teacherService.add_teacher(teacher_DTO);
        return ResponseEntity.status(200).body("New Teacher Details is add");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @Valid @RequestBody TeacherDetailDTO teacher_DTO) {

        teacherService.updateTeacherDetails(id,teacher_DTO);
        return ResponseEntity.status(200).body("Teacher deatils updated");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id, Errors errors){

        teacherService.deleteTeacher(id);

        return ResponseEntity.status(200).body("Teacher Details Deleted");
    }


}
