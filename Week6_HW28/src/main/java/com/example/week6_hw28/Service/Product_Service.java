package com.example.week6_hw28.Service;

import com.example.week6_hw28.ApiException;
import com.example.week6_hw28.Model.MyUser;
import com.example.week6_hw28.Model.Orders;
import com.example.week6_hw28.Model.Product;
import com.example.week6_hw28.Repository.MyUser_Repository;
import com.example.week6_hw28.Repository.Order_Repository;
import com.example.week6_hw28.Repository.Product_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Product_Service {
    
    private final Product_Repository product_repository;
    private final Order_Repository order_repository;
    private final MyUser_Repository myUser_repository;


    public List<Product> getProduct() {
        return product_repository.findAll();
    }

    public void addProduct(Product products) {
        product_repository.save(products);
    }

    public void updateProduct(Integer id, Product newProduct) {
        Product oldProduct = product_repository.findProductById(id);
        if (oldProduct == null) {
            throw new ApiException("Product not found");
        }
        oldProduct.setName(newProduct.getName());
        oldProduct.setPrice(newProduct.getPrice());
        product_repository.save(oldProduct);
    }

    public void deleteProduct(Integer id) {
        Product products = product_repository.findProductById(id);
        if (products == null) {
            throw new ApiException("Product not found");
        }
        product_repository.delete(products);
    }


    public void OrderAssingedToProduct(Integer product_id, Integer order_id){
        Product product = product_repository.findProductById(product_id);
        Orders orders = order_repository.findMyOrderById(order_id);
        if (product == null || orders == null){
            throw new ApiException("Product or Order not found");
        }
        orders.setProduct(product);
        order_repository.save(orders);
    }

    public Product getProdctById(Integer id){
        Product product = product_repository.findProductById(id);
        if (product==null){
            throw new ApiException("Product Not Found!");
        }
        return product;
    }
}
