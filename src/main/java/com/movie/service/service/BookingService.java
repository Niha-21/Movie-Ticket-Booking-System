package com.movie.service.service;

import java.util.List;

import com.booking.service.model.BookingDTO;

public interface BookingService {

    BookingDTO createBooking(BookingDTO bookingDTO);
    BookingDTO cancelBooking(Long bookingId);
    List<BookingDTO> getBookingsByUserId(Long userId);
    List<BookingDTO> getBookingsByShowtimeId(Long showtimeId);

}
