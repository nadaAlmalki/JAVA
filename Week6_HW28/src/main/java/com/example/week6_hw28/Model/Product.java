package com.example.week6_hw28.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer price;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Set<Orders> orders;
}
