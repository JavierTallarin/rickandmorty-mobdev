package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.domain.CharacterResponse;
import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import com.example.rickandmortymobdev.repository.IRepositoryCharacter;
import com.example.rickandmortymobdev.repository.IRepositoryLocation;
import org.springframework.stereotype.Service;

@Service
public class CharacterResponseService implements IFindCharacterResponseById {
    private final IRepositoryCharacter iRepositoryCharacter;
    private final IRepositoryLocation iRepositoryLocation;

    public CharacterResponseService(IRepositoryCharacter iRepositoryCharacter, IRepositoryLocation iRepositoryLocation) {
        this.iRepositoryCharacter = iRepositoryCharacter;
        this.iRepositoryLocation = iRepositoryLocation;
    }

    @Override
    public CharacterResponse getCharacterResponse(String id) {
        CharacterDTO characterDTO = this.iRepositoryCharacter.findCharacterById(id);

        String urlLocation = characterDTO.getOrigin().getUrl();
        String idLocation = null;
        LocationDTO locationDTO = null;

        if(urlLocation.length() > 0){
            idLocation = urlLocation.substring(urlLocation.length()-1);
            locationDTO = this.iRepositoryLocation.findLocationById(idLocation);
        }

        if(locationDTO == null){
            locationDTO = new LocationDTO();
        }


        CharacterResponse characterResponse = new CharacterResponse(characterDTO, locationDTO);

        return characterResponse;
    }
}
