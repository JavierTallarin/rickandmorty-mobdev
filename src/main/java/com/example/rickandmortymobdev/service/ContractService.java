package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.domain.Contract;
import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import com.example.rickandmortymobdev.repository.IRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ContractService  implements IService{
    private final IRepository iRepository;

    public ContractService(IRepository iRepository) {
        this.iRepository = iRepository;
    }

    @Override
    public Contract getContract(Integer id) {
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


        Contract contract = new Contract(characterDTO, locationDTO);

        return contract;
    }
}
