package com.example.centralpharmacy.Controller;

import com.example.centralpharmacy.Model.Request;
import com.example.centralpharmacy.Services.RequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/request")
@RequiredArgsConstructor
public class RequestController {
    private final RequestService requestService;

    @GetMapping("/get")
    public ResponseEntity getRequest(){
        List<Request> requests = requestService.getRequest();
        return ResponseEntity.status(200).body(requests);
    }

    @PostMapping("/add")
    public ResponseEntity addRequest(@Valid @RequestBody Request request, Errors errors){
        requestService.addRequest(request);
        return ResponseEntity.status(200).body("Request Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateRequest(@Valid @RequestBody Request request, @PathVariable Integer id, Errors errors){
        requestService.updateRequest(id, request);
        return ResponseEntity.status(200).body("Request Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRequest(@PathVariable Integer id){

        requestService.deleteRequest(id);
        return ResponseEntity.status(200).body("Request Deleted");}

}
