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
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService{

    private final Movie_Repository movieRepository;

    private final Direct_Repository directRepository;

    public List<Movie> getMovie(){
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }


    public void updateMovie(Integer id, Movie oldmovie){
        Movie movie = movieRepository.getById(id);
        movie.setName(oldmovie.getName());
        movie.setDuration(oldmovie.getDuration());
        movie.setGenre(oldmovie.getGenre());
        movie.setRating(oldmovie.getRating());
        movieRepository.save(movie);

    }

    public void deleteMovie(Integer id){
        Movie del_movie = movieRepository.getById(id);
        movieRepository.deleteById(id);

    }

    //1.Create endpoint that search for a specific movie by title
    public Movie findByName(String name){
        Movie movies = movieRepository.findMovieByName(name);
        if(movies == null){
            throw new ApiException("Incorrect Input");
        }
        return movies;
    }

    //2.Create endpoint that takes movie name and return the duration of the movie
    public Movie findByName2(String name) {
        Movie movies = movieRepository.findMovieByName(name);
        if(movies != null && movies.getName().equals(name)){
          return movieRepository.findMovieByDuration(movies.getDuration());
        }
         throw new ApiException("Incorrect Input");
        }

    //5.Create endpoint that takes movie name and return the rate of the movie
      public Movie findRateByName(String name) {
            Movie movies = movieRepository.findMovieByName(name);
            if(movies != null && movies.getName().matches(name)){
            return  movieRepository.findMovieByRating(movies.getRating());
            }
            throw new ApiException("Incorrect Input");
        }

        //6.Create endpoint that returns all movies above that rate
        public List<Movie> AboveRating(Integer rating){
            List<Movie> movies = movieRepository.findAllByRatingGreaterThanEqual(rating);
            if (movies == null){
                throw new ApiException("Incorrect Input");
            }
            return movies;
        }

        //7.Create endpoint that returns all movies by a specific genre
    public List<Movie> findByGenre(String genre){
        List<Movie> movies = movieRepository.findMovieByGenre(genre);
        if (movies == null){
            throw new ApiException("Incorrect Input");
        }
        return movies;
    }

    //4.Create endpoint to list movies to a specific director
    public void addDirectortoMovie(Director director, String id) {
        List<Movie> movies = movieRepository.findAll();
        if(movies != null && director!= null && director.getId() == 1)
        directRepository.save(director);
    }

}
