package com.example.centralpharmacy.Services;


import com.example.centralpharmacy.Model.DeliverySchedule;
import com.example.centralpharmacy.Model.Hospital;
import com.example.centralpharmacy.Model.Request;
import com.example.centralpharmacy.Reapository.Delivery_ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Delivery_ScheduleService {

    private final Delivery_ScheduleRepository deliveryScheduleRepository;

    public List<DeliverySchedule> getDelivery_Schedule(){
        return deliveryScheduleRepository.findAll();
    }

    public void addDelivery_Schedule(DeliverySchedule delivery){
        deliveryScheduleRepository.save(delivery);
    }

    public void updateDelivery_Schedule(Integer id, DeliverySchedule delivery){
        DeliverySchedule schedule = deliveryScheduleRepository.getById(id);
        schedule.setPatientid(delivery.getPatientid());
        schedule.setRequestId(delivery.getRequestId());
        schedule.setDay(delivery.getDay());
        schedule.setDate_delivery(delivery.getDate_delivery());
        deliveryScheduleRepository.save(schedule);
    }

    public void deleteDelivery_Schedule(Integer id){
        DeliverySchedule schedule = deliveryScheduleRepository.getReferenceById(id);
        deliveryScheduleRepository.deleteById(id);
    }
}
