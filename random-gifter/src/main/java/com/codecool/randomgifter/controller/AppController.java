package com.codecool.randomgifter.controller;

import com.codecool.randomgifter.model.User;
import com.codecool.randomgifter.service.DataSaverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"user"})
public class AppController {

    @Autowired
    private DataSaverService dataSaverService;

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    @GetMapping(value = "/")
    public String welcomeView(@ModelAttribute User user) {
        return "index";
    }

    @PostMapping(value = "/addnewperson")
    public void addNewPerson(@RequestBody String person) {
        dataSaverService.createPerson(person);
    }





}
