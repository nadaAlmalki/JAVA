package com.example.onetomany.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "merchant")
    private Set<Branch> branch;


   // @ManyToMany(mappedBy = "customer")
    //private Set<Customer> customer;
}
