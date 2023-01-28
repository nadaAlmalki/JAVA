package com.example.week3_project.Pojo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Bean;

@Data
@AllArgsConstructor
public class UserPojo{

    @NotEmpty
    @Size(max = 3)
    private String user_id;


    @NotEmpty
    @Length(min = 1,  max = 5)
    private String username ;

    @NotEmpty
    @Size(min = 3, max = 6)
    private String password;


    @NotEmpty
   // @Pattern(regexp = "a-z@a-z.a-z")
    private String email;

    @NotEmpty
    @Pattern(regexp="(Admin|Customer)",message="Position must be Admin or Customer only")
    private String role;


    @NotNull
    @Positive
    private int balance;



}
