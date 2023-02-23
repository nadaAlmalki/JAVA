package com.example.final_project.Services;

import com.example.final_project.ApiException;
import com.example.final_project.Model.Customer;
import com.example.final_project.Model.Orter_table;
import com.example.final_project.Repository.Customer_Repository;
import com.example.final_project.Repository.Order_Repositary;
import com.example.final_project.Repository.Training_Repositary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServices {
    private final Order_Repositary orderRepositary;
    private final Training_Repositary training_repositary;
    private final Customer_Repository customerRepository;

    public List<Orter_table> getAllOrders() {
        return orderRepositary.findAll();
    }

    public void addNewOrder(Orter_table orderTable) {
        orderRepositary.save(orderTable);

    }

    public void updateOrder(Integer id, Orter_table orderTable){
        Orter_table old_Order=orderRepositary.getById(id);

        if(old_Order==null){
            throw new ApiException("Order Not Found !");}
        old_Order.setStart_Date(orderTable.getStart_Date());
        old_Order.setEnd_Date(orderTable.getEnd_Date());
        old_Order.setTime(orderTable.getTime());
        old_Order.setTotal_price(orderTable.getTotal_price());
        old_Order.setStatus(orderTable.getStatus());
        orderRepositary.save(old_Order);

    }
    public void deleteOrder(Integer id) {
        Orter_table old_Order=orderRepositary.getById(id);

        if (old_Order == null) {
            throw new ApiException("Order Not Found !");
        } else
            orderRepositary.deleteById(id);


    }
    //Get Order Details by Order Id
    public List<Orter_table> OrderDetails(Integer coach_id){
        Orter_table orterTable= orderRepositary.findOrder_tableById(coach_id);
        if(orterTable == null){
            throw new ApiException("Incorrect Input");
        }


        return orderRepositary.findOrder_tableByCoachId(coach_id);
    }


}


