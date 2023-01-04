package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.exception.LocationException;
import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class IsOriginEqualLocationCharacterUseCaseTest {

    private IsOriginEqualLocationCharacterUseCase isOriginEqualLocationCharacterUseCase;
    @BeforeEach
    void setUp() {
        this.isOriginEqualLocationCharacterUseCase = new IsOriginEqualLocationCharacterUseCase();
    }
    @Test
    void should_return_true_when_origin_and_location_are_equal() {
        boolean expected = true;
        //given
        CharacterDTO characterDTOExpected = new CharacterDTO();
        characterDTOExpected.setId(4);
        LocationDTO origin = new LocationDTO();
        origin.setName("Earth (Replacement Dimension)");
        LocationDTO location = new LocationDTO();
        location.setName("Earth (Replacement Dimension)");
        characterDTOExpected.setOrigin(origin);
        characterDTOExpected.setLocation(location);

        //when
        boolean actual = isOriginEqualLocationCharacterUseCase.execute(characterDTOExpected);

        //then
        assertEquals(expected, actual);

    }

    @Test
    void should_throw_location_exception_when_location_or_origin_are_unknown(){
        //given
        CharacterDTO characterDTOExpected = new CharacterDTO();
        characterDTOExpected.setId(4);
        LocationDTO origin = new LocationDTO();
        origin.setName("unknown");
        LocationDTO location = new LocationDTO();
        location.setName("Earth (Replacement Dimension)");
        characterDTOExpected.setOrigin(origin);
        characterDTOExpected.setLocation(location);
        //when

        //then
        assertThrows(LocationException.class, () -> this.isOriginEqualLocationCharacterUseCase.execute(characterDTOExpected));

    }
}