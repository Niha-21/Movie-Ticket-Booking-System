package com.movie.service.service;

import java.util.List;

import com.movie.service.exception.CustomException;
import com.movie.service.model.ShowtimeDTO;

public interface ShowtimeService {

    List<ShowtimeDTO> getShowTimesByMovieId(Long movieId) throws CustomException;
    ShowtimeDTO addShowtime(ShowtimeDTO showtimeDTO) throws CustomException;

} 
