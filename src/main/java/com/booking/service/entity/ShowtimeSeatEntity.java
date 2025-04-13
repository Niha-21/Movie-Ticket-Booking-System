package com.booking.service.entity;

import com.movie.service.entity.ShowtimeEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "showtime_seats")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowtimeSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "showtime_id", nullable = false)
    private ShowtimeEntity showtime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", nullable = false)
    private SeatEntity seat;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

}
