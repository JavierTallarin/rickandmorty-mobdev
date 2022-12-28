package com.example.rickandmortymobdev.domain;

import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterResponse {
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


    public CharacterResponse(CharacterDTO characterDTO, LocationDTO locationDTO) {
        this.id = characterDTO.getId();
        this.name = characterDTO.getName();
        this.status = characterDTO.getStatus();
        this.species = characterDTO.getSpecies();
        this.type = characterDTO.getType();
        this.episodeCount = characterDTO.getEpisode().size();
        this.origin = locationDTO;
    }

}
