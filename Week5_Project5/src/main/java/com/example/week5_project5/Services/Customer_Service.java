package com.example.week5_project5.Services;

import com.example.week5_project5.ApiException;
import com.example.week5_project5.Model.Book;
import com.example.week5_project5.Model.Customer;
import com.example.week5_project5.Model.Store;
import com.example.week5_project5.Repository.Customer_Repository;
import com.example.week5_project5.Repository.Store_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Customer_Service {


    private final Customer_Repository customer_repository;
    private final Store_Repository store_repository;
        public List<Customer> getCustomer(){
            return customer_repository.findAll();
        }


        public void addCustomer(Customer customer){
             customer_repository.save(customer);
        }

        public void updateCustomer(Integer id , Customer customer){
            Customer cust= customer_repository.findCustomerById(id);
            if(cust == null) {
                throw new ApiException("Customer not found");
            }
            cust.setName(customer.getName());
            cust.setPhoneNumber(customer.getPhoneNumber());
            cust.setEmail(customer.getEmail());
            customer_repository.save(cust);
        }

        public void deleteCustomer(Integer id){
            Customer customer= customer_repository.findCustomerById(id);
            if(customer == null) {
                throw new ApiException("Customer not found");
            }
            customer_repository.deleteById(id);
        }

        //2.Create endpoint thar takes storeid and return all customers
        public List<Customer> findAllCustomer(Integer store_id){
            Store store = store_repository.findStoreById(store_id);
            if (store == null) {
                throw new ApiException("Wrong Data");
            }
            return customer_repository.getCustomerByStoreId(store_id);

        }
}
