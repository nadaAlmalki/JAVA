package com.example.week6_hw28.Controller;

import com.example.week6_hw28.Model.MyUser;
import com.example.week6_hw28.Service.MyUser_Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/user")
@RestController
@RequiredArgsConstructor
public class MyUser_Controller {

    private final MyUser_Service myUser_service;

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody MyUser myUser) {
        myUser_service.register(myUser);
        return ResponseEntity.status(201).body("User registered !");
    }

    @PostMapping("/admin")
    public ResponseEntity admin() {
        return ResponseEntity.status(200).body("Welcome back ADMIN!");

    }

    @PostMapping("/user")
    public ResponseEntity user() {

        return ResponseEntity.status(200).body("Welcome back user!");

    }


    @PostMapping("/login")
    public ResponseEntity login() {
        return ResponseEntity.status(200).body("Welcome back!");
    }


    //Get order - customer - product by Id
    @GetMapping("/userbyid/{id}")
    public ResponseEntity getMyUserById(@PathVariable  Integer id){
        myUser_service.getMyUserById(id);
        return ResponseEntity.status(200).body("All users");
    }


   //Get all customer orders
    @GetMapping("/alluser")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.status(200).body(myUser_service.getAllUsers());
    }

    @PutMapping("/{order_id}/user/{user_id}")
    public ResponseEntity UserAssingedToBlog(@PathVariable Integer user_id, @PathVariable Integer order_id) {
        myUser_service.OrderAssingedToUser(user_id,order_id);
        return ResponseEntity.status(200).body("Oerder requested by user");

    }


}