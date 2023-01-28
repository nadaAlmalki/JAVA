package com.example.week3_project.Controller;


import com.example.week3_project.Pojo.Category_Pojo;
import com.example.week3_project.Pojo.MerchantPojo;
import com.example.week3_project.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Merchant")
@RequiredArgsConstructor
public class MerchantController {

    public final MerchantService merchantt;

    @GetMapping("/get")
    public ResponseEntity getMerchant(){
        ArrayList<MerchantPojo> arr_merchant = merchantt.getMarchan();
        return ResponseEntity.status(200).body(arr_merchant);
    }


    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody MerchantPojo merchant_ob, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantt.addMarchan(merchant_ob);
        return ResponseEntity.status(200).body("successfully Merchant added.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable String id,@Valid @RequestBody  MerchantPojo merchant_ob, Errors errors ){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated = merchantt.updateMarchan(id,merchant_ob);
        if(isupdated){
            return ResponseEntity.status(200).body("successfully Merchant updated.");
        }

        return ResponseEntity.status(400).body("Incoreect ID");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable String id, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean id_deleted = merchantt.deleteMarchan(id);
        if (id_deleted){
            return ResponseEntity.status(200).body("successfully Merchant deleted.");
        }
        return ResponseEntity.status(400).body("Incoreect ID");
    }
}