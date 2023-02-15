package com.example.week6_day1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private  String message;

    private Integer userId;


    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private  MyUser myUser;

}


