package com.booking.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import com.booking.service.entity.BookingStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private Long id;  
    private Long showtimeId;  
    private List<ShowtimeSeatDTO> showtimeSeats;
    private LocalDateTime bookingDate;  
    private Double totalAmount;  
    private BookingStatus bookingStatus; 
}