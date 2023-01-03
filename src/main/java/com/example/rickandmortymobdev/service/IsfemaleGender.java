package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.domain.CharacterResponse;
import com.example.rickandmortymobdev.exception.GenderException;
import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import com.example.rickandmortymobdev.repository.IRepositoryCharacter;
import org.springframework.http.HttpStatus;

public class IsfemaleGender {
    private final IRepositoryCharacter iRepositoryCharacter;

    public IsfemaleGender(IRepositoryCharacter iRepositoryCharacter) {
        this.iRepositoryCharacter = iRepositoryCharacter;
    }
    public CharacterDTO execute(String id){
        CharacterDTO characterDTO = this.iRepositoryCharacter.findCharacterById(id);

        if(!characterDTO.getGender().equals("female")){
            throw new GenderException(String.valueOf(HttpStatus.BAD_GATEWAY.value()), "El character no es mujer");
        }

        return characterDTO;
    }
}
