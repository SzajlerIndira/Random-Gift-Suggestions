package com.codecool.randomgifter.service;

import com.codecool.randomgifter.model.Person;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

@Service
public class DataSaverService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${data-saver.url}")
    private String dataSaverUrl;

    public String createPerson(Person person) {
        HttpEntity<Person> request = new HttpEntity<>(person);
        System.out.println("Coming from DataSaverService");
        ResponseEntity<Json> response = restTemplate.postForEntity(dataSaverUrl, request, Json.class);
        System.out.println(response);
        return "SUCCESS";
    }
}

