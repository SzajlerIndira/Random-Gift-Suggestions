package com.codecool.datasaverservice.service;

import com.codecool.datasaverservice.model.Gift;
import com.codecool.datasaverservice.model.Person;
import com.codecool.datasaverservice.repository.GiftRepository;
import com.codecool.datasaverservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DataSaveService {

    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private GiftRepository giftRepo;

    public String savePerson(String personName, String giftName) {
        Person person;
        if (personRepo.getByName(personName) == null) {
            person = Person.builder()
                    .Name(personName)
                    .build();
            personRepo.saveAndFlush(person);
        } else {
            person = personRepo.getByName(personName);
        }

        Gift gift = Gift.builder()
                .person(person)
                .name(giftName)
                .build();
        giftRepo.saveAndFlush(gift);
        return person.getName() + " saved to db with " + gift.getName();
    }

    public List<Gift> getGiftsByName(String personName) {
        return giftRepo.getAllByPerson(personRepo.getByName(personName));
    }
}
