package com.example.hw19_movie.Controller;

import com.example.hw19_movie.Model.Director;
import com.example.hw19_movie.Services.DirectorService;
import com.example.hw19_movie.Services.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/director")
@RequiredArgsConstructor
public class DirectorController{

    private final DirectorService directorService;
    private final MovieService movieService;

    @GetMapping("/get")
    public ResponseEntity getDirector(){
        List<Director> directors = directorService.getDirector();
        return ResponseEntity.status(200).body(directors);
    }

    @PostMapping("/add")
    public ResponseEntity addDirector(@Valid @RequestBody Director dir, Errors errors){
        directorService.addDirector(dir);
        return ResponseEntity.status(200).body("New Direcotr is add");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDirector(@Valid @RequestBody  Director dir, @PathVariable Integer id, Errors errors){

        directorService.updateDirector(id,dir);
        return ResponseEntity.status(200).body("Director Updated.");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDirector(@PathVariable Integer id, Errors errors){

        directorService.deleteDirector(id);
        return ResponseEntity.status(200).body("Director Deleted");
    }


    //3.Create endpoint that takes movie name and return the director name
    @GetMapping("/search3/{name}/{id}")
    public ResponseEntity searchByName3(@PathVariable String name, @PathVariable Integer id){
        Director director = directorService.findByMovieName(name,id);
        return ResponseEntity.status(200).body(director.getName());
    }
        //4.Create endpoint to list movies to a specific director



}
