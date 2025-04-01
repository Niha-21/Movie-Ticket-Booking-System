package com.movie.service.service;

import java.util.List;

import com.movie.service.exception.CustomException;
import com.movie.service.model.MovieDTO;


public interface MovieService {

    MovieDTO addMovie(MovieDTO movie) throws CustomException;
    List<MovieDTO> getAllMovies() throws CustomException;

}
