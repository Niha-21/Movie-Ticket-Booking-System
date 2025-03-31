package com.movie.service.service;

import java.util.List;
import com.movie.service.model.MovieDTO;


public interface MovieService {

    MovieDTO addMovie(MovieDTO movie);
    List<MovieDTO> getAllMovies();

}
