package com.example.hw19_movie.Services;

import com.example.hw19_movie.ApiException.ApiException;
import com.example.hw19_movie.Model.Director;
import com.example.hw19_movie.Model.Movie;
import com.example.hw19_movie.Repository.Direct_Repository;
import com.example.hw19_movie.Repository.Movie_Repository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService{
    private final Direct_Repository directRepository;

    private final Movie_Repository movieRepository;
    //private final MovieService movieService;


    public List<Director> getDirector(){
        return directRepository.findAll();
    }

    public void addDirector(Director director){
        directRepository.save(director);
    }


    public void updateDirector(Integer id, Director olddirector){
        Director director = directRepository.getById(id);
        director.setName(olddirector.getName());
        directRepository.save(director);
    }

    public void deleteDirector(Integer id){
        Director del_Director = directRepository.getById(id);
        directRepository.deleteById(id);

    }

    //3.Create endpoint that takes movie name and return the director name
    public Director findByMovieName(String name, Integer id) {
        Movie movies = movieRepository.findMovieByName(name);
        Director director = directRepository.findDirectorsById(id);
        if(director!= null && movies.getName().matches(name)){
            director = directRepository.findDirectorByName(director.getName());
            return director;

        }

        throw new ApiException("Director Not found");
    }

}
