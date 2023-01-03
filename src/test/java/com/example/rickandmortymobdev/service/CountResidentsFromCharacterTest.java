package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountResidentsFromCharacterTest {

    private CountResidentsFromCharacter countResidentsFromCharacter;

    @BeforeEach
    void setUp() {
        this.countResidentsFromCharacter = new CountResidentsFromCharacter();
    }

    @Test
    void should_return_count_residents_from_character(){
        Integer countResuidentsExpected = 6;
        // Given
        List<CharacterDTO> list;
        LocationDTO mars = new LocationDTO();
        mars.setName("Mars");
        mars.setResidents(List.of("et", "don francisco", "depredador"));
        LocationDTO other = new LocationDTO();
        other.setName("Earth");
        other.setResidents(List.of("juan", "pedro", "francisco"));

        CharacterDTO characterDTO1 = new CharacterDTO();
        characterDTO1.setId(1);
        characterDTO1.setName("javier");
        characterDTO1.setSpecies("Alien");
        characterDTO1.setLocation(mars);


        CharacterDTO characterDTO4 = new CharacterDTO();
        characterDTO4.setId(3);
        characterDTO4.setName("belen");
        characterDTO4.setSpecies("Alien");
        characterDTO4.setLocation(other);

        list = List.of(characterDTO1, characterDTO4);


        // When
        Integer countResuidentsActual = this.countResidentsFromCharacter.execute(list);

        // Then
        assertSame(countResuidentsExpected, countResuidentsActual);
    }
}