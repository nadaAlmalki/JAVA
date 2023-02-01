package com.example.centralpharmacy.Services;


import com.example.centralpharmacy.Model.Request;
import com.example.centralpharmacy.Reapository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService{

    private final RequestRepository requestRepository;

    public List<Request> getRequest(){
        return requestRepository.findAll();
    }

    public void addRequest(Request request){
        requestRepository.save(request);
    }


    public void updateRequest(Integer id, Request request){
        Request requests = requestRepository.getById(id);
        requests.setPatientid(request.getPatientid());
        requests.setQuantity(request.getQuantity());
        requests.setMedicineId(request.getMedicineId());
        requestRepository.save(requests);

    }

    public void deleteRequest(Integer id){
       Request del_request = requestRepository.getById(id);
        requestRepository.deleteById(id);

    }


}
