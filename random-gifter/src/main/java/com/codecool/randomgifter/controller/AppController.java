package com.codecool.randomgifter.controller;

import com.codecool.randomgifter.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"user"})
public class AppController {

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    @GetMapping(value = "/")
    public String welcomeView(@ModelAttribute User user) {
        return "index";
    }





}
