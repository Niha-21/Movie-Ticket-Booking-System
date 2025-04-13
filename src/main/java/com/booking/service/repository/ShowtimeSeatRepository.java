package com.booking.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.service.entity.SeatStatus;
import com.booking.service.entity.ShowtimeSeatEntity;

public interface ShowtimeSeatRepository extends JpaRepository<ShowtimeSeatEntity, Long> {
    
    List<ShowtimeSeatEntity> findByShowtimeIdAndStatus(Long showtimeId, SeatStatus status);
}
