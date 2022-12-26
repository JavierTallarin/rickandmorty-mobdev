package com.example.rickandmortymobdev.repository;

import com.example.rickandmortymobdev.model.CharacterDTO;


public interface IRepositoryCharacter {

    public CharacterDTO findCharacterById(String id);

}
