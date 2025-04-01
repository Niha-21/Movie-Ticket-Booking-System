package com.movie.service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.service.entity.TheatreEntity;
import com.movie.service.exception.CustomException;
import com.movie.service.exception.ErrorCode;
import com.movie.service.model.TheatreDTO;
import com.movie.service.repository.TheatreRepository;
import com.movie.service.service.TheatreService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TheatreServiceImpl implements TheatreService{

    @Autowired
    private final TheatreRepository theatreRepository;

    @Override
    public List<TheatreDTO> getAllTheatres() throws CustomException {
        List<TheatreDTO> theatresList = new ArrayList<>();
        try{
            theatresList = theatreRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
        } catch(Exception e){
            throw new CustomException(ErrorCode.THEATRE_FETCH_FAILED, e.getMessage());
        }
        return theatresList;
    }

    @Override
    public TheatreDTO addTheatre(TheatreDTO theatreDTO) throws CustomException {
        TheatreEntity theatreEntity = null;
        try {
            theatreEntity = convertToEntity(theatreDTO);
        } catch(Exception e) {
            throw new CustomException(ErrorCode.THEATRE_ADD_FAILED, e.getMessage());
        }
        return convertToDTO(theatreRepository.save(theatreEntity));
    }

    private TheatreDTO convertToDTO(TheatreEntity theatreEntity) {
        return new TheatreDTO(theatreEntity.getId(), theatreEntity.getName(), theatreEntity.getLocation());
    }

    private TheatreEntity convertToEntity(TheatreDTO theatreDTO) {
        return new TheatreEntity(theatreDTO.getId(), theatreDTO.getName(), theatreDTO.getLocation());
    }
    
}
