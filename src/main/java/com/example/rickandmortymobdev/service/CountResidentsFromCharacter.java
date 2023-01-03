package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.model.CharacterDTO;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CountResidentsFromCharacter {
    public Integer execute(List<CharacterDTO> characterDTOList){
        AtomicReference<Integer> total = new AtomicReference<>(0);

        characterDTOList.forEach((CharacterDTO c) ->{
            if(c.getSpecies().equals("Alien")){
                 Integer temp = c.getLocation().getResidents().stream().reduce(0, (acc, resident) -> acc + 1, (x, y) -> x + y);
                 total.updateAndGet(v -> v + temp);
            }
        });
        int b = characterDTOList
                .stream()
                .reduce(0,
                        (acc, character) -> acc + (((character.getSpecies().equals("Alien"))) ? character.getLocation().getResidents().size() : 0)
                        , (x, y) -> x+y);

        return total.get();
    }


}
