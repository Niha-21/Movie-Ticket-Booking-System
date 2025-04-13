package com.booking.service.repository;

import com.booking.service.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    List<BookingEntity> findByUserId(Long userId);

}
