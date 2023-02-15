package com.example.week6_hw28.Service;

import com.example.week6_hw28.ApiException;
import com.example.week6_hw28.Model.MyUser;
import com.example.week6_hw28.Model.Orders;
import com.example.week6_hw28.Repository.MyUser_Repository;
import com.example.week6_hw28.Repository.Order_Repository;
import com.example.week6_hw28.Repository.Product_Repository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Order_Services {
    private final Order_Repository order_repository;

    private final MyUser_Repository myUser_repository;


    public List<Orders> getOrder() {
        return order_repository.findAll();
    }

    public void addOrder(Orders orders) {
        order_repository.save(orders);
    }

    public void updateOrder(Integer id, Orders newOrders) {
        Orders oldOrders = order_repository.findMyOrderById(id);
        if (oldOrders == null) {
            throw new ApiException("Order not found");
        }
        oldOrders.setQuantity(newOrders.getQuantity());
        oldOrders.setTotalPrice(newOrders.getTotalPrice());
        oldOrders.setDateReceived(newOrders.getDateReceived());
        oldOrders.setStatus(newOrders.getStatus());
        order_repository.save(oldOrders);
    }

    public void deleteOrder(Integer id) {
        Orders orders = order_repository.findMyOrderById(id);
        if (orders == null) {
            throw new ApiException("Order not found");
        }
        order_repository.delete(orders);
    }

    //In Add order endpoint: calculate the total price , status by defalut new

    public Integer totalprice(Integer user_id, Integer totalPrice){
        MyUser user = myUser_repository.findMyUserById(user_id);
        Orders orders = order_repository.findOrderByTotalPrice(totalPrice);
        if(user == null){
            throw new ApiException("User not found");
        }
        Integer cost = totalPrice + totalPrice;
        //   orders.setTotalPrice(cost);
         return cost;
    }

    //Create endpoint that change order status(only admin can change it)
    public void updateStatus(Integer user_id, Integer order_id, Orders orders){
        Orders order1 = order_repository.findMyOrderById(order_id);
        MyUser user = myUser_repository.findMyUserById(user_id);
        if(user == null && user.getRole().equals("ADMIN") || order1 == null){
            throw new ApiException("User not found");
        }
        order1.setStatus(orders.getStatus());
        order_repository.save(order1);

    }

    //Get order - customer - product by Id
    public Orders getOrderById(Integer id){
        Orders orders = order_repository.findMyOrderById(id);
        if (orders==null){
            throw new ApiException("Order Not Found!");
        }
        return orders;
    }


    //Get all customer orders
    public List<Orders> getOrdersByUserId(Integer user_id){
        MyUser user = myUser_repository.findMyUserById(user_id);
        if(user == null){
            throw new ApiException("Incorrect Input");
        }
        return order_repository.getOrdersByMyUserId(user_id);
    }

}
