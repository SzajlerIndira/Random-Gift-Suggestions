package com.codecool.datasaverservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String Name;


    @Enumerated
    @JsonIgnoreProperties({"person"})
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    private List<Gift> Gifts;



}
