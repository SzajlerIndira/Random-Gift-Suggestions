package com.codecool.datasaverservice.repository;

import com.codecool.datasaverservice.model.Gift;
import com.codecool.datasaverservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GiftRepository extends JpaRepository<Gift, Long > {

    List<Gift> getAllByPerson(Person person);

}
