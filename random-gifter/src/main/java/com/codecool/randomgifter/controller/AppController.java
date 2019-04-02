package com.codecool.randomgifter.controller;

import com.codecool.randomgifter.model.Person;
import com.codecool.randomgifter.model.User;
import com.codecool.randomgifter.service.DataSaverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @ModelAttribute("person")
    public Person getPerson() {
        return new Person();
    }

    @GetMapping(value = "/")
    public String welcomeView(Model model) {
        model.addAttribute("person", getPerson());
        return "index";
    }

    @PostMapping(value = "/addnewperson")
    public void addNewPerson(@ModelAttribute Person person) {
        System.out.println("From appController " + person);
        dataSaverService.createPerson(person);
    }





}
