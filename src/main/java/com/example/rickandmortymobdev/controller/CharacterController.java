package com.example.rickandmortymobdev.controller;

import com.example.rickandmortymobdev.entity.CharacterDTO;
import com.example.rickandmortymobdev.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping("/{id}")
    //ResponseEntity<CharacterRyM>
    public String getSingleCharacter(@PathVariable Optional<Integer> id){

        Integer idTemp = id.orElse(1);
        CharacterDTO character = characterService.findByid(idTemp);

        System.out.println("en el controlador");
        System.out.println(idTemp);

        //CharacterRyM character = characterService.findByid(idTemp);

        return "{\"id\":\"" + idTemp.toString() + "\"}";
    }
    @GetMapping("/test/{id}")
    public ResponseEntity<CharacterDTO> getCharacterTemp(@PathVariable Optional<Integer> id){

        //System.out.println(id.orElse(1));

        CharacterDTO characterDTO = this.characterService.findByid(id.orElse(1));
        System.out.println(characterDTO.getName());
        return new ResponseEntity<>(characterDTO, HttpStatus.OK);

    }

}

