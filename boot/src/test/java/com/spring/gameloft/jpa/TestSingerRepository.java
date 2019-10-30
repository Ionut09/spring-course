package com.spring.gameloft.jpa;


import com.spring.gameloft.domain.Singer;
import com.spring.gameloft.repository.SingerRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DirtiesContext
public class TestSingerRepository {

    @Autowired
    private SingerRepository singerRepository;

    @Test
    public void testGetByLastName() {
        Singer singer = new Singer();
        singer.setFirstName("Laurentiu");
        singer.setLastName("Duta");
        singer.setBirthDate(LocalDate.of(1985, 11, 25));
        singerRepository.save(singer);

        List<Singer> singers = singerRepository.findAllByLastName("Duta");
        assertThat(singers.size()).isEqualTo(1);

        Singer retrievedSinger = singers.get(0);
        assertThat(retrievedSinger.getLastName()).isEqualTo(singer.getLastName());
        assertThat(retrievedSinger.getFirstName()).isEqualTo(singer.getFirstName());
        assertThat(retrievedSinger.getBirthDate()).isEqualTo(singer.getBirthDate());
        assertThat(retrievedSinger.getId()).isNotNull();
    }

    @Test
    public void testGetByFirstName() {
        Singer singer = new Singer();
        singer.setFirstName("Laurentiu");
        singer.setLastName("Duta");
        singer.setBirthDate(LocalDate.of(1985, 11, 25));
        singerRepository.save(singer);

        List<Singer> singers = singerRepository.findAllByFirstName("Laurentiu")
                                               .collect(Collectors.toList());

        assertThat(singers.size()).isEqualTo(1);

        Singer retrievedSinger = singers.get(0);
        assertThat(retrievedSinger.getLastName()).isEqualTo(singer.getLastName());
        assertThat(retrievedSinger.getFirstName()).isEqualTo(singer.getFirstName());
        assertThat(retrievedSinger.getBirthDate()).isEqualTo(singer.getBirthDate());
        assertThat(retrievedSinger.getId()).isNotNull();
    }

}
