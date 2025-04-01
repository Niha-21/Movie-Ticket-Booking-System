package com.movie.service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "showtimes")
public class ShowtimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private MovieEntity movie; 

    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    private TheatreEntity theatreEntity; 

    private LocalDateTime showtime;  

    public ShowtimeEntity() {}

    public ShowtimeEntity(Long id, MovieEntity movieEntity, TheatreEntity theatreEntity, LocalDateTime showtime) {
        this.id = id;
        this.movie = movieEntity;
        this.theatreEntity = theatreEntity;
        this.showtime = showtime;
    }
}
