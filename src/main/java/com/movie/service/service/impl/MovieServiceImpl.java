package com.movie.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.service.entity.MovieEntity;
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
    public MovieDTO addMovie(MovieDTO movie) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity = convertToEntity(movie);
        return convertToDTO(movieRepository.save(movieEntity));
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    private MovieDTO convertToDTO(MovieEntity movieEntity) {
        return new MovieDTO(movieEntity.getId(), movieEntity.getTitle());
    }

    private MovieEntity convertToEntity(MovieDTO movie) {
        return new MovieEntity(movie.getId(), movie.getTitle());
    }
}
