package com.example.week6_hw27.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
  // @Column(unique = true, columnDefinition = "not null")
 // @Column(unique = true)
  private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "myUser")
    private Set<Blog> blog;
}
