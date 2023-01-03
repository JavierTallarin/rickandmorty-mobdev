package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.repository.FindListCharacterRepository;

import java.util.*;
import java.util.stream.Collectors;

public class OrderedMartianCharactersArray {

    private final FindListCharacterRepository findListCharacterRepository;

    public OrderedMartianCharactersArray(FindListCharacterRepository findListCharacterRepository) {
        this.findListCharacterRepository = findListCharacterRepository;
    }


    public List<CharacterDTO> execute(){

        List<CharacterDTO> listCharacters = new ArrayList<>(this.findListCharacterRepository.execute());

        Map<String, String> martianLanguaje= new HashMap<String, String>();
        martianLanguaje.put("a", "1");
        martianLanguaje.put("e", "2");
        martianLanguaje.put("i", "3");
        martianLanguaje.put("o", "4");
        martianLanguaje.put("u", "5");

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
