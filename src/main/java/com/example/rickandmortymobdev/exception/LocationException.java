package com.example.rickandmortymobdev.exception;

public class LocationException extends RuntimeException {
    private String code;
    private String message;

    public LocationException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
