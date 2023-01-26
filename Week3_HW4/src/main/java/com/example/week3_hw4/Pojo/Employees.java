package com.example.week3_hw4.Pojo;


import com.sun.jdi.PrimitiveValue;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@Setter
@Getter
public class Employees {
//ID , name , age , role, onLeave, employmentYear ,annualLeave

    @NotNull(message = "Please Enter your ID: ")
  @Min(2)
    private int ID;

    @NotEmpty(message = "Please Enter your Nmae: ")

    @Size(min = 2, message = "must be more than 3")

    private String name;

    @NonNull
    @NumberFormat
    @Min(value = 26)
    private int age;


    @NotEmpty
    @Pattern(regexp="(Supervisor|Coordinator)",message="Position must be supervisor or coordinator only")
    private String role;



    @AssertFalse
    private boolean onLeave;


    @NotNull
    @Range(min=2014, max = 2023)
    @DateTimeFormat(pattern = "yyyy")
    private int employmentYear;

    @NotNull
    @Max(value = 30, message="Annual Leave must be less than or equal to 30")
    private int annualLeave;

}
