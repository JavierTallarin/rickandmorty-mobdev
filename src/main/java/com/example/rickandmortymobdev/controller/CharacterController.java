package com.example.rickandmortymobdev.controller;

import com.example.rickandmortymobdev.domain.CharacterResponse;
import com.example.rickandmortymobdev.service.IFindCharacterResponseById;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CharacterController {

    private final IFindCharacterResponseById iFindCharacterResponseById;

    public CharacterController(IFindCharacterResponseById iFindCharacterResponseById) {
        this.iFindCharacterResponseById = iFindCharacterResponseById;

    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterResponse> getContract(@PathVariable Optional<String> id){

        CharacterResponse characterResponse = this.iFindCharacterResponseById.getCharacterResponse(id.orElse(""));

        return  ResponseEntity.ok(characterResponse);
    }

}

