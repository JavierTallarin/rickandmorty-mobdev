package com.example.rickandmortymobdev.controller;

import com.example.rickandmortymobdev.domain.MyCharacter;
import com.example.rickandmortymobdev.service.IfindById;

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

    private final IfindById ifindById;

    public CharacterController(IfindById ifindById) {
        this.ifindById = ifindById;

    }

    @GetMapping("/{id}")
    public ResponseEntity<MyCharacter> getContract(@PathVariable Optional<Integer> id){

        MyCharacter contract = ifindById.getContract(id.orElse(1));

        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

}

