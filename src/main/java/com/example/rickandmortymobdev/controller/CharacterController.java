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


    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getCharacterTemp(@PathVariable Optional<Integer> id){

        //System.out.println(id.orElse(1));

        CharacterDTO characterDTO = this.characterService.findByid(id.orElse(1));

        // TO DO:
        //no recibir DTO usar algun modelo
        //DTO -> capa modelo
        //objetos -> capa dominio

        String urlLocation = characterDTO.getOrigin().getUrl();
        System.out.println(urlLocation.length()+"*****");
        Integer idLocation = null;
        LocationDTO locationDTO = null;

        if(urlLocation.length() > 0){
            idLocation = Integer.valueOf(urlLocation.substring(urlLocation.length()-1));
            locationDTO = this.locationService.findByid(idLocation);
            System.out.println(locationDTO.getResidents());


        }

        if(locationDTO == null){
            locationDTO = new LocationDTO();
            locationDTO.setResidents(new ArrayList<>());
            locationDTO.setName("unknown");
            locationDTO.setUrl("");
            locationDTO.setDimension("");
        }
        //modificando y adaptando a la salida
        characterDTO.setOrigin(locationDTO);
        characterDTO.setEpisodeCount(characterDTO.getEpisode().size());
        characterDTO.setEpisode(null);

        System.out.println(idLocation);
        //LocationDTO locationDTO = this.characterService.findLocationByid(idLocation);

        return new ResponseEntity<>(characterDTO, HttpStatus.OK);

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

