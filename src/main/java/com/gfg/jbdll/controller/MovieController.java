package com.gfg.jbdll.controller;

import com.gfg.jbdll.domain.Movie;
import com.gfg.jbdll.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    MovieService service=new MovieService();

    @PostMapping
    public boolean addMovie(@RequestBody Movie movie){

        service.addMovie(movie);
        return true;
    }

    @GetMapping(value="/{title}")
    public Movie getMovieByTitle(@PathVariable("title") String title){
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
