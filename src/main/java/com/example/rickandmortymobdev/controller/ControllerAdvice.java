package com.example.rickandmortymobdev.controller;


import com.example.rickandmortymobdev.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
//https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/HttpClientErrorException.html

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = HttpClientErrorException.class)
    public ResponseEntity<ErrorDTO> runtimeExceptionHandler(HttpClientErrorException exception) {
        ErrorDTO errorDTO = ErrorDTO.builder().code(String.valueOf(exception.getStatusCode().value())).message(exception.getMessage()).build();

        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);

    }

}
