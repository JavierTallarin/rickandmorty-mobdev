package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.entity.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LocationService {
    @Value("${external.rickandmorty.api.location.urlBase}")
    private String URL_BASE;
    @Autowired
    private RestTemplate restTemplate;

    public LocationDTO findByid(Integer idTemp) {

        LocationDTO locationDTO = restTemplate.getForObject(this.URL_BASE.concat(idTemp.toString()), LocationDTO.class);

        return locationDTO;
    }
}
