package com.example.week6_hw28.Controller;

import com.example.week6_hw28.Model.Product;
import com.example.week6_hw28.Model.Product;
import com.example.week6_hw28.Service.Product_Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/product")
@RestController
@RequiredArgsConstructor
public class Product_Controller {

    private final Product_Service product_service;
    @GetMapping("/get")
    public ResponseEntity getProduct() {
        List<Product> products = product_service.getProduct();
        return ResponseEntity.status(200).body(products);
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product products){
        product_service.addProduct(products);
        return ResponseEntity.status(200).body("Product added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer product_id, @Valid @RequestBody Product products){
        product_service.updateProduct(product_id, products);
        return ResponseEntity.status(200).body("Product updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer product_id){

        product_service.deleteProduct(product_id);

        return ResponseEntity.status(200).body("Product Deleted");
    }

    @PutMapping("/{order_id}/product/{product_id}")
    public ResponseEntity OrderAssingedToProduct(@PathVariable Integer product_id, @PathVariable Integer order_id) {
        product_service.OrderAssingedToProduct(order_id, product_id);
        return ResponseEntity.status(200).body("Product requested by many times");

    }
}
