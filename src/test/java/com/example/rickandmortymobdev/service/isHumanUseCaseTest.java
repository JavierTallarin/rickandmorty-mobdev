package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.repository.IRepositoryCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
/*
* Tendrá un método que dado un id,
usara un gateway que trae un character
y retorna un "true" si es humano y false en otro caso
* */

@ExtendWith(MockitoExtension.class)
class isHumanUseCaseTest {
    @Mock
    private IRepositoryCharacter iRepositoryCharacter;

    private IsHumanUseCase isHumanUseCase;

    @BeforeEach
    void setUp() {
        this.isHumanUseCase = new IsHumanUseCase(this.iRepositoryCharacter);
    }

    @Test
    public void should_return_true_when_character_is_human_use_case(){
        boolean isHumanExpected = true;

        //given
        String id = "1";
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setId(1);
        characterDTO.setSpecies("Human");
        //when
        when(this.iRepositoryCharacter.findCharacterById(id)).thenReturn(characterDTO);

        boolean isHumanActual = isHumanUseCase.execute("1");

        //then
        assertEquals(isHumanExpected, isHumanActual);
    }



}