package com.example.week5_project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Location{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(50) not null")
    private String area;

    @Column(columnDefinition = "varchar(50) not null")
    private String street;


    @OneToOne
    @MapsId
    @JsonIgnore

    private Store store;
}
