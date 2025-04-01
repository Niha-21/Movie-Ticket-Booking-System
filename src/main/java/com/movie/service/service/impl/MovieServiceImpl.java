package com.movie.service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.service.entity.MovieEntity;
import com.movie.service.exception.CustomException;
import com.movie.service.exception.ErrorCode;
import com.movie.service.model.MovieDTO;
import com.movie.service.repository.MovieRepository;
import com.movie.service.service.MovieService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class MovieServiceImpl implements MovieService{

    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieDTO addMovie(MovieDTO movie) throws CustomException {
        MovieEntity movieEntity = new MovieEntity();
        try{
            movieEntity = convertToEntity(movie);
        } catch(Exception e) { 
            throw new CustomException(ErrorCode.MOVIE_ADD_FAILED, e.getMessage());
        }
        return convertToDTO(movieRepository.save(movieEntity));
    }

    @Override
    public List<MovieDTO> getAllMovies() throws CustomException {
        List<MovieDTO> moviesList = new ArrayList<>();
        try {
            moviesList = movieRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
        } catch(Exception e) {
            throw new CustomException(ErrorCode.MOVIE_FETCH_FAILED, e.getMessage());
        }
        return moviesList;
    }
    
    private MovieDTO convertToDTO(MovieEntity movieEntity) {
        return new MovieDTO(movieEntity.getId(), movieEntity.getTitle(), movieEntity.getReleaseDate(), movieEntity.getDuration());
    }

    private MovieEntity convertToEntity(MovieDTO movie) {
        return new MovieEntity(movie.getId(), movie.getTitle(), movie.getReleaseDate(), movie.getDuration());
    }
}
