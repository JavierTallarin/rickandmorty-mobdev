package com.example.rickandmortymobdev.controller;


import com.example.rickandmortymobdev.exception.InvalidIdCharacterException;
import com.example.rickandmortymobdev.exception.NotFoundCharacterException;
import com.example.rickandmortymobdev.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/HttpClientErrorException.html

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = NotFoundCharacterException.class)
    public ResponseEntity<ErrorDTO> runtimeExceptionHandler(NotFoundCharacterException exception) {
        ErrorDTO errorDTO = ErrorDTO.builder().code("404").message(exception.getMessage()).build();

        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(value = InvalidIdCharacterException.class)
    public ResponseEntity<ErrorDTO> invalidCharacterException(InvalidIdCharacterException exception){
        ErrorDTO errorDTO = ErrorDTO.builder().code("500").message(exception.getMessage()).build();

        return  new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
