package com.example.week3_hw13.MainController;

import com.example.week3_hw13.CustomerPojo.Customers;
import com.example.week3_hw13.Pojo.Tasks;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/bank")
public class Endpoints {
    ArrayList<Customers> customer = new ArrayList<>();

    @PostMapping("/add")
    public String addcustomer(@RequestBody Customers customer1) {
        customer.add(customer1);
        return "Task added!";
    }

    @GetMapping("/get")
    public ArrayList<Customers> getcustomer() {
        return customer;
    }

    @PutMapping("/update/{index}")
    public String updacustomer(@PathVariable int index, @RequestBody Customers customer1) {
        customer.set(index, customer1);
        return "Update Successful";
    }


    @DeleteMapping("/delete/{index}")
    public String deletecustomer(@PathVariable int index) {
        customer.remove(index);
        return "Customer removed";
    }
    @PutMapping("/Depositbalance")
    public double updatebalance1(@RequestBody Customers account){
    System.out.println("The current Balnce for the first is:  "+account.getBalance());
        System.out.println( "The new Balance is (+ 400): "+account.Deposit(1500, account)+" "+account.getBalance());
       // System.out.println( "The new Balance after debit (-600) : "+account.Withdraw(600, account)+"   " +account.getBalance());
        return account.getBalance();
    }

    @PutMapping("/Withdrawbalance")
    public double updatebalance2(@RequestBody Customers account){
        System.out.println("The current Balnce for the first is:  "+account.getBalance());
       // System.out.println( "The new Balance is (+ 400): "+account.Deposit(1500, account)+" "+account.getBalance());
        System.out.println( "The new Balance after debit (-600) : "+account.Withdraw(600, account)+"   " +account.getBalance());
        return account.getBalance();
    }

}