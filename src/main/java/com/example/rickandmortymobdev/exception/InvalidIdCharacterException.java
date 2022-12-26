package com.example.rickandmortymobdev.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidIdCharacterException extends RuntimeException {
    private String code;
    private String message;

    public InvalidIdCharacterException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
