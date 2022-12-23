package com.example.rickandmortymobdev.domain;

import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import org.springframework.stereotype.Component;

@Component
public class Contract {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private Integer episode_count;

    private LocationDTO origin;

    public Contract() {
    }

    public Contract(CharacterDTO characterDTO) {
        this.id = characterDTO.getId();
        this.name = characterDTO.getName();
        this.status = characterDTO.getStatus();
        this.type = characterDTO.getType();
        this.episode_count = characterDTO.getEpisode().size();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getEpisode_count() {
        return episode_count;
    }

    public void setEpisode_count(Integer episode_count) {
        this.episode_count = episode_count;
    }

    public LocationDTO getOrigin() {
        return origin;
    }

    public void setOrigin(LocationDTO origin) {
        this.origin = origin;
    }
}
