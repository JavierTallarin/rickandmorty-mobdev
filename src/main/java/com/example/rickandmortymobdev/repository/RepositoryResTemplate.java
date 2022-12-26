package com.example.rickandmortymobdev.repository;

import com.example.rickandmortymobdev.exception.InvalidCharacterException;
import com.example.rickandmortymobdev.exception.NotFoundCharacterException;
import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;



@Component
public class RepositoryResTemplate implements IRepository{
    @Value("${external.rickandmorty.api.character.urlBase}")
    private String URL_BASE_CHARACTER;

    @Value("${external.rickandmorty.api.location.urlBase}")
    private String URL_BASE_LOCATION;
    private final RestTemplate restTemplate;
    private  final HttpEntity<String> requestEntity;


    public RepositoryResTemplate(RestTemplate restTemplate, HttpEntity<String> requestEntity) {
        this.restTemplate = restTemplate;
        this.requestEntity = requestEntity;
    }

    @Override
    public CharacterDTO findCharacterById(String id) {

        ResponseEntity<CharacterDTO> response = null;

        try {
            response = restTemplate.exchange(this.URL_BASE_CHARACTER.concat(id), HttpMethod.GET, this.requestEntity, CharacterDTO.class);
        }catch (HttpStatusCodeException ex){

            if(ex.getStatusCode() == HttpStatus.NOT_FOUND){
                throw  new NotFoundCharacterException("404", "not found character with id : "+id);
            }
            if(ex.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
                throw  new InvalidCharacterException("500", "invalid character id : "+id);
            }


        }

        return  response.getBody();
    }

    @Override
    public LocationDTO findLocationById(String id) {
        LocationDTO locationDTO = restTemplate.getForObject(this.URL_BASE_LOCATION.concat(id), LocationDTO.class);

        return locationDTO;
    }


}
