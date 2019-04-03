package com.codecool.randomgifter.controller;

import com.codecool.randomgifter.model.Person;
import com.codecool.randomgifter.model.User;
import com.codecool.randomgifter.service.DataSaverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"user"})
public class AppController {

    @Autowired
    private DataSaverService dataSaverService;

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    @ModelAttribute("person")
    public Person getPerson() {
        return new Person();
    }

    @GetMapping(value = "/")
    public String welcomeView(Model model) {
        model.addAttribute("person", getPerson());
        model.addAttribute("personlist", dataSaverService.getPersonNamesFromDataSaverService());
        return "index";
    }

    @PostMapping(value = "/add-new-person")
    public String addNewPerson(@ModelAttribute Person person, Model model) {
        System.out.println("From appController " + person);
        dataSaverService.createPerson(person);
        return "redirect:/";
    }
}
