package com.example.rickandmortymobdev.controller;

import com.example.rickandmortymobdev.domain.Contract;
import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import com.example.rickandmortymobdev.service.CharacterService;
import com.example.rickandmortymobdev.service.IService;
import com.example.rickandmortymobdev.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CharacterController {

    private final IService iservice;
    private final CharacterService characterService;

    private final LocationService locationService;

    public CharacterController(IService iservice, CharacterService characterService, LocationService locationService) {
        this.iservice = iservice;
        this.characterService = characterService;
        this.locationService = locationService;
    }


    @GetMapping("/test/{id}")
    public ResponseEntity<Contract> getContract(@PathVariable Optional<Integer> id){

        //temp
        if(id.orElse(1) > 826){
            System.out.println("entrooo");
            return new ResponseEntity<>(new Contract(), HttpStatus.NOT_FOUND);
        }

        Contract contract = iservice.getContract(id.orElse(1));

        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

}

