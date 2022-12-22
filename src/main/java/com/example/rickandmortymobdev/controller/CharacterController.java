package com.example.rickandmortymobdev.controller;

import com.example.rickandmortymobdev.domain.CharacterDTO;
import com.example.rickandmortymobdev.domain.LocationDTO;
import com.example.rickandmortymobdev.service.CharacterService;
import com.example.rickandmortymobdev.service.LocationService;
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

    private final CharacterService characterService;

    private final LocationService locationService;

    public CharacterController(CharacterService characterService, LocationService locationService) {
        this.characterService = characterService;
        this.locationService = locationService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getCharacterTemp(@PathVariable Optional<Integer> id){

        //System.out.println(id.orElse(1));

        CharacterDTO characterDTO = this.characterService.findByid(id.orElse(1));

        // TO DO:
        //no recibir DTO usar algun modelo
        //DTO -> capa modelo
        //objetos -> capa dominio

        String urlLocation = characterDTO.getOrigin().getUrl();
        Integer idLocation = Integer.valueOf(urlLocation.substring(urlLocation.length()-1));
        System.out.println(idLocation);
        //LocationDTO locationDTO = this.characterService.findLocationByid(idLocation);
        LocationDTO locationDTO = this.locationService.findByid(idLocation);

        System.out.println(locationDTO.getResidents());


        //modificando y adaptando a la salida
        characterDTO.setOrigin(locationDTO);
        characterDTO.setEpisodeCount(characterDTO.getEpisode().size());
        characterDTO.setEpisode(null);

        return new ResponseEntity<>(characterDTO, HttpStatus.OK);

    }

}

