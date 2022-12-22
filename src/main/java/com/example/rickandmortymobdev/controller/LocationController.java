package com.example.rickandmortymobdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/location")
public class LocationController {
    //TODO inyection of service

    @GetMapping("/{location}")
    public String getSingleLocation(@PathVariable Optional<String> location) {
        String locationTemp = location.orElse("1");

        System.out.println("en el controlador");
        System.out.println(locationTemp);

        return "{\"id\":\"" + locationTemp + "\"}";
    }

}
