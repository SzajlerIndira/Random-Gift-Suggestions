package com.codecool.datasaverservice.repository;

import com.codecool.datasaverservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT * FROM person WHERE person.name= :name", nativeQuery = true)
    public Person getByName(@Param("name") String name);

}
