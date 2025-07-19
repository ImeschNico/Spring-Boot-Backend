package com.m295.m295_backend.repository;

import com.m295.m295_backend.entity.Charakter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test") // nutzt application-test.properties
public class CharakterRepositoryTest {

    @Autowired
    private CharakterRepository charakterRepository;

    @BeforeEach
    void setup() {
        charakterRepository.deleteAll();

        Charakter c1 = new Charakter("Rick Sanchez", "Human", "Male", "Earth (C-137)", "alive");
        Charakter c2 = new Charakter("Morty Smith", "Human", "Male", "Earth (C-137)", "alive");
        Charakter c3 = new Charakter("Birdperson", "Bird-Person", "Male", "Bird World", "dead");
        Charakter c4 = new Charakter("Summer Smith", "Human", "Female", "Earth (Replacement)", "alive");

        charakterRepository.saveAll(List.of(c1, c2, c3, c4));
    }

    @Test
    void testFindBySpeciesIgnoreCase() {
        List<Charakter> results = charakterRepository.findBySpeciesIgnoreCase("human");
        assertThat(results).hasSize(3);
    }

    @Test
    void testFindByStatusIgnoreCase() {
        List<Charakter> results = charakterRepository.findByStatusIgnoreCase("alive");
        assertThat(results).hasSize(3);
    }

    @Test
    void testFindByGenderIgnoreCase() {
        List<Charakter> results = charakterRepository.findByGenderIgnoreCase("female");
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getName()).isEqualTo("Summer Smith");
    }

    @Test
    void testFindByOriginIgnoreCase() {
        List<Charakter> results = charakterRepository.findByOriginIgnoreCase("Earth (C-137)");
        assertThat(results).hasSize(2);
    }

    @Test
    void testCountBySpeciesIgnoreCase() {
        long count = charakterRepository.countBySpeciesIgnoreCase("human");
        assertThat(count).isEqualTo(3);
    }

    @Test
    void testCountByStatusIgnoreCase() {
        long count = charakterRepository.countByStatusIgnoreCase("dead");
        assertThat(count).isEqualTo(1);
    }

    @Test
    void testCountByGenderIgnoreCase() {
        long count = charakterRepository.countByGenderIgnoreCase("male");
        assertThat(count).isEqualTo(3);
    }

    @Test
    void testFindByNameContainingIgnoreCase() {
        List<Charakter> results = charakterRepository.findByNameContainingIgnoreCase("smith");
        assertThat(results).hasSize(2); // Summer Smith + Morty Smith
    }

    @Test
    void testFindDistinctSpecies() {
        List<String> species = charakterRepository.findDistinctSpecies();
        assertThat(species).containsExactlyInAnyOrder("Human", "Bird-Person");
    }

    @Test
    void testFindDistinctOrigin() {
        List<String> origins = charakterRepository.findDistinctOrigin();
        assertThat(origins).containsExactlyInAnyOrder("Earth (C-137)", "Bird World", "Earth (Replacement)");
    }
}
