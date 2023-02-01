package com.example.centralpharmacy.Services;

import com.example.centralpharmacy.Model.Hospital;
import com.example.centralpharmacy.Model.Request;
import com.example.centralpharmacy.Reapository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    public List<Hospital> getHospital(){
        return hospitalRepository.findAll();
    }

    public void addHospital(Hospital hospital){
        hospitalRepository.save(hospital);
    }


    public void updateHospital(Integer id, Hospital hospital){
        Hospital hospitals = hospitalRepository.getById(id);
        hospitals.setName(hospital.getName());
        hospitals.setPatientid(hospital.getPatientid());
        hospitals.setLocation(hospital.getLocation());
        hospitalRepository.save(hospitals);
    }

    public void deleteHospital(Integer id){
        Hospital hospital = hospitalRepository.getById(id);
        hospitalRepository.deleteById(id);

    }
}
