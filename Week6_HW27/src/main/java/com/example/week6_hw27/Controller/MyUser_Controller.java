package com.example.week6_hw27.Controller;

import com.example.week6_hw27.ApiException;
import com.example.week6_hw27.Model.MyUser;
import com.example.week6_hw27.Service.MyUser_Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/user")
@RestController
@RequiredArgsConstructor
public class MyUser_Controller {
    private final MyUser_Service myUser_service;

    /*@PostMapping("/register")
    public ResponseEntity<Response> register(@Valid @RequestBody MyUser myUser){
        myUser_service.register(myUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response("User registered !",201));
    }

    @PostMapping("/admin")
    public ResponseEntity<Response> admin(){
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Welcome back ADMIN",200));
    }

    @PostMapping("/user")
    public ResponseEntity<Response> user(){
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Welcome back user",200));
    }


    @PostMapping("/login")
    public ResponseEntity<Response> login(){
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Welcome back",200));
    }*/


    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody MyUser myUser){
        myUser_service.register(myUser);
        return  ResponseEntity.status(201).body(new ApiException("User registered !"));
    }

    @PostMapping("/admin")
    public ResponseEntity admin(){
        return  ResponseEntity.status(200).body(new ApiException("Welcome back ADMIN!"));

    }

    @PostMapping("/user")
    public ResponseEntity user(){

        return ResponseEntity.status(200).body(new ApiException("Welcome back user!"));

    }


    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body(new ApiException("Welcome back!"));
    }


    @GetMapping("/alluser")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.status(200).body(myUser_service.getAllUsers());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(myUser_service.getUserById(id));
    }


/*
    @PutMapping("/{blog_id}/user/{user_id}")
    public ResponseEntity UserAssingedToBlog(@PathVariable Integer user_id, @PathVariable Integer blog_id) {
        myUser_service.UserAssingedToBlog(user_id,blog_id);
        return ResponseEntity.status(200).body("Many Blog assigned to user");

    }
*/

}
