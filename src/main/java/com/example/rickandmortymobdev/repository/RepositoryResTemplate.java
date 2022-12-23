package com.example.rickandmortymobdev.repository;

import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import com.example.rickandmortymobdev.service.IService;
import org.springframework.beans.factory.annotation.Value;
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
        CharacterDTO characterDTO = restTemplate.getForObject(this.URL_BASE_CHARACTER.concat(id.toString()), CharacterDTO.class);

        return characterDTO;
    }

    @Override
    public LocationDTO findLocationById(Integer id) {
        LocationDTO locationDTO = restTemplate.getForObject(this.URL_BASE_LOCATION.concat(id.toString()), LocationDTO.class);

        return locationDTO;
    }
}
