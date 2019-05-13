package com.codecool.datasaverservice.repository;

import com.codecool.datasaverservice.model.Gift;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DataJpaTest
@Profile("test")
public class GiftRepositoryTest {

    @Autowired
    private GiftRepository giftRepo;

    @Test
    public void saveOneSimple() {
        Gift gift = Gift.builder()
                .name("banana")
                .build();

        giftRepo.saveAndFlush(gift);
        assertThat(giftRepo.findAll().size()).isEqualTo(1);

    }


}