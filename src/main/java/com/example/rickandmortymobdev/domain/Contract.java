package com.example.rickandmortymobdev.domain;

import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.stereotype.Component;


@Component
public class Contract{
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String status;
    @JsonProperty("species")
    private String species;

    @JsonProperty("type")
    private String type;

    @JsonProperty("episode_count")
    private Integer episodeCount;

    @JsonProperty("origin")
    private LocationDTO origin;

    public Contract() {
    }

    public Contract(CharacterDTO characterDTO, LocationDTO locationDTO) {
        this.id = characterDTO.getId();
        this.name = characterDTO.getName();
        this.status = characterDTO.getStatus();
        this.species = characterDTO.getSpecies();
        this.type = characterDTO.getType();
        this.episodeCount = characterDTO.getEpisode().size();
        this.origin = locationDTO;
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

    public Integer getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(Integer episodeCount) {
        this.episodeCount = episodeCount;
    }

    public LocationDTO getOrigin() {
        return origin;
    }

    public void setOrigin(LocationDTO origin) {
        this.origin = origin;
    }
}
