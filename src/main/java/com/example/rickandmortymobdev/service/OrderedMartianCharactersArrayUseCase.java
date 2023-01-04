package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.repository.FindListCharacterRepository;

import java.util.*;
import java.util.stream.Collectors;

public class OrderedMartianCharactersArrayUseCase {

    private final FindListCharacterRepository findListCharacterRepository;
    private final MartianLanguajeDictionary martianLanguajeDictionary;

    public OrderedMartianCharactersArrayUseCase(FindListCharacterRepository findListCharacterRepository, MartianLanguajeDictionary martianLanguajeDictionary) {
        this.findListCharacterRepository = findListCharacterRepository;
        this.martianLanguajeDictionary = martianLanguajeDictionary;
    }


    public List<CharacterDTO> execute(){

        List<CharacterDTO> listCharacters = new ArrayList<>(this.findListCharacterRepository.execute());

        Map<String, String> martianLanguaje= this.martianLanguajeDictionary.execute();


        List<CharacterDTO> listOrdeneredMartianLanguaje;

        listOrdeneredMartianLanguaje = listCharacters.stream().map((CharacterDTO c) -> {
            StringBuilder sb = new StringBuilder();

            if(c.getLocation().getName().equals("Mars")){
                Arrays.stream(c.getName().split("")).forEach((String i) -> {
                    String temp = i;

                    if(i.matches(".*[aeiouAEIOU].*")){
                        temp = martianLanguaje.get(i.toLowerCase());
                    }

                    sb.append(temp);
                });

                c.setName(sb.toString());
            }


            return  c;
        }).collect(Collectors.toList());

       listOrdeneredMartianLanguaje.sort(Comparator.comparing((CharacterDTO c) -> c.getName().toLowerCase()));

       return  listOrdeneredMartianLanguaje;
    }


}
