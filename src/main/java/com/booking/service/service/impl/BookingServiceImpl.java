package com.booking.service.service.impl;

import com.booking.service.entity.BookingEntity;
import com.booking.service.entity.ShowtimeSeatEntity;
import com.booking.service.model.BookingDTO;
import com.booking.service.model.ShowtimeSeatDTO;
import com.booking.service.repository.BookingRepository;
import com.booking.service.repository.ShowtimeSeatRepository;
import com.booking.service.service.BookingService;

import com.movie.service.entity.ShowtimeEntity;
import com.movie.service.repository.ShowtimeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Autowired
    private ShowtimeSeatRepository showtimeSeatRepository;

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        BookingEntity entity = convertToEntity(bookingDTO);
        entity.setBookingDate(LocalDateTime.now());  // auto-set booking date
        BookingEntity saved = bookingRepository.save(entity);
        return convertToDTO(saved);
    }

    @Override
    public BookingDTO getBookingById(Long id) {
        return bookingRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDTO updateBooking(Long id, BookingDTO bookingDTO) {
        Optional<BookingEntity> optional = bookingRepository.findById(id);
        if (optional.isPresent()) {
            BookingEntity updatedEntity = convertToEntity(bookingDTO);
            updatedEntity.setId(id); // retain existing ID
            updatedEntity.setBookingDate(optional.get().getBookingDate()); // retain original booking date
            BookingEntity saved = bookingRepository.save(updatedEntity);
            return convertToDTO(saved);
        }
        return null;
    }

    @Override
    public void cancelBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    private BookingDTO convertToDTO(BookingEntity entity) {
        List<ShowtimeSeatDTO> seatDTOs = entity.getShowtimeSeats()
                .stream()
                .map(seat -> new ShowtimeSeatDTO(
                        seat.getId(),
                        seat.getSeat().getId(),
                        seat.getSeat().getSeatNumber(),
                        seat.getStatus()
                ))
                .collect(Collectors.toList());

        return new BookingDTO(
                entity.getId(),
                entity.getShowtime().getId(),
                seatDTOs,
                entity.getBookingDate(),
                entity.getTotalAmount(),
                entity.getBookingStatus()
        );
    }

    private BookingEntity convertToEntity(BookingDTO dto) {
        ShowtimeEntity showtime = showtimeRepository.findById(dto.getShowtimeId()).orElseThrow();

        List<ShowtimeSeatEntity> seats = dto.getShowtimeSeats()
                .stream()
                .map(seatDTO -> {
                    ShowtimeSeatEntity entity = showtimeSeatRepository.findById(seatDTO.getId()).orElseThrow();
                    return entity;
                }).collect(Collectors.toList());

        BookingEntity booking = new BookingEntity();
        booking.setShowtime(showtime);
        booking.setShowtimeSeats(seats);
        booking.setBookingDate(dto.getBookingDate());
        booking.setTotalAmount(dto.getTotalAmount());
        booking.setBookingStatus(dto.getBookingStatus());

        return booking;
    }
}
