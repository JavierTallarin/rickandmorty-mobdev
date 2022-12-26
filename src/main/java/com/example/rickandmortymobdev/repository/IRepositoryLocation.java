package com.example.rickandmortymobdev.repository;

import com.example.rickandmortymobdev.model.LocationDTO;

public interface IRepositoryLocation {
    public LocationDTO findLocationById(String id);
}
