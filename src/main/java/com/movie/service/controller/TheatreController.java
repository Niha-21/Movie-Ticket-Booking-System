package com.movie.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.service.model.TheatreDTO;
import com.movie.service.service.TheatreService;

@RestController
@RequestMapping("/theatres")
public class TheatreController {
    
    private final TheatreService theatreService;

    @Autowired
    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @GetMapping
    public List<TheatreDTO> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

    @PostMapping
    public TheatreDTO addTheatre(@RequestBody TheatreDTO theatreDTO) {
        return theatreService.addTheatre(theatreDTO);
    }
    
}
