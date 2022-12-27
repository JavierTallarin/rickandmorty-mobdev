package com.example.rickandmortymobdev.repository;

import com.example.rickandmortymobdev.exception.InvalidIdCharacterException;
import com.example.rickandmortymobdev.exception.NotFoundCharacterException;
import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;



@Component
public class RepositoryCharacterLocation implements IRepositoryCharacter, IRepositoryLocation {

    private final String urlBaseCharacter;

    private final String urlBaseLocation;
    private final RestTemplate restTemplate;


    public RepositoryCharacterLocation(@Value("${external.rickandmorty.api.character.urlBase}") String urlBaseCharacter, @Value("${external.rickandmorty.api.location.urlBase}") String urlBaseLocation, RestTemplate restTemplate) {
        this.urlBaseCharacter = urlBaseCharacter;
        this.urlBaseLocation = urlBaseLocation;
        this.restTemplate = restTemplate;
    }

    @Override
    public CharacterDTO findCharacterById(String id) {

        CharacterDTO characterDTO = null;

        try {

            characterDTO = restTemplate.getForObject(this.urlBaseCharacter.concat(id), CharacterDTO.class);

        }catch (HttpStatusCodeException ex){

            if(ex.getStatusCode() == HttpStatus.NOT_FOUND){
                throw  new NotFoundCharacterException(String.valueOf(HttpStatus.NOT_FOUND.value()), "not found character");
            }
            if(ex.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
                throw  new InvalidIdCharacterException(String.valueOf(HttpStatus.BAD_GATEWAY.value()), "rick and morty external service rejects request for invalid id");
            }

        }

        return characterDTO;
    }

    @Override
    public LocationDTO findLocationById(String id) {
        LocationDTO locationDTO = restTemplate.getForObject(this.urlBaseLocation.concat(id), LocationDTO.class);

        return locationDTO;
    }


}
