package com.example.homework21.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(50) not null")
    private String name;

    @Column(columnDefinition = "int not null")
    private Integer age;


    @Column(columnDefinition = "varchar(50) not null")
    private String email;

    @Column(columnDefinition = "int not null")
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn

    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> courses;


}
