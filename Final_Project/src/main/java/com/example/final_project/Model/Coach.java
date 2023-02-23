package com.example.final_project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(30) not null")
    private String name;
    @Column(columnDefinition = "varchar(30) not null")
    private String phone_number;
    @Column(columnDefinition = "varchar(30) not null")
    private String license;
    @Column(columnDefinition = "int not null")
    private Integer year_of_experience;
    @Column(columnDefinition = "double not null")
    private double price;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coach")
    private List<Orter_table> orders;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coach")
    private List<Reviews> reviews;
}
