package com.booking.service.model;

import com.booking.service.entity.SeatStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowtimeSeatDTO {

    private Long id;
    private Long showtimeId;
    private String seatNumber;
    private SeatStatus status; 

}
