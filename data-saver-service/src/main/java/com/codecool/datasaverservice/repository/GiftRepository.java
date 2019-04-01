package com.codecool.datasaverservice.repository;

import com.codecool.datasaverservice.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftRepository extends JpaRepository<Gift, Long > {
}
