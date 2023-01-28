package com.example.week3_project.Pojo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
@AllArgsConstructor
public class Product_Pojo {

    @NotEmpty
    /*@Size(min = 1, max = 3)*/
    @Length(max = 3)
    private String pro_id;
    @NotEmpty
   // @Size(max = 3)
    @Length(max = 3)
    private String name;
    @NotNull
    @Positive
    private int price;
    @NotEmpty
    //@Size(min = 1, max = 3)
    @Length(max = 3)
    private String categoryID;
}
