package com.example.final_project.Services;

import com.example.final_project.ApiException;
import com.example.final_project.Model.Customer;
import com.example.final_project.Model.Orter_table;
import com.example.final_project.Repository.Customer_Repository;
import com.example.final_project.Repository.Order_Repositary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Customer_Service {
    private final Customer_Repository customerRepository;
    private final Order_Repositary orderRepositary;

    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id, Customer newCustomer) {
        Customer oldCustomer = customerRepository.findCustomerById(id);
        if (oldCustomer == null) {
            throw new ApiException("Customer not found");
        }
        oldCustomer.setName(newCustomer.getName());
        oldCustomer.setGender(newCustomer.getGender());
        oldCustomer.setPhone_number(newCustomer.getPhone_number());
        oldCustomer.setEmail(newCustomer.getEmail());
        oldCustomer.setAge(newCustomer.getAge());
        oldCustomer.setLength(newCustomer.getLength());
        oldCustomer.setWeight(newCustomer.getWeight());
        oldCustomer.setHealth_problem(newCustomer.getHealth_problem());
        oldCustomer.setCity(newCustomer.getCity());
        oldCustomer.setAddress(newCustomer.getAddress());
        customerRepository.save(oldCustomer);
    }

    public void deleteCustomer(Integer id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer == null) {
            throw new ApiException("Customer not found");
        }
        customerRepository.delete(customer);
    }

    //Customer have different orders(1:M)
    public void OrdersAssignedtoCutomer(Integer customer_id, Integer order_id) {
        Customer customer = customerRepository.findCustomerById(customer_id);
        Orter_table order = orderRepositary.findOrder_tableById(order_id);
        if (customer == null || order == null) {
            throw new ApiException("Customer or Order not found");
        }
        order.setCustomer(customer);
        orderRepositary.save(order);

    }

    //2.Get Customers Details by Customer_id with order details.
    public Customer getListCustomer(Integer id) {
        Orter_table orderTable = orderRepositary.findOrder_tableById(id);
        Customer customer = customerRepository.findCustomerById(id);
        if ( customer != null && customer.getId() == id && orderTable != null) {

            return customer;

        }

        throw new ApiException("Customer not found");
    }



}