package com.movie.service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.service.exception.CustomException;
import com.movie.service.model.ShowtimeDTO;
import com.movie.service.service.ShowtimeService;

@RestController
@RequestMapping("/showtimes")
public class ShowtimeController {
    
    private final ShowtimeService showtimeService;

    ShowtimeController(ShowtimeService showtimeService) {
        this.showtimeService = showtimeService;
    }

    @GetMapping("/{movieId}")
    public List<ShowtimeDTO> getShowTimesByMovieId(@PathVariable Long movieId) throws CustomException {
        return showtimeService.getShowTimesByMovieId(movieId);
    }

    @PostMapping
    public ShowtimeDTO addShowtime(@RequestBody ShowtimeDTO showtimeDTO) throws CustomException {
        return showtimeService.addShowtime(showtimeDTO);
    }

}
