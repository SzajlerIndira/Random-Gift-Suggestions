package com.codecool.datasaverservice.controller;

import com.codecool.datasaverservice.model.Gift;
import com.codecool.datasaverservice.model.Person;
import com.codecool.datasaverservice.model.PersonAndGift;
import com.codecool.datasaverservice.repository.GiftRepository;
import com.codecool.datasaverservice.repository.PersonRepository;
import com.codecool.datasaverservice.service.DataSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataSaverController {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private GiftRepository giftRepository;

    @Autowired
    private DataSaveService dataSaverService;

    @GetMapping("/all-person")
    private List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @PostMapping("/add-new-person")
    private void savePerson(@RequestBody PersonAndGift personAndGift) {
        dataSaverService.savePerson(personAndGift.getName(), personAndGift.getGiftName());
    }

    @GetMapping("/gifts")
    private List<Gift> getGiftsByPerson(@RequestBody String personName) {
        return dataSaverService.getGiftsByName(personName);
    }
}
