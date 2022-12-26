package com.example.rickandmortymobdev.configuration;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration

public class AppConfig {
    @Bean
    public RestTemplate registerRestTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }

    @Bean("HttpEntity")
    public HttpEntity<String> getRequestEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Header", "value");
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        return  requestEntity;
    }

}
