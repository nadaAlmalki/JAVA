package com.example.final_project.Services;

import com.example.final_project.ApiException;
import com.example.final_project.Model.Training_Services;
import com.example.final_project.Repository.Order_Repositary;
import com.example.final_project.Repository.Training_Repositary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TraingSrevice_Services {

    private final Training_Repositary training_repositary;
    private  final Order_Repositary orderRepositary;

    public List<Training_Services> getAllTrainingServices() {
        return training_repositary.findAll();
    }

    public void addNewTraining(Training_Services training_services) {
        training_repositary.save(training_services);

    }

    public void updateTraining(Integer id,Training_Services training_services){
        Training_Services old_Training=training_repositary.getById(id);
        if(old_Training==null){
            throw new ApiException("Training service is not found");
        }
        old_Training.setName(training_services.getName());
        old_Training.setCategory(training_services.getCategory());
        old_Training.setTime_Period(training_services.getTime_Period());
        old_Training.setPrice(training_services.getPrice());
        training_repositary.save(old_Training);
    }

    public void deleteTrainingServices(Integer id) {
        Training_Services old_Training=training_repositary.getById(id);

        if (old_Training == null) {
            throw new ApiException("Training service is not found");
        } else
            training_repositary.deleteById(id);

    }
/*    public void addTrainingServiceToOrder(Training_Order_DTO cd)
    {Training_Services trainingServices=training_repositary.findTraining_ServicesById(cd.getTraining_id());
        if(trainingServices==null){
            throw new ApiException("Training service is not found");}
        Order_table orderTable=new Order_table(null,cd.getStart_Date(),cd.getEnd_Date(),cd.getTime(), cd.getTotal_price(), trainingServices);
        orderTable.setTrainingServices(trainingServices);
        //orderRepositary.save(orderTable);
        Set<Order_table>order_tables=trainingServices.getOrder_tables();
        orderRepositary.saveAll(order_tables);
    }*/



}
