package com.movie.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.service.exception.CustomException;
import com.movie.service.model.MovieDTO;
import com.movie.service.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
    
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService microService) {
        this.movieService = microService;
    }

    @GetMapping
    public List<MovieDTO> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    public MovieDTO addMovie(@RequestBody MovieDTO movie) { 
        return movieService.addMovie(movie);
    }

}