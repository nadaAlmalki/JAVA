package com.example.onetomany.Controller;

import com.example.onetomany.Model.Branch;
import com.example.onetomany.Model.Merchant;
import com.example.onetomany.Services.Branch_Services;
import com.example.onetomany.Services.Merchant_Services;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class Merchant_Controller {
    private final Merchant_Services merchant_services;
    private final Branch_Services branch_services;
    @GetMapping("/get")
    public ResponseEntity getMerchant(){
        List<Merchant> merchant = merchant_services.getMerchant();
        return ResponseEntity.status(200).body(merchant);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant, Errors errors){
        merchant_services.addMerchant(merchant);
        return ResponseEntity.status(200).body("New  Merchant added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@Valid @RequestBody Merchant merchant, @PathVariable Integer id){
        merchant_services.updateMerchant(id, merchant);
        return ResponseEntity.status(200).body(" Merchant Updated.");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable Integer id){

        merchant_services.deleteMerchant(id);
        return ResponseEntity.status(200).body("Merchant Deleted");
    }




}
