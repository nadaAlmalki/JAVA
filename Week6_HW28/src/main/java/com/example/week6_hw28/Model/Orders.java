package com.example.week6_hw28.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(columnDefinition ="int not null")
    private Integer quantity;
    @Column(columnDefinition ="int not null")
    private Integer totalPrice;

    @Column(columnDefinition ="varchar(30) not null")
    private String dateReceived;

    @Column(columnDefinition = "varchar(30) not null check(status= 'new' or status='inProgress' or status='completed') by default ")
    private String status;

    @ManyToOne
   // @JoinColumn(name = "user_id", referencedColumnName = "id")
   // @JoinColumn(name = "user_id")
    @JsonIgnore
    @JoinTable(name = "orders_users",
            joinColumns = @JoinColumn(name = "rdoer_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private MyUser myUser;

    @ManyToOne
   // @JoinColumn(name = "product_id", referencedColumnName = "id")
    //@JoinColumn(name = "product_id")
    @JsonIgnore
    @JoinTable(name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Product product;



}
