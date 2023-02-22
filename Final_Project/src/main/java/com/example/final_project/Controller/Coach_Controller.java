package com.example.final_project.Controller;

import com.example.final_project.Model.Coach;
import com.example.final_project.Services.Coach_Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/coach")
@RestController
@RequiredArgsConstructor
public class Coach_Controller {
    private final Coach_Service coachService;

    @GetMapping("/get")
    public ResponseEntity getCoach(){
        List<Coach> coach = coachService.getCoach();
        return ResponseEntity.status(200).body(coach);
    }
    @PostMapping("/add")
    public ResponseEntity addCoach(@Valid @RequestBody Coach coach, Errors errors){
        coachService.addCoach(coach);
        return ResponseEntity.status(200).body("Coach added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCoach(@PathVariable Integer id, @Valid @RequestBody Coach coach, Errors errors){
        coachService.updateCoach(id, coach);
        return ResponseEntity.status(200).body("Coach update");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCoach(@PathVariable Integer id){
        coachService.deleteCoach(id);
        return ResponseEntity.status(200).body("Coach deleted");
    }
}
