package com.example.week6_hw28.Repository;

import com.example.week6_hw28.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_Repository extends JpaRepository<Product, Integer> {
    Product findProductById(Integer id);

}
