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

    public void add_method (Address address){
        address_repository.save(address);
    }
    public void add_details(AddressDetailDTO addressDTO){
     // Address address1 = address_repository.findAddressById(addressDTO.getAddress_id());
        Teacher teacher = teacher_repository.findTeacherById((addressDTO.getAddress_id()));
        //Teacher teacher = new Teacher();
            if(teacher == null){
                throw new ApiException("Teacher Not found");
            }
      Address address = new Address(null,addressDTO.getArea(), addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        address_repository.save(address);
        }

    public void updateAddressDetails(Integer id, AddressDetailDTO addessDTO){
        Address address = address_repository.findAddressById(addessDTO.getAddress_id());
        if(address == null){
            throw new ApiException("Address not found");
        }
        address.setArea(addessDTO.getArea());
       address.setStreet(addessDTO.getStreet());
       address.setBuildingNumber(addessDTO.getBuildingNumber());
       address_repository.save(address);
    }

    public void deleteAddressDetails(Integer id){
        Address address = address_repository.findAddressById(id);
        if(address == null){
            throw new ApiException("Address Details deleted");
        }
        address_repository.delete(address);

    }

}
