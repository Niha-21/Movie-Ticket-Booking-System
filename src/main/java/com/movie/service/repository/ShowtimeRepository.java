package com.movie.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.service.entity.ShowtimeEntity;

@Repository
public interface ShowtimeRepository extends JpaRepository <ShowtimeEntity, Long>{
    
    public List<ShowtimeEntity> findByMovieId(Long movieId);
    
}
