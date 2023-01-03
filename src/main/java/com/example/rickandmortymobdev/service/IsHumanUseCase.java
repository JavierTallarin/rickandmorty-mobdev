package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.repository.IRepositoryCharacter;

public class IsHumanUseCase {
    private final IRepositoryCharacter iRepositoryCharacter;


    public IsHumanUseCase(IRepositoryCharacter iRepositoryCharacter) {
        this.iRepositoryCharacter = iRepositoryCharacter;
    }

    public boolean execute(String id){
        CharacterDTO characterDTO = this.iRepositoryCharacter.findCharacterById(id);

        return characterDTO.getSpecies().equals("Human");
    }
}
