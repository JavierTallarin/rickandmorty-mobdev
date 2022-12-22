package com.example.rickandmortymobdev.repository;

import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;

public interface IRepository {

    public CharacterDTO findCharacterById(Integer id);

    public LocationDTO findLocationById(Integer id);

}
