package com.example.centralpharmacy.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "int not null")
    private Integer patientid;

    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @Column(columnDefinition = "varchar(30) not null")
    private String location;



}
