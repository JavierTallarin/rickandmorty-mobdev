package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.domain.CharacterResponse;
import com.example.rickandmortymobdev.exception.GenderException;
import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.repository.IRepositoryCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IsfemaleGenderTest {
    @Mock
    private IRepositoryCharacter iRepositoryCharacter;
    private IsfemaleGender isfemaleGender;
    @BeforeEach
    void setUp() {
        this.isfemaleGender = new IsfemaleGender(this.iRepositoryCharacter);
    }

    @Test
    void should_return_CharacterResponse_instance() throws Exception {
        //given
        CharacterDTO characterDTOExpected = new CharacterDTO();
        characterDTOExpected.setName("Summer Smith");
        characterDTOExpected.setId(3);
        characterDTOExpected.setGender("female");
        //characterDTOExpected.setGender("male");
        String id = "3";

        //when
        when(this.iRepositoryCharacter.findCharacterById(id)).thenReturn(characterDTOExpected);


        CharacterDTO characterDTOActual = this.isfemaleGender.execute(id);

        //then

       assertEquals(characterDTOExpected, characterDTOActual);
       assertDoesNotThrow(() -> this.iRepositoryCharacter.findCharacterById(id));
    }

    @Test
    void should_throw_GenderException_is_not_female_gender(){
        //given
        CharacterDTO characterDTOExpected = new CharacterDTO();
        characterDTOExpected.setName("Summer Smith");
        characterDTOExpected.setId(1);
        characterDTOExpected.setGender("male");
        String id = "1";

        //when
        when(this.iRepositoryCharacter.findCharacterById(id)).thenReturn(characterDTOExpected);

        assertThrows(GenderException.class, () -> this.isfemaleGender.execute(id));
    }

}