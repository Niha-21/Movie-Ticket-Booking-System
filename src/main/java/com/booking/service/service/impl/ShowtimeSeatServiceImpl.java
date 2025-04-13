package com.booking.service.service.impl;

import com.booking.service.entity.SeatStatus;
import com.booking.service.entity.ShowtimeSeatEntity;
import com.booking.service.model.ShowtimeSeatDTO;
import com.booking.service.repository.ShowtimeSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowtimeSeatServiceImpl {

    private final ShowtimeSeatRepository showtimeSeatRepository;

    @Autowired
    public ShowtimeSeatServiceImpl(ShowtimeSeatRepository showtimeSeatRepository) {
        this.showtimeSeatRepository = showtimeSeatRepository;
    }

    public List<ShowtimeSeatEntity> getAvailableSeats(Long showtimeId) {
        return showtimeSeatRepository.findByShowtimeIdAndStatus(showtimeId, SeatStatus.AVAILABLE);
    }

    public ShowtimeSeatDTO bookSeat(Long showtimeSeatId) {
        Optional<ShowtimeSeatEntity> seatEntity = showtimeSeatRepository.findById(showtimeSeatId);

        if (seatEntity.isPresent()) {
            ShowtimeSeatEntity seat = seatEntity.get();
            if (seat.getStatus() == SeatStatus.AVAILABLE) {
                seat.setStatus(SeatStatus.BOOKED);
                return convertToDTO(showtimeSeatRepository.save(seat));
            }
        }
        return null;  
    }

    private ShowtimeSeatDTO convertToDTO(ShowtimeSeatEntity showtimeSeatEntity) {
        ShowtimeSeatDTO showtimeSeatDTO = new ShowtimeSeatDTO();
        showtimeSeatDTO.setId(showtimeSeatEntity.getId());
        showtimeSeatDTO.setSeatNumber(showtimeSeatEntity.getSeat().getSeatNumber());
        showtimeSeatDTO.setShowtimeId(showtimeSeatEntity.getShowtime().getId());
        showtimeSeatDTO.setStatus(showtimeSeatEntity.getStatus());
        return new ShowtimeSeatDTO();
    }

    public ShowtimeSeatDTO cancelBooking(Long showtimeSeatId) {
        Optional<ShowtimeSeatEntity> seatEntity = showtimeSeatRepository.findById(showtimeSeatId);

        if (seatEntity.isPresent()) {
            ShowtimeSeatEntity seat = seatEntity.get();
            if (seat.getStatus() == SeatStatus.BOOKED) {
                seat.setStatus(SeatStatus.AVAILABLE);
                return convertToDTO(showtimeSeatRepository.save(seat));
            }
        }
        return null;  
    }
}
