package com.example.homework21.DTO;

import com.example.homework21.Model.Address;
import com.example.homework21.Model.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherDetailDTO {

    private Integer teacher_id;
    private Integer age;
    private String email;
    private Integer salary;




}
