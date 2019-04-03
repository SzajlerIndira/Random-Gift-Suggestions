package com.codecool.randomgifter.service;

import com.codecool.randomgifter.model.Gift;
import com.codecool.randomgifter.model.Person;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataSaverService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${data-saver.url}/add-new-person")
    private String dataSaverUrl;

    @Value("${data-saver.url}/all-person")
    private String retrieveDataUrl;

    @Value("${data-saver.url}/gifts")
    private String getGiftsUrl;

    public String createPerson(Person person) {
        HttpEntity<Person> request = new HttpEntity<>(person);
        System.out.println("Coming from DataSaverService");
        ResponseEntity<Json> response = restTemplate.postForEntity(dataSaverUrl, request, Json.class);
        System.out.println(response);
        return "SUCCESS";
    }

    public List<String> getPersonNamesFromDataSaverService() {
        ResponseEntity<List<Person>> response = restTemplate.exchange(
                retrieveDataUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Person>>() {});
        List<Person> persons = response.getBody();
        List<String> names = new ArrayList<>();
        for (Person person: persons) {
            names.add(person.getName());
        }
        return names;
    }

        public List<String> getGiftListFromDataSaverService(String personName) {
        HttpEntity<String> request = new HttpEntity<>(personName);
        ResponseEntity<Json> jsonResponse = restTemplate.postForEntity(getGiftsUrl, request, Json.class);


        ResponseEntity<List<Gift>> giftResponse = restTemplate.exchange(
                getGiftsUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Gift>>() {});
        List<Gift> gifts = giftResponse.getBody();
        List<String> giftNames = new ArrayList<>();
        for (Gift gift: gifts) {
            giftNames.add(gift.getName());
        }
        return giftNames;
    }

//    public List<String> getGiftListFromDataSaverService() {
//        ResponseEntity<List<Gift>> response = restTemplate.exchange(
//                retrieveDataUrl,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Gift>>() {});
//        List<Gift> gifts = response.getBody();
//        List<String> giftNames = new ArrayList<>();
//        for (Gift gift: gifts) {
//            giftNames.add(gift.getName());
//        }
//        return giftNames;
//    }
}

