package com.example.week3_hw4.Controller;

import com.example.week3_hw4.ApiRequest;
import com.example.week3_hw4.Pojo.Employees;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/emp")
public class EpmController {

    ArrayList<Employees> employes = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Employees> getEmp() {
        return employes;
    }

    @PostMapping("/add")
    public ResponseEntity addEmp(@Valid @RequestBody Employees emp, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(new ApiRequest(message));
        }
            employes.add(emp);
            return ResponseEntity.status(200).body("Employee added");
    }


    @PutMapping("/update/{index}")
    public ResponseEntity updateEmp(@Valid @PathVariable int index, @RequestBody Employees emp, Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);
        }
        employes.set(index, emp);

        return ResponseEntity.status(200).body("Employee updated");
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteEmp(@PathVariable int index, @RequestBody Employees emp , Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(new ApiRequest(message));
        }

        return ResponseEntity.status(200).body("Employee Deleted");

    }

   @PutMapping("/checkbalance/{index}")
    public int checkbalance(@RequestBody Employees emp, @PathVariable int index){
     //   emp.setAnnualLeave(30);
      int new_balance =0;
        System.out.println("The current Balnce Leave for employee is :  "+emp.getAnnualLeave());
       if(emp.isOnLeave() == false && emp.getAnnualLeave() != 0){
           System.out.println("Employe can take a leave.");
           new_balance = emp.getAnnualLeave() - 10 ;
       System.out.println("Employe's new balance is: "+ new_balance);
    }
    return new_balance;
}

}
