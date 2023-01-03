package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.domain.CharacterResponse;
import com.example.rickandmortymobdev.model.LocationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/*
Tendrá un método que recibe un objeto del tipo Character
si el objeto tiene un atributo Origin que diga que es del planeta "Earth"
entonces retorna un true, false en cualquier otro caso
*/

class IsFromEarthUseCaseTest {
    private IsFromEarthUseCase isFromEarthUseCase;

    @BeforeEach
    void setUp() {
        IsFromEarthUseCase isFromEarthUseCase = new IsFromEarthUseCase();
    }

    @Test
    void should_return_true_when_origin_is_from_Earth(){
        Boolean responseExpected = true;
        // given

        CharacterResponse characterResponseExpected = new CharacterResponse();
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setName("Earth");
        characterResponseExpected.setOrigin(locationDTO);

        //when
        Boolean responseActual = this.isFromEarthUseCase.execute(characterResponseExpected);

        //then
        assertEquals(responseExpected, responseActual);



    }

}