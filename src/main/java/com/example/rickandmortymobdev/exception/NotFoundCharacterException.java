package com.example.rickandmortymobdev.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Setter
@Getter
public class NotFoundCharacterException extends HttpClientErrorException{
    private String code;
    private String message;

    public NotFoundCharacterException(String code, String message) {
        super(HttpStatus.valueOf("404"));
        this.code = code;
        this.message = message;
    }

}
