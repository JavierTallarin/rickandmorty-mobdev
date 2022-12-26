package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.domain.MyCharacter;
import org.springframework.stereotype.Component;

@Component
public interface IfindById {

    public MyCharacter getContract(Integer id);

}
