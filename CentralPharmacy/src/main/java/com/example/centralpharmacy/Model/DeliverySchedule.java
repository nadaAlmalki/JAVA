package com.example.centralpharmacy.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class DeliverySchedule{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "int not null")
    private Integer patientid;

    @Column(columnDefinition = "int not null")
    private Integer requestId;

    @Column(columnDefinition = "varchar(50) not null")
    private String Day;

   
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy@HH:mm")
    @Column(columnDefinition = "DATETIME", nullable = false)
     private Date date_delivery;

}
