package com.example.rickandmortymobdev.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LocationDTO {
    private String name;
    private String url;
    private String dimension;
    private List<String> residents;

    public LocationDTO() {
        this.name = "";
        this.setResidents(new ArrayList<>());
        this.setName("unknown");
        this.setUrl("");
        this.setDimension("");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getResidents() {
        return residents;
    }

    public void setResidents(List<String> residents) {
        this.residents = residents;
    }
}
