package com.example.week3_project.Pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category_Pojo {

    @NotEmpty
    @Size(max = 3)
    private String cat_id;


    @NotEmpty
    @Size(max = 3)
    private String name;
}
