package com.movie.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "theatre")
public class TheatreEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    public TheatreEntity() {}

    public TheatreEntity(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

}
