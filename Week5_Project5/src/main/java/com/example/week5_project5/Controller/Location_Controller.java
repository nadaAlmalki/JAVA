package com.example.week5_project5.Controller;

import com.example.week5_project5.Model.Location;
import com.example.week5_project5.Model.Store;
import com.example.week5_project5.Services.Location_Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
@RequiredArgsConstructor
public class Location_Controller {

        private final Location_Service location_service;
    @GetMapping("/get")
    public ResponseEntity getLocation(){
        List<Location> locations = location_service.getLocation();
        return ResponseEntity.status(200).body(locations);
    }

    @PostMapping("/add")
    public ResponseEntity addLocation(@Valid @RequestBody Location locations){
        location_service.addLocation(locations);
        return ResponseEntity.status(200).body("Location Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateLocation(@PathVariable Integer id, @Valid @RequestBody Location locations) {
        location_service.updateLocation(id,locations);
        return ResponseEntity.status(200).body("Location updated");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLocation(@PathVariable Integer id) {
        location_service.deleteLocation(id);
        return ResponseEntity.status(200).body("location deleted");

    }


}
