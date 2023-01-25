package com.example.wekk3_day4.Pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
        @NotEmpty(message = "Pls Enter username: ")
        @Size(min = 3, max = 5, message = "Pls Enter correct username: ")
    private String username;
@NotEmpty(message = "Pls Enter Password: ")
    private String password;

}
