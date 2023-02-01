package com.example.centralpharmacy.Controller;

import com.example.centralpharmacy.Model.Hospital;
import com.example.centralpharmacy.Services.HospitalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospital")
@RequiredArgsConstructor
public class HospitalContrller{

    private final HospitalService hospitalService;

    @GetMapping("/get")
    public ResponseEntity getHospital(){
        List<Hospital> hospital = hospitalService.getHospital();
        return ResponseEntity.status(200).body(hospital);
    }

    @PostMapping("/add")
    public ResponseEntity addHospital(@Valid @RequestBody Hospital hospital, Errors errors){
        hospitalService.addHospital(hospital);
        return ResponseEntity.status(200).body("Hospital Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateHospital(@Valid @RequestBody Hospital hospital, @PathVariable Integer id, Errors errors){
        hospitalService.updateHospital(id,hospital);
        return ResponseEntity.status(200).body("Hospital Updated.");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteHospital(@PathVariable Integer id){
            hospitalService.deleteHospital(id);
        return ResponseEntity.status(200).body("Hospital Deleted");
    }
}
