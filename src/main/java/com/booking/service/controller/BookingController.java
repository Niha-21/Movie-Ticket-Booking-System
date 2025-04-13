package com.booking.service.controller;

import com.booking.service.model.BookingDTO;
import com.booking.service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        BookingDTO createdBooking = bookingService.createBooking(bookingDTO);
        return ResponseEntity.ok(createdBooking);
    }

    // @GetMapping("/user/{userId}")
    // public ResponseEntity<List<BookingDTO>> getUserBookings(@PathVariable Long userId) {
    //     List<BookingDTO> bookings = bookingService.getBookingsByUserId(userId);
    //     return ResponseEntity.ok(bookings);
    // }

    @PutMapping("/cancel/{bookingId}")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return ResponseEntity.noContent().build();
    }
}
