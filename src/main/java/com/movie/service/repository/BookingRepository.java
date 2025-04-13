package com.movie.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.service.entity.BookingEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
   
    List<BookingEntity> findByUserId(Long userId);
    List<BookingEntity> findByShowtimeId(Long showtimeId);
    
}
