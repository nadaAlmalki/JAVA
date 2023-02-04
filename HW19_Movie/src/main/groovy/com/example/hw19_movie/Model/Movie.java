package com.example.hw19_movie.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Movie{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(50) not null")
    @Length(min = 2)
    private String name;


    @Column(columnDefinition = "varchar(30) not null check (genre= 'Drama' or genre='Action' or genre='Comedy')")
    private String genre;

    @Column(columnDefinition = "int not null")
    private Integer rating;


    @Column(columnDefinition = "double not null")
    @Min(60)
    private double duration;



}
