package com.example.rickandmortymobdev.configuration;


import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration

public class AppConfig {
    @Bean
    public RestTemplate registerRestTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }
    @Bean
    public List<CharacterDTO> getCharacterDTOs(){
        LocationDTO mars = new LocationDTO();
        mars.setName("Mars");
        LocationDTO other = new LocationDTO();
        other.setName("Earth");

        CharacterDTO characterDTO1 = new CharacterDTO();
        characterDTO1.setId(1);
        characterDTO1.setName("javier");
        characterDTO1.setLocation(other);

        CharacterDTO characterDTO2 = new CharacterDTO();
        characterDTO1.setId(4);
        characterDTO1.setName("alien");
        characterDTO1.setLocation(mars);

        CharacterDTO characterDTO3 = new CharacterDTO();
        characterDTO1.setId(2);
        characterDTO1.setName("ET");
        characterDTO1.setLocation(mars);

        CharacterDTO characterDTO4 = new CharacterDTO();
        characterDTO1.setId(3);
        characterDTO1.setName("belen");
        characterDTO1.setLocation(other);

        CharacterDTO characterDTO5 = new CharacterDTO();
        characterDTO1.setId(5);
        characterDTO1.setName("predator");
        characterDTO1.setLocation(mars);

        return List.of(characterDTO1, characterDTO2, characterDTO3, characterDTO4, characterDTO5);
    }


}
