package com.m295.m295_backend.controller;

import com.m295.m295_backend.dto.FavoritDTO;
import com.m295.m295_backend.service.FavoritCharakterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-Controller für Favoriten-Endpunkte.
 */
@RestController
@RequestMapping("/api/characters/favoriten")
@CrossOrigin(origins = "*") // Erlaubt Zugriff vom Frontend
public class FavoritCharakterController {

    private final FavoritCharakterService favoritService;

    /**
     * Konstruktor mit Service-Injektion.
     *
     * @param favoritService Service für Favoriten
     */
    public FavoritCharakterController(FavoritCharakterService favoritService) {
        this.favoritService = favoritService;
    }

    /**
     * Gibt alle gespeicherten Favoriten zurück.
     *
     * @return Liste von FavoritDTOs
     */
    @GetMapping
    public List<FavoritDTO> getAllFavoriten() {
        return favoritService.getAllFavoriten();
    }

    /**
     * Speichert einen neuen Favoriten.
     *
     * @param dto FavoritDTO mit den Daten
     * @return das gespeicherte FavoritDTO
     */
    @PostMapping
    public FavoritDTO addFavorit(@RequestBody FavoritDTO dto) {
        return favoritService.saveFavorit(dto);
    }

    /**
     * Löscht einen Favoriten anhand seiner ID.
     *
     * @param id ID des Favoriten
     */
    @DeleteMapping("/{id}")
    public void deleteFavorit(@PathVariable Long id) {
        favoritService.deleteFavorit(id);
    }
}