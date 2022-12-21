package com.example.rickandmortymobdev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class indexController {
    @GetMapping("/{id}")
    public String getSingleCharacter(@PathVariable Optional<String> id){

        String idTemp = id.isPresent() ? id.get(): "1";

        System.out.println("en el controlador");
        System.out.println(idTemp);
        return "{\"id\":\"" + idTemp + "\"}";
    }
}

