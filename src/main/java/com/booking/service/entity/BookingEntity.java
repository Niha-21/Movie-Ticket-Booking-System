package com.booking.service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import com.movie.service.entity.ShowtimeEntity;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "user_id", nullable = false)
    // private UserEntity user;  // User who made the booking

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "showtime_id", nullable = false)
    private ShowtimeEntity showtime; 

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<ShowtimeSeatEntity> showtimeSeats;  

    private LocalDateTime bookingDate;  

    private Double totalAmount;  

    private BookingStatus bookingStatus;

}
