package com.example.final_project.Services;

import com.example.final_project.ApiException;
import com.example.final_project.Model.Customer;
import com.example.final_project.Model.Orter_table;
import com.example.final_project.Model.Training_Services;
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

    public void assignTrainingServicesToOrder(Integer training_id,Integer order_id){

        Training_Services training_services=training_repositary.findTraining_ServicesById(training_id);
        Orter_table orderTable=orderRepositary.findOrder_tableById(order_id);
        if(training_services ==null || orderTable==null){
            throw new ApiException("Training Services Or Order not found");}
        else{
            training_services.getOrderTables().add(orderTable);
            orderTable.getTraining_services().add(training_services);
            training_repositary.save(training_services);
            orderRepositary.save(orderTable);

        }
    }

    //1.Get Order Details by Coach Id
    public List<Orter_table> OrderDetails(Integer coach_id){
        Orter_table orterTable= orderRepositary.findOrder_tableById(coach_id);
        if(orterTable == null){
            throw new ApiException("Coach don't have any Orders");
        }


        return orderRepositary.findOrder_tableByCoachId(coach_id);
    }

    //A. Change order status from "Pending" to "Accept and by default 'IN PROGRESS'
    //PENDING|ACCEPT|REJECT|COMPLETE
    public Orter_table AcceptStatus(Integer id){
        Orter_table orterTable = orderRepositary.findOrter_tableByCustomerId(id);
        if(orterTable != null && orterTable.getStatus().equals("PENDING")){
            orterTable.setStatus("IN PROGRESS");
            orderRepositary.save(orterTable);
            return orterTable;
        }
        throw new ApiException("Order Status is not 'IN PROGRESS' ");}
        //B.Change order status from "Accept" to "Completed"
        public Orter_table CompletedStatus(Integer id){
            Orter_table orterTable = orderRepositary.findOrter_tableByCustomerId(id);
            if(orterTable != null && orterTable.getStatus().equals("ACCEPT")){
                orterTable.setStatus("COMPLETE");
                orderRepositary.save(orterTable);
                return orterTable;
            }
            throw new ApiException("Order Status is not 'ACCEPTED' ");}

    //D. Change order status from "Pending" to "REJECT"
    //PENDING|ACCEPT|REJECT|COMPLETE
    public Orter_table RejectStatus(Integer id){
        Orter_table orterTable = orderRepositary.findOrter_tableByCustomerId(id);
        if(orterTable != null && orterTable.getStatus().equals("PENDING")){
            orterTable.setStatus("REJECT");
            orderRepositary.save(orterTable);
            return orterTable;
        }
        throw new ApiException("Order Status is not 'IN PENDING' ");}


    public Double Total_price(Integer customer_id,Integer order_id)//This endpoint to calculate total price of  order
    {
        Customer customer=customerRepository.findCustomerById(customer_id);
        Orter_table orderTable=orderRepositary.findOrder_tableById(order_id);
        if(customer == null){
            throw new ApiException("Not order of  customer");}
        List<Training_Services>training_services=customer.getTraining_services();
        double price;
        double total_price=0;
        for(int i=0;i<training_services.size();i++)
        {

            price=training_services.get(i).getPrice();
            total_price = total_price+price;

        }
        orderTable.setTotal_price(total_price);
        orderRepositary.save(orderTable);
        return total_price;
    }

    //If the customer orders more than one training service, the customer gets a 20% discount on each order
    public Double discount_Price(Integer customer_id,Integer order_id)
    {
        Customer customer=customerRepository.findCustomerById(customer_id);
        Orter_table orderTable=orderRepositary.findOrder_tableById(order_id);


        if(customer == null){
            throw new ApiException("customer not found");}
        List<Training_Services>training_services=customer.getTraining_services();
        double price;
        double total_price=0;
        if(training_services.size()>1)
        {
            for(int i=0;i<training_services.size();i++)
            {

                price=training_services.get(i).getPrice()*0.2;
                total_price=total_price+price;

            }

        }
        orderTable.setTotal_price(total_price);
        orderRepositary.save(orderTable);
        return total_price;

    }
}


