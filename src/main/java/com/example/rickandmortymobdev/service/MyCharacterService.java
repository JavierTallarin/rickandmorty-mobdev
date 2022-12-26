package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.domain.MyCharacter;
import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import com.example.rickandmortymobdev.repository.IRepository;
import org.springframework.stereotype.Service;

@Service
public class MyCharacterService implements IFindById {
    private final IRepository iRepository;

    public MyCharacterService(IRepository iRepository) {
        this.iRepository = iRepository;
    }

    @Override
    public MyCharacter getContract(Integer id) {
        CharacterDTO characterDTO = this.iRepository.findCharacterById(id);

        String urlLocation = characterDTO.getOrigin().getUrl();
        Integer idLocation = null;
        LocationDTO locationDTO = null;

        if(urlLocation.length() > 0){
            idLocation = Integer.valueOf(urlLocation.substring(urlLocation.length()-1));
            locationDTO = this.iRepository.findLocationById(idLocation);
        }

        if(locationDTO == null){
            locationDTO = new LocationDTO();
        }


        MyCharacter contract = new MyCharacter(characterDTO, locationDTO);

        return contract;
    }
}
