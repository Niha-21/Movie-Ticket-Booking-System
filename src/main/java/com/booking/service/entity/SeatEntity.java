package com.booking.service.entity;

import com.movie.service.entity.TheatreEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seats")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theatre_id", nullable = false)
    private TheatreEntity theatre;

}
