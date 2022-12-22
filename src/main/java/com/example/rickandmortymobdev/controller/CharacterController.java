package com.example.rickandmortymobdev.controller;

import com.example.rickandmortymobdev.entity.CharacterDTO;
import com.example.rickandmortymobdev.entity.LocationDTO;
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
@RequestMapping("/api/v1")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getCharacterTemp(@PathVariable Optional<Integer> id){

        //System.out.println(id.orElse(1));

        CharacterDTO characterDTO = this.characterService.findByid(id.orElse(1));
        String urlLocation = characterDTO.getOrigin().getUrl();
        Integer idLocation = Integer.valueOf(urlLocation.substring(urlLocation.length()-1));
        System.out.println(idLocation);
        LocationDTO locationDTO = this.characterService.findLocationByid(idLocation);
        System.out.println(locationDTO.getResidents());


        //modificando y adaptando a la salida
        characterDTO.setOrigin(locationDTO);
        characterDTO.setEpisode_count(characterDTO.getEpisode().size());
        characterDTO.setEpisode(null);

        return new ResponseEntity<>(characterDTO, HttpStatus.OK);

    }

}

