package com.codecool.randomgifter.controller;

import com.codecool.randomgifter.model.Person;
import com.codecool.randomgifter.service.DataSaverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppRestController {
    @Autowired
    DataSaverService dataSaverService;

    @GetMapping("/gifts")
    public String getGiftsByPerson(@RequestBody Person person, Model model) {
        List<String> giftListFromDataSaverService = dataSaverService.getGiftListFromDataSaverService(person.getName());
        String response = "test";

        return response;
    }

}