package com.example.rickandmortymobdev.repository;

import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;

import java.util.List;

public class FindListCharacterRepository {
    public List<CharacterDTO> execute(){
        LocationDTO mars = new LocationDTO();
        mars.setName("Mars");
        LocationDTO other = new LocationDTO();
        other.setName("Earth");

        CharacterDTO characterDTO1 = new CharacterDTO();
        characterDTO1.setId(1);
        characterDTO1.setName("javier");
        characterDTO1.setLocation(other);

        CharacterDTO characterDTO2 = new CharacterDTO();
        characterDTO2.setId(4);
        characterDTO2.setName("alien");
        characterDTO2.setLocation(mars);

        CharacterDTO characterDTO3 = new CharacterDTO();
        characterDTO3.setId(2);
        characterDTO3.setName("ET");
        characterDTO3.setLocation(mars);

        CharacterDTO characterDTO4 = new CharacterDTO();
        characterDTO4.setId(3);
        characterDTO4.setName("belen");
        characterDTO4.setLocation(other);

        CharacterDTO characterDTO5 = new CharacterDTO();
        characterDTO5.setId(5);
        characterDTO5.setName("predator");
        characterDTO5.setLocation(mars);

        return List.of(characterDTO1, characterDTO2, characterDTO3, characterDTO4, characterDTO5);
    }
}
