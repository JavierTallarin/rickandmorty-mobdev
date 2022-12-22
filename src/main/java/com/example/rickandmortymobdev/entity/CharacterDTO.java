package com.example.rickandmortymobdev.entity;

import lombok.Data;
import org.springframework.stereotype.Component;


import java.util.List;

@Data
public class CharacterDTO {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;

    // length of list of episodes
    private Integer episode_count;
    private Location origin;


    private List<String> listOfEpisodes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
