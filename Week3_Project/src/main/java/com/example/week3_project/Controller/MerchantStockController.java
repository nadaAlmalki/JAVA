package com.example.week3_project.Controller;


import com.example.week3_project.Pojo.MerchantPojo;
import com.example.week3_project.Pojo.MerchantStockPojo;
import com.example.week3_project.Pojo.Product_Pojo;
import com.example.week3_project.Pojo.UserPojo;
import com.example.week3_project.Service.MerchantService;
import com.example.week3_project.Service.MerchantStockService;
import com.example.week3_project.Service.Product_Service;
import com.example.week3_project.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/stock")
@RequiredArgsConstructor
public class MerchantStockController {


    public final MerchantStockService Merchant_Stock;

    @Autowired
    private Product_Service pro;
    @Autowired
    private UserService user;
    @Autowired
    private MerchantService merchn2;
    @GetMapping("/get")
    public ResponseEntity getStock(){
        ArrayList<MerchantStockPojo> arr_stock = Merchant_Stock.getmchnStock();
        return ResponseEntity.status(200).body(arr_stock);

    }


    @PostMapping("/add")
    public ResponseEntity addStck(@Valid @RequestBody MerchantStockPojo merchantStock, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Merchant_Stock.addmchnStock(merchantStock);
        return ResponseEntity.status(200).body("successfully Merchant added to Stock.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStock(@PathVariable String id,@Valid @RequestBody MerchantStockPojo merchantStock, Errors errors ){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated = Merchant_Stock.updatemchnStock(id,merchantStock);
        if(isupdated){
            return ResponseEntity.status(200).body("successfully Merchant Stock updated.");
        }

        return ResponseEntity.status(400).body("Incoreect ID");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStock(@PathVariable String id, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean id_deleted = Merchant_Stock.deletemchnStock(id);
        if (id_deleted){
            return ResponseEntity.status(200).body("successfully Merchant deleted from Stock.");
        }
        return ResponseEntity.status(400).body("Incoreect ID");
    }

    @PostMapping("/add_pro")
    public ResponseEntity addProducts(@Valid @RequestBody Product_Pojo product_ob, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        pro.addproduct(product_ob);
        return ResponseEntity.status(200).body("successfully Product added.");
    }

    @PostMapping("/add_merchan")
    public ResponseEntity addMerchant(@Valid @RequestBody MerchantPojo merchant_ob, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchn2.addMarchan(merchant_ob);
        return ResponseEntity.status(200).body("successfully Merchant added.");
    }


}
