package com.example.week5_project5.Services;

import com.example.week5_project5.ApiException;
import com.example.week5_project5.Model.Location;
import com.example.week5_project5.Model.Store;
import com.example.week5_project5.Repository.Location_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Location_Service {

    private final Location_Repository location_repository;

    public List<Location> getLocation(){
        return location_repository.findAll();
    }


    public void addLocation(Location location){
        location_repository.save(location);
    }

    public void updateLocation(Integer id , Location location){
        Location loc= location_repository.findLocationById(id);
        if(loc == null) {
            throw new ApiException("Location not found");
        }
        loc.setArea(location.getArea());
        loc.setStreet(location.getStreet());
        location_repository.save(loc);
    }

    public void deleteLocation(Integer id){
        Location loc= location_repository.findLocationById(id);
        if(loc == null) {
            throw new ApiException("Location not found");
        }
        location_repository.deleteById(id);
    }

}
