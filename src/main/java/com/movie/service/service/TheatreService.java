package com.movie.service.service;

import java.util.List;

import com.movie.service.model.TheatreDTO;

public interface TheatreService {
    
    List<TheatreDTO> getAllTheatres();
    TheatreDTO addTheatre(TheatreDTO theatreDTO);

}
