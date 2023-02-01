package com.example.centralpharmacy.Reapository;

import com.example.centralpharmacy.Model.DeliverySchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Delivery_ScheduleRepository extends JpaRepository<DeliverySchedule,Integer>{
}
