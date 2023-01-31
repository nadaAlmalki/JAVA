package com.example.hw17_week4.Controller;

import com.example.hw17_week4.Model.User;
import com.example.hw17_week4.Repository.User_Repository;
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
   /*     if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }*/
        userService.adduser(new_users);
        return ResponseEntity.status(200).body("User Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateblog(@Valid @RequestBody  User new_users, @PathVariable Integer id, Errors errors){

        userService.updateuser(id,new_users);
            return ResponseEntity.status(200).body("Users Updated.");
        }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteblog(@PathVariable Integer id){

      userService.deleteUser(id);
            return ResponseEntity.status(200).body("User Deleted");}


    @GetMapping("/email/{email}")
    public ResponseEntity getByEmail(@PathVariable String email){
       User user = userService.findUserByEmail(email);
        return ResponseEntity.status(200).body(user);
    }


    @GetMapping("/role/{role}")
    public ResponseEntity getByRole(@PathVariable String role){
        User user = userService.findUserByRole(role);
        return ResponseEntity.status(200).body(user);
    }


    @GetMapping("/age/{age}")
    public ResponseEntity findUserByAge(@PathVariable Integer age) {
        List<User> users = userService.findUserByAge(age);
        return ResponseEntity.status(200).body(users);
    }


    @GetMapping("/check/{username}/{password}")
    public ResponseEntity findUserByPassword(@PathVariable String username, @PathVariable String password){
        User user = userService.findUserByPassword(username,password);

        return ResponseEntity.status(200).body(user);
    }


    @GetMapping("/check1/{username}")
    public ResponseEntity checkUsername(@PathVariable String username){
        User user = userService.checkUsername(username);

        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/check2/{password}")
    public ResponseEntity checkPassword(@PathVariable String password){
        User user = userService.checkPassword(password);

        return ResponseEntity.status(200).body(user);
    }

}
