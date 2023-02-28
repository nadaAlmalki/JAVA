package com.example.final_project.Controller;

import com.example.final_project.DTO.UserCustomerDTO;
import com.example.final_project.Model.Coach;
import com.example.final_project.Model.Customer;
import com.example.final_project.Model.MyUser;
import com.example.final_project.Services.Customer_Service;
import com.example.final_project.Services.OrderServices;
import com.example.final_project.Services.TraingSrevice_Services;
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

    private final TraingSrevice_Services traingSreviceServices;

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
    @GetMapping("/display_coaches/{customer_id}/{tr_id}")//This endpoint for display coaches according category
    public ResponseEntity DisplayCoatches_ByCatogary(@PathVariable Integer customer_id,@PathVariable Integer tr_id)
    {List<Coach> coaches=customerService.Display_CoachByCatogary(customer_id,tr_id);
        return ResponseEntity.status(200).body(coaches);
    }

    @GetMapping("/cotches_By_Gender/{customer_id}/{gender}")//This endpoint for display coaches according gender
    public ResponseEntity SearchCoachesBY_Gender(@PathVariable Integer customer_id,@PathVariable String gender)
    {List<Coach> coaches=customerService.SearchCoachesBY_Gender(customer_id,gender);
        return ResponseEntity.status(200).body(coaches);
    }

    @GetMapping("/display_coaches_byGender/{customer_id}")//This endpoint for display coaches according gender
    public ResponseEntity Display_CoachByGender(@PathVariable Integer customer_id)
    {List<Coach> coaches=customerService.Display_CoachByGender(customer_id);
        return ResponseEntity.status(200).body(coaches);
    }


    @PostMapping("/addUserCustomer")
    public ResponseEntity addUser_Customer(@Valid @RequestBody UserCustomerDTO userCustomerDTO) {
        customerService.addUser_Customer(userCustomerDTO);
        return ResponseEntity.status(200).body("User Customer  added");
    }

    @GetMapping("/getAlluserCustomers/{id}")
    public  ResponseEntity AllCustomersbyID(@PathVariable Integer id,@Valid @RequestBody UserCustomerDTO userCustomerDTO)
    {
        List<MyUser> myUsers=customerService.AllCustomersbyID(id,userCustomerDTO);
        return ResponseEntity.status(200).body(myUsers);

    }


}