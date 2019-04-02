package com.codecool.datasaverservice.config;

import com.codecool.datasaverservice.model.Gift;
import com.codecool.datasaverservice.model.Person;
import com.codecool.datasaverservice.repository.GiftRepository;
import com.codecool.datasaverservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production")
public class InitDB {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private GiftRepository giftRepository;

   


    @Bean
    public CommandLineRunner init(){
        return args -> {
            Person mom = Person.builder().Name("Mom").build();
            personRepository.saveAndFlush(mom);
            
            Person dad = Person.builder().Name("Dad").build();
            personRepository.saveAndFlush(dad);
            
            Person peter = Person.builder().Name("Peter").build();
            personRepository.saveAndFlush(peter);
            
            Gift bicycle = Gift.builder().name("bicycle").person(peter).build();
            giftRepository.saveAndFlush(bicycle);
            
            Gift cookBook = Gift.builder().name("cookBook").person(mom).build();
            giftRepository.saveAndFlush(cookBook);
            
            Gift gimPass = Gift.builder().name("gim pass").person(peter).build();
            giftRepository.saveAndFlush(gimPass);


        };
    }

}
