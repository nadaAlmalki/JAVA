package com.example.homework21.DTO;

import com.example.homework21.Model.Teacher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDetailDTO {


    private Integer teacher_id;
    private String area;

    private String street;

    private Integer buildingNumber;


}
