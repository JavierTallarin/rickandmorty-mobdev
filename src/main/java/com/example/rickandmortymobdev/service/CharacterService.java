package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.entity.CharacterDTO;
import com.example.rickandmortymobdev.entity.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CharacterService {
    @Value("${external.rickandmorty.api.character.urlBase}")
    private String URL_BASE;

    @Autowired
    private RestTemplate restTemplate;

    //private String UrlBase = "https://rickandmortyapi.com/api/character/";


    public CharacterDTO findByid(Integer idTemp) {
        System.out.println(this.URL_BASE+idTemp.toString());

        CharacterDTO characterDTO = restTemplate.getForObject(this.URL_BASE.concat(idTemp.toString()), CharacterDTO.class);


        return characterDTO;
    }

}
