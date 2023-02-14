package com.example.week5_project5.Services;

import com.example.week5_project5.ApiException;
import com.example.week5_project5.DTO.LocationDTO;
import com.example.week5_project5.Model.*;
import com.example.week5_project5.Model.Store;
import com.example.week5_project5.Repository.Book_Repository;
import com.example.week5_project5.Repository.Customer_Repository;
import com.example.week5_project5.Repository.Location_Repository;
import com.example.week5_project5.Repository.Store_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Store_Service {
    private final Store_Repository store_repository;
    private final Location_Repository location_repository;
    private final Book_Repository book_repository;
    private final Customer_Repository customer_repository;


    public List<Store> getStore(){
        return store_repository.findAll();
    }


    public void addStore(Store store){
        store_repository.save(store);
    }

    public void updateStore(Integer id , Store store){
        Store store1= store_repository.findStoreById(id);
        if(store1 == null) {
            throw new ApiException("Store not found");
        }
        store1.setName(store.getName());
        store_repository.save(store1);
    }

    public void deleteStore(Integer id){
        Store store= store_repository.findStoreById(id);
        if(store == null) {
            throw new ApiException("Store not found");
        }
        store_repository.deleteById(id);
    }


    //Add Loctions Details to Teacher
    public void AddLocationtoStore(LocationDTO location_DTO){

        Store store= store_repository.findStoreById((location_DTO.getStore_id()));
        if(store == null){
            throw new ApiException("Store Not found");
        }
        Location loc = new Location(null, location_DTO.getArea(),location_DTO.getStreet(),store);
        location_repository.save(loc);
    }

    public void StoreAndBook(Integer store_id, Integer book_id){
        Store store = store_repository.findStoreById(store_id);
        Book book = book_repository.findBookById(book_id);
        if (store == null || book == null){
            throw new ApiException("Store or books not found");
        }
        book.setStore(store);
        book_repository.save(book);

    }

    public void StoreAndCustomer(Integer store_id, Integer customer_id) {
        Customer customer = customer_repository.findCustomerById(customer_id);
        Store store = store_repository.findStoreById(store_id);
        if (customer == null || store == null) {
            throw new ApiException("Wrong Data");
        }

        customer.getStore().add(store);
        store.getCustomer().add(customer);
        customer_repository.save(customer);
        store_repository.save(store);
    }


}