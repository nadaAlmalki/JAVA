package com.example.hw17_week4.Controller;

import com.example.hw17_week4.Model.User;
import com.example.hw17_week4.Service.User_Service;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class User_Controller {

    private final User_Service userService;

    @GetMapping("/get")
    public ResponseEntity getblog(){
        List<User> users = userService.getuser();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/add")
    public ResponseEntity addblog(@Valid @RequestBody User new_users, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.adduser(new_users);
        return ResponseEntity.status(200).body("User Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateblog(@Valid @RequestBody  User new_users, @PathVariable Integer id, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated = userService.updateuser(id,new_users);
        if(isupdated){
            return ResponseEntity.status(200).body("Users Updated.");
        }

        return ResponseEntity.status(400).body("Incoreect ID");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteblog(@PathVariable Integer id){
        boolean idDeleted = userService.deleteUser(id);
        if(idDeleted){
            return ResponseEntity.status(200).body("User Deleted");
        }
        return ResponseEntity.status(400).body("Incoreect ID");
    }

}
