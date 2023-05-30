package com.gfg.jbdll.controller;

import com.gfg.jbdll.domain.Movie;
import com.gfg.jbdll.service.GreetService;
import com.gfg.jbdll.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {



    /***
     * Types of Dependency injection
     * 1. Constructor dependency injection -- recommended
     * ex: public MovieController(<DEPENDENCY instance> service){
     *     this.service=service;
     * }
     * 2. Field dependency injection
     *
     * @Autowired
     * Service service;
     *
     *
     * 3. Setter dependency injection
     *
     * Service = null
     *
     * @Autowired
     * public void setService(<Dependency instance> service)
     * {
     *     this.service=service;
     * }
     *
     **/


    @Autowired
    ApplicationContext context;

    @Autowired
    MovieService service;




    @PostMapping
    public ResponseEntity<?> addMovie(@RequestBody @Valid Movie movie){
        return new ResponseEntity<>(service.addMovie(movie), HttpStatus.CREATED);
    }

    @GetMapping(value="/{title}")
    public Movie getMovieByTitle(@PathVariable("title") String title){
        System.out.println("here in movie service:"+service.hashCode());
        return service.getMovieByTitle(title);
    }

    @GetMapping
    public List<Movie> getMovies(){
        return service.getAllMovies();
    }

    @DeleteMapping
    public boolean deleteMovie(@RequestParam("id") Integer id){
        return service.deleteMovie(id);
    }

}



















