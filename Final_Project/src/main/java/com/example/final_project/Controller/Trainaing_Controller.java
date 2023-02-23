package com.example.final_project.Controller;

import com.example.final_project.Model.Training_Services;
import com.example.final_project.Services.OrderServices;
import com.example.final_project.Services.TraingSrevice_Services;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/training")
public class Trainaing_Controller {
    private final TraingSrevice_Services traingSreviceServices;
    private final OrderServices orderServices;

    @GetMapping("/get")
    public ResponseEntity getAllTrainingServices() {
        List<Training_Services> trainingServices= traingSreviceServices.getAllTrainingServices();
        return ResponseEntity.status(200).body(trainingServices);
    }

    @PostMapping("/add")
    public ResponseEntity addNewTraining(@Valid @RequestBody Training_Services training_services) {
        traingSreviceServices.addNewTraining(training_services);
        return ResponseEntity.status(200).body("Training Service  has been added successfully ");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTraining(@PathVariable Integer id, @Valid @RequestBody Training_Services training_services) {
        traingSreviceServices.updateTraining(id, training_services);

        return ResponseEntity.status(200).body("Training Service  has been updated successfully");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTrainingServices(@PathVariable Integer id) {

        traingSreviceServices.deleteTrainingServices(id);

        return ResponseEntity.status(200).body("Training Service  has been deleted successfully");
    }
/*    @PostMapping("/addTrainingOrder")
    public ResponseEntity addTrainingServiceToOrder(@RequestBody Training_Order_DTO trainingOrderDto) {
        traingSreviceServices.addTrainingServiceToOrder(trainingOrderDto);

        return ResponseEntity.status(200).body("Training service assign  with Order Table");
    }*/

}
