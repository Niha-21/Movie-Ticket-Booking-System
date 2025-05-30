package com.movie.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.service.entity.MovieEntity;

@Repository
public interface MovieRepository extends JpaRepository <MovieEntity, Long>{
    
}
