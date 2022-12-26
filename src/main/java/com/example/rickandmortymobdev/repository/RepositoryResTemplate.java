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


    public RepositoryResTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    @Override
    public CharacterDTO findCharacterById(Integer id) {

        ResponseEntity<CharacterDTO> response = null;

        if(id > 826){
            throw  new NotFoundCharacterException("404", "Not Found Character");
        }

        response = restTemplate.exchange(this.URL_BASE_CHARACTER.concat(id.toString()), HttpMethod.GET, this.getRequestEntity(), CharacterDTO.class);




        return  response.getBody();
    }

    @Override
    public LocationDTO findLocationById(Integer id) {
        LocationDTO locationDTO = restTemplate.getForObject(this.URL_BASE_LOCATION.concat(id.toString()), LocationDTO.class);

        return locationDTO;
    }

    public HttpEntity<String> getRequestEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Header", "value");
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        return  requestEntity;
    }
}
