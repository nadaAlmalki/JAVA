package com.example.week5_project5.Repository;

import com.example.week5_project5.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Store_Repository extends JpaRepository<Store, Integer> {

    Store findStoreById(Integer id);

}
