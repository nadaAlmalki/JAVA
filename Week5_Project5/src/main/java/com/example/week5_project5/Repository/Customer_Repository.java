package com.example.week5_project5.Repository;

import com.example.week5_project5.Model.Book;
import com.example.week5_project5.Model.Customer;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Customer_Repository extends JpaRepository<Customer, Integer> {
    Customer findCustomerById(Integer id);
    List<Customer> getCustomerByStoreId(Integer id);
}
