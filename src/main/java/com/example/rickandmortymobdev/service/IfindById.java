package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.domain.Contract;
import org.springframework.stereotype.Component;

@Component
public interface IfindById {

    public Contract getContract(Integer id);

}