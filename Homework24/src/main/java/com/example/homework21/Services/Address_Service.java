package com.example.homework21.Services;

import com.example.homework21.ApiException;
import com.example.homework21.DTO.AddressDetailDTO;
import com.example.homework21.Model.Address;
import com.example.homework21.Model.Teacher;
import com.example.homework21.Repository.Address_Repository;
import com.example.homework21.Repository.Teacher_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Address_Service {
    private final Address_Repository address_repository;
    private final Teacher_Repository teacher_repository;

    public List<Address> getAddressDetails(){
        return address_repository.findAll();
    }


    public void add_method(Address address){
        address_repository.save(address);
    }


    public void updat_method(Integer id, Address address){
        Address addr = address_repository.findAddressById(id);
        if(addr == null)
        {
            throw  new ApiException("Address not found");
        }
        addr.setBuildingNumber(address.getBuildingNumber());
        addr.setArea(address.getArea());
        addr.setStreet(address.getStreet());
        address_repository.save(addr);

    }

    public void delete_method(Integer id){
        Address address = address_repository.findAddressById(id);
        if(address == null)
        {
            throw  new ApiException("Address not found");
        }
        teacher_repository.deleteById(id);

    }


}
