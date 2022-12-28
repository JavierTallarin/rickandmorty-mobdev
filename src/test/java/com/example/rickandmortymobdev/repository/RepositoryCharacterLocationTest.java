package com.example.rickandmortymobdev.repository;

import com.example.rickandmortymobdev.model.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
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
        this.repositoryCharacterLocation = new RepositoryCharacterLocation(urlBaseCharacter, urlBaseLocation, this.restTemplate);
    }

    @Test
    void should_be_characterDTO() throws Exception {
        when(this.repositoryCharacterLocation.findCharacterById("1")).thenReturn(new CharacterDTO());

        CharacterDTO characterDTO = this.repositoryCharacterLocation.findCharacterById("1");

        Assert.notNull(characterDTO, "characterDTO is null");

    }
}