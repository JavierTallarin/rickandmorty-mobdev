package com.example.rickandmortymobdev.exception;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;


@Setter
@Getter
public class NotCharacterException extends HttpClientErrorException{
    private String code;
    private String message;

    public NotCharacterException(String code, String message) {
        super(HttpStatus.valueOf("404"));
        this.code = code;
        this.message = message;
    }
}
