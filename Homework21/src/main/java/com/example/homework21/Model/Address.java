package com.example.homework21.Model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(50) not null")
    private String area;
    @Column(columnDefinition = "varchar(50) not null")
    private String street;

    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
    @PrimaryKeyJoinColumn
  //  @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;
}
