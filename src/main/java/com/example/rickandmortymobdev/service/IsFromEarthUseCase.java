package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.domain.CharacterResponse;
import com.example.rickandmortymobdev.model.CharacterDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IsFromEarthUseCase {
    public static Boolean execute(CharacterResponse character){

        return character.getOrigin().getName().equals("Earth");
    }
}
