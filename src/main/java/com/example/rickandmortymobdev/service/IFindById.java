package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.domain.MyCharacter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface IFindById {

    public MyCharacter getContract(String id);

}
