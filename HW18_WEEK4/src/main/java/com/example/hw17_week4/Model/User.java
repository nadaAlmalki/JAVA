package com.example.hw17_week4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(50) not null")
    private String name;

    @Column(columnDefinition = "varchar(50) not null unique")
    private String username;

    @Column(columnDefinition = "varchar(6) not null")
    private String password;
    @Column(columnDefinition = "varchar(30) not null unique")
    @Email
    private String email;
    @Column(columnDefinition = "varchar(30) not null check (role= 'Admin' or role='User')")
    private String role;

    @Column(columnDefinition = "int not null")
    private Integer age;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
