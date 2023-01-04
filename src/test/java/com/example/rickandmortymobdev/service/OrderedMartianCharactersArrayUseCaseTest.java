package com.example.rickandmortymobdev.service;

import com.example.rickandmortymobdev.model.CharacterDTO;
import com.example.rickandmortymobdev.model.LocationDTO;
import com.example.rickandmortymobdev.repository.FindListCharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class OrderedMartianCharactersArrayUseCaseTest {

    @Mock
    private FindListCharacterRepository findListCharacterRepository;

    @Mock
    private MartianLanguajeDictionary martianLanguajeDictionary;

    private OrderedMartianCharactersArrayUseCase orderedMartianCharactersArrayUseCase;
    @BeforeEach
    void setUp() {
        this.orderedMartianCharactersArrayUseCase = new OrderedMartianCharactersArrayUseCase(this.findListCharacterRepository, this.martianLanguajeDictionary);

    }
    @Test
    void should_return_correct_dictionary_language_martian()  {
        Map<String, String> martianLanguageExpected = new HashMap<String, String>();
        martianLanguageExpected.put("a", "1");
        martianLanguageExpected.put("e", "2");
        martianLanguageExpected.put("i", "3");
        martianLanguageExpected.put("o", "4");
        martianLanguageExpected.put("u", "5");

        // Given

        // When
        when(this.martianLanguajeDictionary.execute()).thenReturn(new MartianLanguajeDictionary().execute());
        Map<String, String> martianLanguageActual = this.martianLanguajeDictionary.execute();


        // Then
        assertEquals(martianLanguageExpected, martianLanguageActual);
        verify(this.martianLanguajeDictionary, times(1)).execute();

    }

    @Test
    void should_return_list_characters_with_size_between_1(){
        Integer sizeMinExpected = 1;
        // Given

        // When
        when(this.findListCharacterRepository.execute()).thenReturn(new FindListCharacterRepository().execute());
        List<CharacterDTO> characterDTOListActual = this.findListCharacterRepository.execute();

        // Then

        assertTrue(characterDTOListActual.size() >= sizeMinExpected);



    }


    @Test
    void should_return_ordered_without_martian_language(){
        // Given

        // When
        // Then


    }

    @Test
    void should_return_ordered_by_name_in_martian_languaje_name() {

        List<CharacterDTO> listExpected = null;
        LocationDTO mars = new LocationDTO();
        mars.setName("Mars");
        LocationDTO other = new LocationDTO();
        other.setName("Earth");

        CharacterDTO characterDTO1 = new CharacterDTO();
        characterDTO1.setId(1);
        characterDTO1.setName("javier");
        characterDTO1.setLocation(other);

        CharacterDTO characterDTO2 = new CharacterDTO();
        characterDTO2.setId(4);
        characterDTO2.setName("1l32n");
        characterDTO2.setLocation(mars);

        CharacterDTO characterDTO3 = new CharacterDTO();
        characterDTO3.setId(2);
        characterDTO3.setName("2T");
        characterDTO3.setLocation(mars);

        CharacterDTO characterDTO4 = new CharacterDTO();
        characterDTO4.setId(3);
        characterDTO4.setName("belen");
        characterDTO4.setLocation(other);

        CharacterDTO characterDTO5 = new CharacterDTO();
        characterDTO5.setId(5);
        characterDTO5.setName("pr2d1t4r");
        characterDTO5.setLocation(mars);

        listExpected = List.of(characterDTO2, characterDTO3, characterDTO4, characterDTO1, characterDTO5);

        // GIVEN
        CharacterDTO characterDTO6 = new CharacterDTO();
        characterDTO6.setId(1);
        characterDTO6.setName("javier");
        characterDTO6.setLocation(other);

        CharacterDTO characterDTO7 = new CharacterDTO();
        characterDTO7.setId(4);
        characterDTO7.setName("alien");
        characterDTO7.setLocation(mars);

        CharacterDTO characterDTO8 = new CharacterDTO();
        characterDTO8.setId(2);
        characterDTO8.setName("ET");
        characterDTO8.setLocation(mars);

        CharacterDTO characterDTO9 = new CharacterDTO();
        characterDTO9.setId(3);
        characterDTO9.setName("belen");
        characterDTO9.setLocation(other);

        CharacterDTO characterDT10 = new CharacterDTO();
        characterDT10.setId(5);
        characterDT10.setName("predator");
        characterDT10.setLocation(mars);

        List<CharacterDTO> list =  List.of(characterDTO6, characterDTO7, characterDTO8, characterDTO9, characterDT10);


        // When
        when(this.findListCharacterRepository.execute()).thenReturn(list);
        when(this.martianLanguajeDictionary.execute()).thenReturn(new MartianLanguajeDictionary().execute());
        List<CharacterDTO> listActual = this.orderedMartianCharactersArrayUseCase.execute();

        assertEquals(listExpected, listActual);

    }


}