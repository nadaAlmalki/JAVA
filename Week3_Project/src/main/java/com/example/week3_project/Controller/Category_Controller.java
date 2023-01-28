package com.example.week3_project.Controller;


import com.example.week3_project.Pojo.Category_Pojo;
import com.example.week3_project.Service.Category_Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Category")
@RequiredArgsConstructor
public class Category_Controller {

    public final Category_Service category;


    @GetMapping("/get")
    public ResponseEntity getCaregory(){
        ArrayList<Category_Pojo> arr_category = category.getCategory();
        return ResponseEntity.status(200).body(arr_category);
    }


    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid @RequestBody Category_Pojo category_ob, Errors errors){
    if (errors.hasErrors()){
        String message = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    category.addCategory(category_ob);
    return ResponseEntity.status(200).body("successfully Category added.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable String id,@Valid @RequestBody Category_Pojo category_ob, Errors errors ){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }
        boolean isupdated = category.updateCategory(id, category_ob);
        if(isupdated){
            return ResponseEntity.status(200).body("successfully Category updated.");
        }

        return ResponseEntity.status(400).body("Incoreect ID");

        }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable String id, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
       boolean id_deleted = category.deleteCategory(id);
        if (id_deleted){
            return ResponseEntity.status(200).body("successfully Category deleted.");
        }
        return ResponseEntity.status(400).body("Incoreect ID");
    }
}
