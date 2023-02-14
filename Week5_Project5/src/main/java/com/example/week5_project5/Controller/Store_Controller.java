package com.example.week5_project5.Controller;

import com.example.week5_project5.DTO.LocationDTO;
import com.example.week5_project5.Model.Customer;
import com.example.week5_project5.Model.Store;
import com.example.week5_project5.Services.Store_Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class Store_Controller {

    private final Store_Service store_service;

    @GetMapping("/get")
    public ResponseEntity getStore(){
        List<Store> stores = store_service.getStore();
        return ResponseEntity.status(200).body(stores);
    }

    @PostMapping("/add")
    public ResponseEntity addStore(@Valid @RequestBody Store store){
        store_service.addStore(store);
        return ResponseEntity.status(200).body("Store Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStore(@PathVariable Integer id, @Valid @RequestBody Store store) {
        store_service.updateStore(id,store);
        return ResponseEntity.status(200).body("Store updated");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStore(@PathVariable Integer id) {
        store_service.deleteStore(id);
        return ResponseEntity.status(200).body("Store deleted");

    }

    //Add Loctions Details to Store
    @PostMapping("/location")
    public ResponseEntity AddLocationtoStore(@Valid @RequestBody LocationDTO locationDTO, Errors errors) {
        store_service.AddLocationtoStore(locationDTO);
        return ResponseEntity.status(200).body("Store Location added");
    }


    @PutMapping("/{store_id}/book/{book_id}")
    public ResponseEntity StoreAndBook(@PathVariable Integer store_id, @PathVariable Integer book_id) {
        store_service.StoreAndBook(store_id, book_id);
        return ResponseEntity.status(200).body("Books are availbe in the same store");
    }

    @PutMapping("/{customer_id}/store/{store_id}")
    public ResponseEntity StoreAndCustomer(@PathVariable Integer store_id,@PathVariable Integer customer_id) {
            store_service.StoreAndCustomer(store_id, customer_id);
            return ResponseEntity.status(200).body("Customer added to Store");
        }

}
