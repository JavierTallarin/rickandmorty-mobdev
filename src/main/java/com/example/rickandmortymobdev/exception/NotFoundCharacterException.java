package com.example.rickandmortymobdev.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

@Setter
@Getter
public class NotFoundCharacterException extends RuntimeException {
    private String code;
    private String message;

    public NotFoundCharacterException(String code, String message) {
        super("not found character");
        this.code = code;
        this.message = message;
    }

}
