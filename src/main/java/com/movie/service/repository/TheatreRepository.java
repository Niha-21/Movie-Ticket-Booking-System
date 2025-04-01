package com.movie.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.service.entity.TheatreEntity;

@Repository
public interface TheatreRepository extends JpaRepository<TheatreEntity, Long>{


} 
