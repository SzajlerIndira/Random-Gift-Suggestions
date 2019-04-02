package com.codecool.datasaverservice.repository;

import com.codecool.datasaverservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long > {
}
