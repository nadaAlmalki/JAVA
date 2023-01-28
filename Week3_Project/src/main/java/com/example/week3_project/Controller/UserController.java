package com.example.week3_project.Controller;


import com.example.week3_project.Pojo.MerchantPojo;
import com.example.week3_project.Pojo.MerchantStockPojo;
import com.example.week3_project.Pojo.Product_Pojo;
import com.example.week3_project.Pojo.UserPojo;
import com.example.week3_project.Service.Product_Service;
import com.example.week3_project.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    public final UserService USERS;

    @GetMapping("/get")
    public ResponseEntity getUsers(){
        ArrayList<UserPojo> arr_user = USERS.getUsers();
        return ResponseEntity.status(200).body(arr_user);
    }


    @PostMapping("/add")
    public ResponseEntity addUsers(@Valid @RequestBody UserPojo User_ob, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        USERS.adduser(User_ob);
        return ResponseEntity.status(200).body("successfully Merchant added.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUsers(@PathVariable String id,@Valid @RequestBody UserPojo User_ob, Errors errors ){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated = USERS.updateuser(User_ob,id);
        if(isupdated){
            return ResponseEntity.status(200).body("successfully User updated.");
        }

        return ResponseEntity.status(400).body("Incoreect ID");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUsers(@PathVariable String id, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean id_deleted = USERS.deleteuser(id);
        if (id_deleted){
            return ResponseEntity.status(200).body("successfully User deleted.");
        }
        return ResponseEntity.status(400).body("Incoreect ID");
    }

   @PutMapping("/buy_pro/{userid}/{pro_id}/{merchan_id}")
   public ResponseEntity buy_pro(@Valid @RequestBody Product_Pojo product, @Valid @RequestBody MerchantPojo merchant, @Valid @RequestBody MerchantStockPojo stock,
                                 @Valid @RequestBody UserPojo user, @PathVariable String userid, @PathVariable String pro_id, @PathVariable String merchan_id,Errors errors) {
       if(errors.hasErrors()){
           String message = errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(message);
       }
       boolean isupdated = USERS.buy_pro(product,merchant,stock, user, userid, pro_id, merchan_id);
       if (isupdated){
           return ResponseEntity.status(200).body("The purchase was completed successfully.");
       }
       return ResponseEntity.status(400).body("Not successful.");

   }
}
