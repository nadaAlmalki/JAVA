package com.example.week3_project.Controller;


import com.example.week3_project.Pojo.MerchantStockPojo;
import com.example.week3_project.Pojo.Product_Pojo;
import com.example.week3_project.Service.MerchantStockService;
import com.example.week3_project.Service.Product_Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    public final Product_Service PRODUCT;

    @GetMapping("/get")
    public ResponseEntity getProduct(){
        ArrayList<Product_Pojo> arr_product = PRODUCT.getProduct();
        return ResponseEntity.status(200).body(arr_product);
    }


    @PostMapping("/add")
    public ResponseEntity addProducts(@Valid @RequestBody Product_Pojo product_ob, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        PRODUCT.addproduct(product_ob);
        return ResponseEntity.status(200).body("successfully Product added.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProducts(@PathVariable String id,@Valid @RequestBody Product_Pojo product_ob, Errors errors ){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated = PRODUCT.updateproduct(id,product_ob);
        if(isupdated){
            return ResponseEntity.status(200).body("successfully Product updated.");
        }

        return ResponseEntity.status(400).body("Incoreect ID");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProducts(@PathVariable String id, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean id_deleted = PRODUCT.deleteproduct(id);
        if (id_deleted){
            return ResponseEntity.status(200).body("successfully Product deleted.");
        }
        return ResponseEntity.status(400).body("Incoreect ID");
    }
}

