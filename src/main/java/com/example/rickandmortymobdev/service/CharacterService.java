package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.domain.Contract;
import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import com.example.rickandmortymobdev.repository.IRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CharacterService {
    @Value("${external.rickandmorty.api.character.urlBase}")
    private String URL_BASE;


    private final RestTemplate restTemplate;

    private final IRepository iRepository;

    public CharacterService(RestTemplate restTemplate, IRepository iRepository) {
        this.restTemplate = restTemplate;
        this.iRepository = iRepository;
    }

    //TODO:
    // crear interfaz SOLID

    //private String UrlBase = "https://rickandmortyapi.com/api/character/";


    public CharacterDTO findByid(Integer idTemp) {


        CharacterDTO characterDTO = restTemplate.getForObject(this.URL_BASE.concat(idTemp.toString()), CharacterDTO.class);


        return characterDTO;
    }


}
