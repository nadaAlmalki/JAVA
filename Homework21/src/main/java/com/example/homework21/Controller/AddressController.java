package com.example.homework21.Controller;

import com.example.homework21.DTO.AddressDetailDTO;
import com.example.homework21.Model.Address;
import com.example.homework21.Model.Teacher;
import com.example.homework21.Services.Address_Service;
import com.example.homework21.Services.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {


    private final Address_Service address_service;
    private final TeacherService teacherService;



    @GetMapping("/get")
    public ResponseEntity getAddress() {
        List<Address> addresses = address_service.getAddressDetails();
        return ResponseEntity.status(200).body(addresses);
    }
    @PostMapping("/add")
    public ResponseEntity add_method(@Valid @RequestBody Address address, Errors errors){
        address_service.add_method(address);
        return ResponseEntity.status(200).body("Address added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @Valid @RequestBody  Address address) {
        address_service.updat_method(id,address);
        return ResponseEntity.status(200).body("Teacher updated");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){

        address_service.delete_method(id);

        return ResponseEntity.status(200).body("Address Deleted");
    }



    //*****************8



   /* @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody AddressDetailDTO addressDTO, Errors errors){
        address_service.add_details(addressDTO);
        return ResponseEntity.status(200).body("Address Details is add");
    }*/
 /*   @PutMapping("/update/{id}")
    public ResponseEntity updateAddressDetails(@PathVariable Integer id, @Valid @RequestBody AddressDetailDTO addressDTO) {

        address_service.updateAddressDetails(id,addressDTO);
        return ResponseEntity.status(200).body("Address updated");

    }*/

/*    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id, Errors errors){

       address_service.deleteAddressDetails(id);

        return ResponseEntity.status(200).body("Address Deleted");
    }*/

}
