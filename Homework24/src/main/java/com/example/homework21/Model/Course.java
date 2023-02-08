package com.example.homework21.Model;

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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(50) not null")
    private String name;


    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    @JsonIgnore
    private Teacher teacher;


    @ManyToMany(cascade =CascadeType.ALL, mappedBy = "course")
    private List<Student> student;
}
