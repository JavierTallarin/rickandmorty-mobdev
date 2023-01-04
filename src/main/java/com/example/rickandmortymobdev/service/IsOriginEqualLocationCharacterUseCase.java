package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.exception.LocationException;
import com.example.rickandmortymobdev.model.CharacterDTO;
import org.springframework.http.HttpStatus;

public class IsOriginEqualLocationCharacterUseCase {

    public boolean execute(CharacterDTO characterDTO){
        if(characterDTO.getOrigin().getName().equals("unknown") || characterDTO.getLocation().getName().equals("unknown")){
            throw new LocationException(String.valueOf(HttpStatus.BAD_GATEWAY.value()), "location or origin are unknown");
        }

        return characterDTO.getOrigin().getName().equals(characterDTO.getLocation().getName());

    }
}
