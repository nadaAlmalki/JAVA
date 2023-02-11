package com.example.week5_project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(50) not null")
    private String name;
    @Column(columnDefinition = "varchar(50) not null")
    private String phoneNumber;

    @Column(columnDefinition = "varchar(50) not null")
    private String email;


    @ManyToMany
    @JsonIgnore
    private List<Store> store;
}
