package com.example.rickandmortymobdev.repository;

import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import org.springframework.web.client.RestTemplate;

public class RepositoryResTemplate implements IRepository{
    private final RestTemplate restTemplate;

    public RepositoryResTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CharacterDTO findCharacterById(Integer id) {
        return null;
    }

    @Override
    public LocationDTO findLocationById(Integer id) {
        return null;
    }
}
