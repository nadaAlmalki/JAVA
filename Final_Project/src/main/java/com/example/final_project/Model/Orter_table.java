package com.example.final_project.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Orter_table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date start_Date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date end_Date;
    @JsonFormat(pattern="HH:mm:ss")
    private Time time;

    @NotNull(message="total_price should be not empty")
    @Positive(message="total_price must be Integer and grater than 0")
    private Integer total_price;

    @NotEmpty(message="status should be not empty")
    @Pattern(regexp="^(PENDING|ACCEPT|REJECT|COMPLETE)$",
            message="Wrong status ,status should be PENDING or ACCEPT or REJECT or COMPLETE only")
    private String status;

 /*   @ManyToOne
    @MapsId
    @JsonIgnore
    private Training_Services trainingServices;

    public Order_table(Object o, Date startDate, Date endDate, Time time, Integer totalPrice, Training_Services trainingServices) {
    }*/
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "coach_id", referencedColumnName = "id")
    @JsonIgnore
    private Coach coach;
}
