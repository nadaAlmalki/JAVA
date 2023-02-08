package com.example.onetomany.Controller;


import com.example.onetomany.Model.Branch;
import com.example.onetomany.Services.Branch_Services;
import com.example.onetomany.Services.Merchant_Services;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/branch")
@RequiredArgsConstructor
public class Branch_Controller {

    private final Branch_Services branch_services;
    private final Merchant_Services merchant_services;


    @GetMapping("/get")
    public ResponseEntity getBranch(){
        List<Branch> branches = branch_services.getBranch();
        return ResponseEntity.status(200).body(branches);
    }

    @PostMapping("/add")
    public ResponseEntity addBranch(@Valid @RequestBody Branch branches, Errors errors){
        branch_services.addBranch(branches);
        return ResponseEntity.status(200).body("New  Branch  added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBranch(@Valid @RequestBody   Branch branches, @PathVariable Integer id){
            branch_services.updateBranch(id, branches);
        return ResponseEntity.status(200).body(" Branch Updated.");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBranch(@PathVariable Integer id){

        branch_services.deleteBranch(id);
        return ResponseEntity.status(200).body(" Branch Deleted");
    }


    @PutMapping("/{merchant_id}/branch/{branch_id}")
    public ResponseEntity assignMerchantToBranch(@PathVariable Integer merchant_id, @PathVariable Integer branch_id){
        branch_services.assignMerchantToBranch(merchant_id, branch_id);
        return ResponseEntity.status(200).body("Assign Merchant");
    }
}
