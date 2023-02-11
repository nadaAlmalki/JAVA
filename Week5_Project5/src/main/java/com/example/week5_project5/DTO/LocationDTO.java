package com.example.week5_project5.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocationDTO {
    private Integer store_id;
    private String area;
    private String street;


}
