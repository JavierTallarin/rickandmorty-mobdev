package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.entity.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CharacterService {
    @Autowired
    RestTemplate restTemplate;
    public CharacterDTO findByid(Integer idTemp) {

        return new CharacterDTO();
    }
}
