package com.m295.m295_backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m295.m295_backend.dto.CharakterDTO;
import com.m295.m295_backend.service.CharakterService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CharakterController.class)
public class CharakterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CharakterService charakterService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenGetAllCharakters_thenReturnsJsonArray() throws Exception {
        CharakterDTO charakter1 = new CharakterDTO(1L, "Rick Sanchez", "Human", "Male", "Earth", "Alive");
        CharakterDTO charakter2 = new CharakterDTO(2L, "Morty Smith", "Human", "Male", "Earth", "Alive");

        List<CharakterDTO> charakterList = List.of(charakter1, charakter2);

        Mockito.when(charakterService.getAllCharaktersAsDTO()).thenReturn(charakterList);

        mockMvc.perform(get("/api/characters/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Rick Sanchez"))
                .andExpect(jsonPath("$[1].name").value("Morty Smith"));
    }
}
