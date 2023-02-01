package com.example.centralpharmacy.Controller;

import com.example.centralpharmacy.Model.DeliverySchedule;
import com.example.centralpharmacy.Model.Hospital;
import com.example.centralpharmacy.Services.Delivery_ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/delivery")
@RequiredArgsConstructor
public class Delivery_ScheduleController {

    private final Delivery_ScheduleService deliveryScheduleService;

    @GetMapping("/get")
    public ResponseEntity getSchedule(){
        List<DeliverySchedule> Schedule = deliveryScheduleService.getDelivery_Schedule();
        return ResponseEntity.status(200).body(Schedule);
    }

    @PostMapping("/add")
    public ResponseEntity addSchedule(@Valid @RequestBody DeliverySchedule Schedule, Errors errors){
        deliveryScheduleService.addDelivery_Schedule(Schedule);
        return ResponseEntity.status(200).body("Delivery_Schedule Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateSchedule(@Valid @RequestBody DeliverySchedule schedule, @PathVariable Integer id, Errors errors){
        deliveryScheduleService.updateDelivery_Schedule(id, schedule);
        return ResponseEntity.status(200).body("Delivery_Schedule Updated.");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSchedule(@PathVariable Integer id){
        deliveryScheduleService.deleteDelivery_Schedule(id);
        return ResponseEntity.status(200).body("Delivery_Schedule Deleted");
    }
}
