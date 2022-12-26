package com.example.rickandmortymobdev.exception;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class NotFoundCharacterException extends RuntimeException {
    private String code;
    private String message;

    public NotFoundCharacterException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
