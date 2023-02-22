package com.example.final_project.Services;

import com.example.final_project.ApiException;
import com.example.final_project.Model.Coach;
import com.example.final_project.Repository.Coach_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Coach_Service {
    private final Coach_Repository coachRepository;

    public List<Coach> getCoach(){
        return coachRepository.findAll();
    }
    public void addCoach(Coach coach){
        coachRepository.save(coach);
    }

    public void updateCoach(Integer id, Coach newCoach){
        Coach oldCoach = coachRepository.findCoachById(id);
        if(oldCoach == null){
            throw new ApiException("Coach not found");
        }
        oldCoach.setName(newCoach.getName());
        oldCoach.setPhone_number(newCoach.getPhone_number());
        oldCoach.setLicense(newCoach.getLicense());
        oldCoach.setYear_of_experience(newCoach.getYear_of_experience());
        oldCoach.setPrice(newCoach.getPrice());
        coachRepository.save(oldCoach);
    }

    public void deleteCoach(Integer id){
        Coach Coach = coachRepository.findCoachById(id);
        if (Coach == null){
            throw new ApiException("Coach not found");
        }
        coachRepository.delete(Coach);
    }
}
