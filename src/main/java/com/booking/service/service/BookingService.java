package com.booking.service.service;

import com.booking.service.model.BookingDTO;
import java.util.List;

public interface BookingService {

    BookingDTO createBooking(BookingDTO bookingDTO);

    BookingDTO getBookingById(Long id);

    List<BookingDTO> getAllBookings();

    BookingDTO updateBooking(Long id, BookingDTO bookingDTO);

    void cancelBooking(Long id);
}
