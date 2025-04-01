package com.movie.service.service;

import java.util.List;

import com.movie.service.exception.CustomException;
import com.movie.service.model.TheatreDTO;

public interface TheatreService {
    
    List<TheatreDTO> getAllTheatres() throws CustomException;
    TheatreDTO addTheatre(TheatreDTO theatreDTO) throws CustomException;

}
