package com.example.rickandmortymobdev.service;

import java.util.HashMap;
import java.util.Map;

public class MartianLanguajeDictionary {
    public Map<String, String> execute(){
        Map<String, String> martianLanguaje= new HashMap<>();
        martianLanguaje.put("a", "1");
        martianLanguaje.put("e", "2");
        martianLanguaje.put("i", "3");
        martianLanguaje.put("o", "4");
        martianLanguaje.put("u", "5");
        return martianLanguaje;
    }
}
