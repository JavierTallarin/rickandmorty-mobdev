package com.example.rickandmortymobdev.controller;


import com.example.rickandmortymobdev.exception.InvalidCharacterException;
import com.example.rickandmortymobdev.exception.NotFoundCharacterException;
import com.example.rickandmortymobdev.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
//https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/HttpClientErrorException.html

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = NotFoundCharacterException.class)
    public ResponseEntity<ErrorDTO> runtimeExceptionHandler(NotFoundCharacterException exception) {
        //ErrorDTO errorDTO = ErrorDTO.builder().code(String.valueOf(exception.getStatusCode().value())).message(exception.getMessage()).build();
        ErrorDTO errorDTO = ErrorDTO.builder().code("404").message(exception.getMessage()).build();

        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(value = InvalidCharacterException.class)
    public ResponseEntity<ErrorDTO> invalidCharacterException(InvalidCharacterException exception){
        ErrorDTO errorDTO = ErrorDTO.builder().code("500").message(exception.getMessage()).build();

        return  new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
