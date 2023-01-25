package com.example.wekk3_day4.Controller;

import com.example.wekk3_day4.ApiRequest;
import com.example.wekk3_day4.Pojo.User;
import jakarta.validation.Valid;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    ArrayList<User> users = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<User> getuser() {
        return users;
    }

    @PostMapping("/add")
    public ResponseEntity adduser(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(new ApiRequest(message));
        }
            users.add(user);
        return ResponseEntity.status(200).body(new ApiRequest("User Added"));

    }


    @PutMapping("/update/{index}")
    public ApiRequest updateuser(@PathVariable int index, @RequestBody User user){
    users.set(index, user);
    return new ApiRequest("User updated");
    }

    @DeleteMapping("/delete/{index}")
    public ApiRequest deleteuser(@PathVariable int index, @RequestBody User user ){
        return new ApiRequest("User Deleted");

    }
}