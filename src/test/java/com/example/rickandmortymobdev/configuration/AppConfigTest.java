package com.example.rickandmortymobdev.configuration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppConfigTest {
    @Mock
    private RestTemplateBuilder restTemplateBuilder;

    private AppConfig appConfig;

    @BeforeEach
    void setUp() {
        this.appConfig = new AppConfig();
    }


    @Test
    void should_be_RestTemplate_instance() throws Exception {
        when(restTemplateBuilder.build()).thenReturn(new RestTemplate());

        // Llamamos al metodo del bean que queremos probar
        RestTemplate restTemplate = this.appConfig.registerRestTemplate(this.restTemplateBuilder);

        // Verifica el resultado obtenido
        assertThat(restTemplate).isInstanceOf(RestTemplate.class);

    }

    @Test
    void should_be_not_null_restTemplate_instance(){
        when(this.restTemplateBuilder.build()).thenReturn(new RestTemplate());

        RestTemplate restTemplate = this.appConfig.registerRestTemplate(this.restTemplateBuilder);


        Assert.notNull(restTemplate, "restTemplate instance is null");

    }
}