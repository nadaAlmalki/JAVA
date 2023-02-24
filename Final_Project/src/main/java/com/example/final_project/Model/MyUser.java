package com.example.final_project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class MyUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(30) not null unique")
    private String username;
    //@Column(columnDefinition = "varchar(6) not null unique")
    private String password;

    @Column(columnDefinition = "varchar(30) not null check (role= 'User' or role='Admin')")
    private String role;

}
