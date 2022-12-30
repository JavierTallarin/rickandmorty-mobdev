package com.example.rickandmortymobdev.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class NotFoundCharacterException extends RuntimeException {
    private String code;
    private String message;

    public NotFoundCharacterException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
