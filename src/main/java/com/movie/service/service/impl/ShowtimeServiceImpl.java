package com.movie.service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.service.entity.MovieEntity;
import com.movie.service.entity.ShowtimeEntity;
import com.movie.service.entity.TheatreEntity;
import com.movie.service.exception.CustomException;
import com.movie.service.exception.ErrorCode;
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
    public List<ShowtimeDTO> getShowTimesByMovieId(Long movieId) throws CustomException {
        
        List<ShowtimeDTO> showtimesList = new ArrayList<>();
        List<ShowtimeEntity> showtimes = null;
        try{
            try{
                showtimes = showtimeRepository.findByMovieId(movieId);
            } catch(Exception e) {
                throw new CustomException(ErrorCode.MOVIE_NOT_FOUND, e.getMessage());
            }
            showtimesList = showtimes.stream().map(this::convertToDTO).collect(Collectors.toList());
        } catch(Exception e) {
            throw new CustomException(ErrorCode.SHOWTIME_FETCH_FAILED, e.getMessage());
        }
        return showtimesList;
    }

    @Override
    public ShowtimeDTO addShowtime(ShowtimeDTO showtimeDTO) throws CustomException {
        ShowtimeEntity showtimeEntity = null;
        try{
            MovieEntity movieEntity = movieRepository.findById(showtimeDTO.getMovieId())
                    .orElseThrow(() -> new CustomException(ErrorCode.MOVIE_NOT_FOUND));
            TheatreEntity theatreEntity = theatreRepository.findById(showtimeDTO.getTheatreId())
                    .orElseThrow(() -> new CustomException(ErrorCode.THEATRE_NOT_FOUND));
            showtimeEntity = new ShowtimeEntity(showtimeDTO.getId(), movieEntity, theatreEntity, showtimeDTO.getShowtime());
        } catch(Exception e) {
            throw new CustomException(ErrorCode.SHOWTIME_ADD_FAILED, e.getMessage());
        }

        return convertToDTO(showtimeRepository.save(showtimeEntity));
    }
    
    private ShowtimeDTO convertToDTO(ShowtimeEntity showtimeEntity) {
        return new ShowtimeDTO(showtimeEntity.getId(), showtimeEntity.getMovie().getId(), showtimeEntity.getTheatreEntity().getId(), showtimeEntity.getShowtime());
    }

}
