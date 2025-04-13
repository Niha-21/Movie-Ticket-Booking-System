package com.booking.service.service;

import com.booking.service.entity.ShowtimeSeatEntity;

import java.util.List;

public interface ShowtimeSeatService {

    List<ShowtimeSeatEntity> getAvailableSeats(Long showtimeId);

    ShowtimeSeatEntity bookSeat(Long showtimeSeatId);

    ShowtimeSeatEntity cancelBooking(Long showtimeSeatId);
}
