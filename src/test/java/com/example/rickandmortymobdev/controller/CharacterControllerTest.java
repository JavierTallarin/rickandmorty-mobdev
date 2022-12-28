package com.example.rickandmortymobdev.controller;

import com.example.rickandmortymobdev.controller.CharacterController;
import com.example.rickandmortymobdev.domain.CharacterResponse;
import com.example.rickandmortymobdev.service.IFindCharacterResponseById;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ExtendWith(MockitoExtension.class)
public class CharacterControllerTest {
    private  CharacterController characterController;
    private MockMvc mockMvc;

    @Mock
    private IFindCharacterResponseById iFindCharacterResponseById;

    @BeforeEach
    void setup(){
        this.characterController = new CharacterController(this.iFindCharacterResponseById);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.characterController).build();

    }

    @Test
    void should_empty_object_CharacterResponse() throws Exception {

        when(iFindCharacterResponseById.getCharacterResponse("1")).thenReturn(new CharacterResponse());

        CharacterResponse characterResponse = iFindCharacterResponseById.getCharacterResponse("1");

        // Asert
        Assert.notNull(characterResponse, "characterResponse is null");

    }


    @Test
    void should_returrn_200_status_get_contract() throws Exception{
        when(this.iFindCharacterResponseById.getCharacterResponse("1")).thenReturn(new CharacterResponse());

        mockMvc.perform(get("/api/v1/1"))
                .andExpect(status().isOk());

    }

    @Test
    void should_returrn_200_status_get_contract2() throws Exception{
        final int statusExpected = 200;

        //given
        CharacterResponse characterResponse = new CharacterResponse();
        characterResponse.setId(1);

        when(this.iFindCharacterResponseById.getCharacterResponse("1")).thenReturn(characterResponse);

        //when

        ResponseEntity<CharacterResponse> responseEntity = this.characterController.getContract(Optional.of("1"));

        //then
        assertEquals(statusExpected, responseEntity.getStatusCodeValue());


    }



}
