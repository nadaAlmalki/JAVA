package com.example.hw19_movie.Repository;

import com.example.hw19_movie.Model.Director;
import com.example.hw19_movie.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
public interface Movie_Repository extends JpaRepository<Movie,Integer>{

    Movie findMovieByName(String name);
    Movie findMovieByDuration(double duration);
    Movie findMovieByRating(Integer rating);
    List<Movie> findAllByRatingGreaterThanEqual(Integer rating);

    List<Movie> findMovieByGenre(String genre);
}
