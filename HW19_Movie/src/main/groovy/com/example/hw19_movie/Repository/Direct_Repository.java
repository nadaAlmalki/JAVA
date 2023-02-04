package com.example.hw19_movie.Repository;

import com.example.hw19_movie.Model.Director;
import com.example.hw19_movie.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Direct_Repository extends JpaRepository<Director,Integer> {

    Director findDirectorByName(String name);

    Director findDirectorsById(Integer id);



}
