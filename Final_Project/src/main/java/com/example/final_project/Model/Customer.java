package com.example.final_project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(30) not null")
    private String name;
    @Column(columnDefinition = "varchar(10) not null")
    private String phone_number;
    @Column(columnDefinition = "int not null")
    private Integer age;
    @Column(columnDefinition = "int not null")
    private Integer length;
    @Column(columnDefinition = "int not null")
    private Integer weight;
    @Column(columnDefinition = "varchar(30) not null")
    private String health_problem;
    @Column(columnDefinition = "varchar(30) not null")
    private String city;
    @Column(columnDefinition = "varchar(30) not null")
    private String address;


}
