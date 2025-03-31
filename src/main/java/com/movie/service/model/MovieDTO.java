package com.movie.service.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    
    private Long id;
    private String title;
    private LocalDate releaseDate;
    private Integer duration;

}
