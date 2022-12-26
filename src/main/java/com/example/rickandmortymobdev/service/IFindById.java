package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.domain.CharacterResponse;
import org.springframework.stereotype.Component;

@Component
public interface IFindById {

    public CharacterResponse getContract(String id);

}
