package com.example.rickandmortymobdev.repository;

import com.example.rickandmortymobdev.exception.InvalidIdCharacterException;
import com.example.rickandmortymobdev.exception.NotFoundCharacterException;
import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RepositoryCharacterLocationTest {

    @Mock
    private RestTemplate restTemplate;

    @Value("${external.rickandmorty.api.character.urlBase}")
    private String urlBaseCharacter;
    @Value("${external.rickandmorty.api.location.urlBase}")
    private String urlBaseLocation;
    private RepositoryCharacterLocation repositoryCharacterLocation;


    @BeforeEach
    void setUp() {
        this.urlBaseCharacter = "https://rickandmortyapi.com/api/character/";
        this.urlBaseLocation = "https://rickandmortyapi.com/api/location/";

        this.repositoryCharacterLocation = new RepositoryCharacterLocation(urlBaseCharacter, urlBaseLocation, this.restTemplate);

    }

    @Test
    void should_be_characterDTO_Not_Null() throws Exception {

        CharacterDTO characterDTO = new CharacterDTO();
        String id="1";
        characterDTO.setId(1);
        // injection value is null

        when(restTemplate.getForObject(this.urlBaseCharacter.concat(id), CharacterDTO.class)).thenReturn(characterDTO);

        // Llama al método que quieres probar
        CharacterDTO characterDTOReturn = this.repositoryCharacterLocation.findCharacterById("1");


        Assert.notNull(characterDTOReturn, "characterDTO is null");

    }

    @Test
    void should_return_LocationDTO_Not_Null() throws Exception {

        //Given
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setUrl("google.cl");
        String id="1";
        when(restTemplate.getForObject(this.urlBaseLocation.concat(id), LocationDTO.class)).thenReturn(locationDTO);

        //when
        LocationDTO locationDTOReturn = this.repositoryCharacterLocation.findLocationById(id);

        //then
        Assert.notNull(locationDTOReturn, "LocationDTO instance is null");
    }

    @Test
    void should_return_Not_found_character_exception(){
        //Given
        String id="1";

        //When
        when(restTemplate.getForObject(this.urlBaseCharacter.concat(id), CharacterDTO.class)).thenThrow(new HttpStatusCodeException(HttpStatus.NOT_FOUND) {});

        //RepositoryCharacterLocation repository  = new RepositoryCharacterLocation(this.urlBaseCharacter, this.urlBaseLocation, this.restTemplate);

        // Then
        assertThrows(NotFoundCharacterException.class, () -> this.repositoryCharacterLocation.findCharacterById("1"), "not found character NotFoundCharacterException");

    }

    @Test
    void should_return_invalid_character_exception(){
        String id="1";
        when(restTemplate.getForObject(this.urlBaseCharacter.concat(id), CharacterDTO.class)).thenThrow(new HttpStatusCodeException(HttpStatus.INTERNAL_SERVER_ERROR){});

        assertThrows(InvalidIdCharacterException.class, () -> this.repositoryCharacterLocation.findCharacterById("1"), "not found InvalidIdCharacterException");

    }




}