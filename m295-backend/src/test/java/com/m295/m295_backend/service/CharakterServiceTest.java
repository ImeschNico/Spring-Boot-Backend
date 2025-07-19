package com.m295.m295_backend.service;

import com.m295.m295_backend.entity.Charakter;
import com.m295.m295_backend.repository.CharakterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CharakterServiceTest {

    @Mock
    private CharakterRepository charakterRepository;

    @InjectMocks
    private CharakterService charakterService;

    @Test
    public void testGetAllCharakters() {
        // Arrange – vorbereiten
        Charakter c1 = new Charakter("Rick Sanchez", "Human", "Male", "Earth", "Alive");
        Charakter c2 = new Charakter("Morty Smith", "Human", "Male", "Earth", "Alive");

        when(charakterRepository.findAll()).thenReturn(Arrays.asList(c1, c2));

        // Act – ausführen
        List<Charakter> result = charakterService.getAllCharakters();

        // Assert – prüfen
        assertThat(result).hasSize(2);
        verify(charakterRepository, times(1)).findAll();
    }

    @Test
    public void testGetCharakterById_Found() {
        Charakter rick = new Charakter(1L, "Rick Sanchez", "Human", "Male", "Earth", "Alive");

        when(charakterRepository.findById(1L)).thenReturn(java.util.Optional.of(rick));

        Charakter result = charakterService.getCharakterById(1L);

        assertThat(result.getName()).isEqualTo("Rick Sanchez");
    }

}
