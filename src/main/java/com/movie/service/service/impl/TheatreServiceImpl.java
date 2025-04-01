package com.movie.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.service.entity.TheatreEntity;
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
    public List<TheatreDTO> getAllTheatres() {
        return theatreRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public TheatreDTO addTheatre(TheatreDTO theatreDTO) {
        TheatreEntity theatreEntity = convertToEntity(theatreDTO);
        return convertToDTO(theatreRepository.save(theatreEntity));
    }

    private TheatreDTO convertToDTO(TheatreEntity theatreEntity) {
        return new TheatreDTO(theatreEntity.getId(), theatreEntity.getName(), theatreEntity.getLocation());
    }

    private TheatreEntity convertToEntity(TheatreDTO theatreDTO) {
        return new TheatreEntity(theatreDTO.getId(), theatreDTO.getName(), theatreDTO.getLocation());
    }
    
}
