package com.movie.service.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowtimeDTO {
    
    private Long id;  
    private Long movieId; 
    private Long theatreId;  
    private LocalDateTime showtime; 
    
}
