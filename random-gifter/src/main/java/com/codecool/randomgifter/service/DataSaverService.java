package com.codecool.randomgifter.service;

import com.codecool.randomgifter.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DataSaverService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${data-saver.url}")
    private String dataSaverUrl;

    public String createPerson(Person person) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<Person> request = new HttpEntity<>(person);
        System.out.println("Coming from DataSaverService");
        ResponseEntity<String> response = restTemplate.postForEntity(dataSaverUrl, request, String.class);
        System.out.println(response);
        return "SUCCESS";
    }


}
