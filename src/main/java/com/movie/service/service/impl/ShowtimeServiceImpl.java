package com.movie.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.service.entity.MovieEntity;
import com.movie.service.entity.ShowtimeEntity;
import com.movie.service.entity.TheatreEntity;
import com.movie.service.model.ShowtimeDTO;
import com.movie.service.repository.MovieRepository;
import com.movie.service.repository.ShowtimeRepository;
import com.movie.service.repository.TheatreRepository;
import com.movie.service.service.ShowtimeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService{
    
    @Autowired
    private final ShowtimeRepository showtimeRepository;
    @Autowired
    private final MovieRepository movieRepository;  
    @Autowired
    private final TheatreRepository theatreRepository;

    @Override
    public List<ShowtimeDTO> getShowTimesByMovieId(Long movieId) {
        List<ShowtimeEntity> showtimes = showtimeRepository.findByMovieId(movieId);
        return showtimes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ShowtimeDTO addShowtime(ShowtimeDTO showtimeDTO) {
        MovieEntity movieEntity = movieRepository.findById(showtimeDTO.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        TheatreEntity theatreEntity = theatreRepository.findById(showtimeDTO.getTheatreId())
                .orElseThrow(() -> new RuntimeException("Theatre not found"));
        System.out.println("showtimeDTO.getShowtime()="+showtimeDTO.getShowtime());
        ShowtimeEntity showtimeEntity = new ShowtimeEntity(showtimeDTO.getId(), movieEntity, theatreEntity, showtimeDTO.getShowtime());
        System.out.println("showtimeDTO.getShowtime()="+showtimeDTO.getShowtime());
        
        return convertToDTO(showtimeRepository.save(showtimeEntity));
    }
    
    private ShowtimeDTO convertToDTO(ShowtimeEntity showtimeEntity) {
        return new ShowtimeDTO(showtimeEntity.getId(), showtimeEntity.getMovie().getId(), showtimeEntity.getTheatreEntity().getId(), showtimeEntity.getShowtime());
    }

}
