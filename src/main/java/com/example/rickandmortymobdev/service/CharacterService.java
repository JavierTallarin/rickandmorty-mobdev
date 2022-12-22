package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.domain.Contract;
import com.example.rickandmortymobdev.model.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CharacterService implements IService {
    @Value("${external.rickandmorty.api.character.urlBase}")
    private String URL_BASE;

    @Autowired
    private RestTemplate restTemplate;

    //TODO:
    // crear interfaz SOLID

    //private String UrlBase = "https://rickandmortyapi.com/api/character/";


    public CharacterDTO findByid(Integer idTemp) {


        CharacterDTO characterDTO = restTemplate.getForObject(this.URL_BASE.concat(idTemp.toString()), CharacterDTO.class);


        return characterDTO;
    }

    @Override
    public Contract getContract(Integer id) {
        //GET DTO from repository
        //Create a contract with dto's data
        //get contract

        return null;
    }
}
