package com.example.hw19_movie.Controller;

import com.example.hw19_movie.Model.Director;
import com.example.hw19_movie.Model.Movie;
import com.example.hw19_movie.Services.DirectorService;
import com.example.hw19_movie.Services.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Movie")
@RequiredArgsConstructor
public class MovieController{

    private final MovieService movieService;
    private final DirectorService directorService;
    @GetMapping("/get")
    public ResponseEntity getMovie() {
        List<Movie> movie = movieService.getMovie();
        return ResponseEntity.status(200).body(movie);
    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie, Errors errors) {
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("New Movie is add");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@Valid @RequestBody Movie movie, @PathVariable Integer id, Errors errors) {

        movieService.updateMovie(id, movie);
        return ResponseEntity.status(200).body("Movie Updated.");
    }

    //1.Create endpoint that search for a specific movie by title
    @GetMapping("/search1/{name}")
    public ResponseEntity getByName(@PathVariable String name){
        Movie movie = movieService.findByName(name);
        return ResponseEntity.status(200).body(movie);
    }
    //2.Create endpoint that takes movie name and return the duration of the movie
    @GetMapping("/search2/{name}")
    public ResponseEntity searchByName(@PathVariable String name){
      Movie movie = movieService.findByName2(name);
        return ResponseEntity.status(200).body(movie.getDuration());
    }

    //5.Create endpoint that takes movie name and return the rate of the movie
    @GetMapping("/rate/{name}")
    public ResponseEntity findRateByName(@PathVariable String name){
        Movie movie = movieService.findRateByName(name);
        return ResponseEntity.status(200).body(movie.getRating());
    }

    //6.Create endpoint that returns all movies above that rate
    @GetMapping("/rating/{rating}")
    public ResponseEntity AboveRating(@PathVariable Integer rating) {
            List<Movie> movies = movieService.AboveRating(rating);
        return ResponseEntity.status(200).body(movies);
    }
        //7.Create endpoint that returns all movies by a specific genre
    @GetMapping("/genre/{genre}")
    public ResponseEntity findByGenre(@PathVariable String genre){
        List<Movie> movies = movieService.findByGenre(genre);
        return ResponseEntity.status(200).body(movies);
    }

    //4.Create endpoint to list movies to a specific director
    @PostMapping("/addDirector/{id}")
    public ResponseEntity addDirectortoMovie(@Valid @RequestBody Director director, @PathVariable Integer id, Errors errors) {
       directorService.addDirector(director);
        return ResponseEntity.status(200).body("Movies assigned to Director");
    }

}