package com.gfg.jbdll.service;

import com.gfg.jbdll.domain.Movie;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    private Map<Integer, Movie>  movieMap=new HashMap<>();

    public boolean addMovie(Movie movie){
        int id=this.movieMap.size()+1;
        movie.setId(id);
        this.movieMap.put(id,movie);
        return true;
    }

    public boolean deleteMovie(Integer  id){
        movieMap.remove(id);
        return true;
    }

    public boolean updateMovie(Integer id,Movie movie){
        if(this.movieMap.containsKey(id)){
            this.movieMap.put(id,movie);
            return  true;
        }
        return false;
    }
    public List<Movie> getAllMovies(){
        return this.movieMap.values().stream().toList();
    }

    public Movie getMovieByTitle(String title){
        return this.movieMap.values()
                .stream()
                .filter(movie -> title.equals(movie.getTitle())).findFirst().orElse(null);
    }
}
