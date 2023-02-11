package com.example.week5_project5.Controller;

import com.example.week5_project5.Model.Book;
import com.example.week5_project5.Model.Customer;
import com.example.week5_project5.Services.Customer_Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class Customer_Controller {
    private final Customer_Service customer_service;

    @GetMapping("/get")
    public ResponseEntity getCustomer(){
        List<Customer> customers = customer_service.getCustomer();
        return ResponseEntity.status(200).body(customers);
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer customer){
        customer_service.addCustomer(customer);
        return ResponseEntity.status(200).body("Customer Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @Valid @RequestBody Customer customer) {
        customer_service.updateCustomer(id,customer);
        return ResponseEntity.status(200).body("Customer updated");

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {
        customer_service.deleteCustomer(id);
        return ResponseEntity.status(200).body("Customer deleted");

    }


    @GetMapping("/customer/{store_id}")
    //2.Create endpoint thar takes storeid and return all customers
    public ResponseEntity findAllCustomer(@PathVariable Integer store_id){
      List<Customer> customers = customer_service.findAllCustomer(store_id);
            return ResponseEntity.status(200).body(customers);
        }

}
