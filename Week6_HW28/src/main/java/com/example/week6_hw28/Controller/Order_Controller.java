package com.example.week6_hw28.Controller;

import com.example.week6_hw28.Model.Orders;
import com.example.week6_hw28.Service.Order_Services;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/v1/order")
@RestController
@RequiredArgsConstructor
public class Order_Controller {

    
    private final Order_Services order_services;
    @GetMapping("/get")
    public ResponseEntity getOrder() {
        List<Orders> orders = order_services.getOrder();
        return ResponseEntity.status(200).body(orders);
    }

    @PostMapping("/add")
    public ResponseEntity addOrder(@Valid @RequestBody Orders orders){
        order_services.addOrder(orders);
        return ResponseEntity.status(200).body("Order added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(@PathVariable Integer id, @Valid @RequestBody Orders orders){
        order_services.updateOrder(id, orders);
        return ResponseEntity.status(200).body("Order updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id){

        order_services.deleteOrder(id);

        return ResponseEntity.status(200).body("Order Deleted");
    }

    //In Add order endpoint: calculate the total price , status by defalut new
    @GetMapping("/totalprice/{user_id}")
    public ResponseEntity totalprice(@PathVariable Integer user_id,  @Valid Integer totalPrice){
        order_services.totalprice(user_id,totalPrice);
        return ResponseEntity.status(200).body("Total Price is");
    }

    //Create endpoint that change order status(only admin can change it)

    @GetMapping("/status/{user_id}/order/{order_id}")
    public ResponseEntity updateStatus(@PathVariable Integer user_id, @PathVariable Integer order_id, @Valid @RequestBody Orders orders){
        order_services.updateStatus(user_id,order_id,orders);
        return ResponseEntity.status(200).body("Status updated by Admin");
    }

        //Get order - customer - product by Id
        @GetMapping("/getorder/{order_id}")
    public ResponseEntity getOrderById(@PathVariable  Integer id){
        order_services.getOrderById(id);
        return ResponseEntity.status(200).body("Order Inforemation");
        }

        //Get all customer orders
    @GetMapping("/userorders/{user_id}")
    public ResponseEntity getOrdersByUserId(@PathVariable Integer user_id){
        List<Orders> orders = order_services.getOrdersByUserId(user_id);
        return ResponseEntity.status(200).body(orders);

    }
}
