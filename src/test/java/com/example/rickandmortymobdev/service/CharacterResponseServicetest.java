package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.controller.CharacterController;
import com.example.rickandmortymobdev.domain.CharacterResponse;
import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import com.example.rickandmortymobdev.repository.IRepositoryCharacter;
import com.example.rickandmortymobdev.repository.IRepositoryLocation;
import com.example.rickandmortymobdev.service.CharacterResponseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.util.Assert;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CharacterResponseServicetest {

    private  CharacterResponseService characterResponseService;
    @Mock
    private  IRepositoryCharacter iRepositoryCharacter;
    @Mock
    private IRepositoryLocation iRepositoryLocation;


    @BeforeEach
    void setup(){

        this.characterResponseService = new CharacterResponseService(this.iRepositoryCharacter, this.iRepositoryLocation);

    }

    @Test
    void should_Not_Null_CharacterDTO_CharacterResponse() throws Exception {

        when(this.iRepositoryCharacter.findCharacterById("1")).thenReturn(new CharacterDTO());

        CharacterDTO characterDTO = this.iRepositoryCharacter.findCharacterById("1");

        // Asert
        Assert.notNull(characterDTO, "characterDTO is null");

    }

    @Test
    void should_Not_Null_LocationDTO_CharacterResponse() throws Exception {

        when(this.iRepositoryLocation.findLocationById("1")).thenReturn(new LocationDTO());

        LocationDTO locationDTO = this.iRepositoryLocation.findLocationById("1");

        // Asert
        Assert.notNull(locationDTO, "locationDTO is null");

    }
/*
    @Test
    void should_Return_Not_Null_GetCharacterResponse() throws Exception {
        when(this.iRepositoryCharacter.findCharacterById("1")).thenReturn(new CharacterDTO());



        CharacterResponse characterResponse = this.characterResponseService.getCharacterResponse("1");


        // Asert
        Assert.notNull(characterResponse, "characterResponse is null");

    } */



}
