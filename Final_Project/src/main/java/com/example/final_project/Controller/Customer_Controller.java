package com.example.final_project.Controller;

import com.example.final_project.Model.Customer;
import com.example.final_project.Model.Orter_table;
import com.example.final_project.Services.Customer_Service;
import com.example.final_project.Services.OrderServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/customer")
@RestController
@RequiredArgsConstructor
public class Customer_Controller {
    private final Customer_Service customerService;
    private final OrderServices orderServices;


    @GetMapping("/get")
    public ResponseEntity getCustomer() {
        List<Customer> customer = customerService.getCustomer();
        return ResponseEntity.status(200).body(customer);
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer customer, Errors errors) {
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Customer added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @Valid @RequestBody Customer customer, Errors errors) {
        customerService.updateCustomer(id, customer);
        return ResponseEntity.status(200).body("Customer update");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("Customer deleted");
    }

    //Customer have different orders(M:1)
    @PutMapping("/{customer_id}/order/{order_id}")
    public ResponseEntity OrdersAssignedtoCutomer(@PathVariable Integer customer_id, @PathVariable Integer order_id) {
        customerService.OrdersAssignedtoCutomer(customer_id, order_id);
        return ResponseEntity.status(200).body("Customer have many orders");
    }
    //2.Get Customers Details by Customer_id with order details.
    @GetMapping("/listcustomer/{id}")
    public ResponseEntity getListCustomer( @PathVariable Integer id){
        Customer customers = customerService.getListCustomer(id);
        return ResponseEntity.status(200).body(customers);

    }

}