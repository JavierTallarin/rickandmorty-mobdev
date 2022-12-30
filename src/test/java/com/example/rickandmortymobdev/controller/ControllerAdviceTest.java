package com.example.rickandmortymobdev.controller;

import com.example.rickandmortymobdev.exception.NotFoundCharacterException;
import com.example.rickandmortymobdev.model.ErrorDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ControllerAdviceTest {


    @Mock
    private ControllerAdvice controllerAdvice;

    @BeforeEach
    void setUp() {

    }
/*
    @Test
    void runtimeExceptionHandler_should_be_not_null_instance_ResponseEntity() {
        NotFoundCharacterException exception  = new NotFoundCharacterException();
        ErrorDTO errorDTO = ErrorDTO.builder().code("404").message("jajaj").build();

        when(ErrorDTO.builder().code("404").message(exception.getMessage()).build()).thenReturn(errorDTO);

        ResponseEntity responseEntity =  this.controllerAdvice.runtimeExceptionHandler(notFoundCharacterException);

        Assert.notNull(responseEntity, "ResponseEntity instance is null ");
    }*/
/*
    @Test
    public void testRuntimeExceptionHandler_returnsErrorDTO() {
        // Crea una instancia de NotFoundCharacterException
        NotFoundCharacterException exception = new NotFoundCharacterException("404", "not found character");
        ControllerAdvice a = this.controllerAdvice;
        // Configura el comportamiento esperado del mock de ControllerAdvice
        ErrorDTO errorDTO = ErrorDTO.builder().code("404").message("not found character").build();
        when(controllerAdvice.runtimeExceptionHandler(exception)).thenReturn(new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND));

        // Llama al método que quieres probar
        ResponseEntity<ErrorDTO> response = controllerAdvice.runtimeExceptionHandler(exception);

        // Verifica el resultado obtenido
        assertThat("jojojo",response.getStatusCode().equals(HttpStatus.NOT_FOUND));
        //assertThat(response.getBody()).isEqualToComparingFieldByField(errorDTO);
    }*/
}