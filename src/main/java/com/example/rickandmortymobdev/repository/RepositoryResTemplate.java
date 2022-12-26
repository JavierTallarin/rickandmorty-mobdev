package com.example.rickandmortymobdev.repository;

import com.example.rickandmortymobdev.exception.NotFoundCharacterException;
import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
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
    public CharacterDTO findCharacterById(Integer id) {

        ResponseEntity<CharacterDTO> response = null;

        try {
            response = restTemplate.exchange(this.URL_BASE_CHARACTER.concat(id.toString()), HttpMethod.GET, this.requestEntity, CharacterDTO.class);

        }catch(NotFoundCharacterException ex){}


        return  response.getBody();
    }

    @Override
    public LocationDTO findLocationById(Integer id) {
        LocationDTO locationDTO = restTemplate.getForObject(this.URL_BASE_LOCATION.concat(id.toString()), LocationDTO.class);

        return locationDTO;
    }


}
