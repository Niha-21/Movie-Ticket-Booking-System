package com.movie.service.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    MOVIE_FETCH_FAILED("MOVIE_FETCH_FAILED", "Error fetching Movies"),
    MOVIE_NOT_FOUND("MOVIE_NOT_FOUND", "Movie not found"),
    THEATRE_FETCH_FAILED("THEATRE_FETCH_FAILED", "Error fetching Theatres"),
    THEATRE_NOT_FOUND("THEATRE_NOT_FOUND", "Movie not found"),
    SHOWTIME_FETCH_FAILED("SHOWTIME_FETCH_FAILED", "Error fetching Showtimes"),
    MOVIE_ADD_FAILED("MOVIE_ADD_FAILED", "Failed to add Movie"),
    SHOWTIME_ADD_FAILED("SHOWTIME_ADD_FAILED", "Failed to add Showtime"),
    THEATRE_ADD_FAILED("THEATRE_ADD_FAILED", "Failed to add Showtime");

    private final String code;    
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
