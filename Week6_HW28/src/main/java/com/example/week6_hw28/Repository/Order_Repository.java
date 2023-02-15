package com.example.week6_hw28.Repository;

import com.example.week6_hw28.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Order_Repository extends JpaRepository<Orders, Integer> {

     Orders findMyOrderById(Integer id);
     Orders findOrderByTotalPrice(Integer totalPrice);

    List<Orders> getOrdersByMyUserId(Integer user_id);
}
