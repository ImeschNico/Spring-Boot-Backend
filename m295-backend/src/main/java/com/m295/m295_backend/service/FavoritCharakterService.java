package com.m295.m295_backend.service;

import com.m295.m295_backend.dto.FavoritDTO;
import com.m295.m295_backend.entity.Favorit;
import com.m295.m295_backend.repository.FavoritCharakterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service-Klasse für die Geschäftslogik der Favoriten.
 */
@Service
public class FavoritCharakterService {

    private final FavoritCharakterRepository favoritRepository;

    /**
     * Konstruktor mit Repository-Injektion.
     *
     * @param favoritRepository das Repository für Favoriten
     */
    public FavoritCharakterService(FavoritCharakterRepository favoritRepository) {
        this.favoritRepository = favoritRepository;
    }

    /**
     * Gibt alle gespeicherten Favoriten als DTO-Liste zurück.
     *
     * @return Liste von FavoritDTOs
     */
    public List<FavoritDTO> getAllFavoriten() {
        return favoritRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Speichert einen neuen Favoriten in der Datenbank.
     *
     * @param dto FavoritDTO mit den Daten
     * @return das gespeicherte FavoritDTO
     */
    public FavoritDTO saveFavorit(FavoritDTO dto) {
        // Wenn dto.getId() gesetzt ist → WEG DAMIT
        dto.setId(null); // <-- Das ist entscheidend!

        Favorit favorit = convertToEntity(dto);
        Favorit saved = favoritRepository.save(favorit);
        return convertToDTO(saved);
    }

    /**
     * Löscht einen Favoriten anhand seiner ID.
     *
     * @param id ID des Favoriten
     */
    public void deleteFavorit(Long id) {
        favoritRepository.deleteById(id);
    }

    /**
     * Wandelt eine Favorit-Entity in ein FavoritDTO um.
     *
     * @param favorit das Favorit-Entity
     * @return entsprechendes FavoritDTO
     */
    private FavoritDTO convertToDTO(Favorit favorit) {
        FavoritDTO dto = new FavoritDTO(
                favorit.getCharakterId(),
                favorit.getName(),
                favorit.getStatus(),
                favorit.getImage(),
                favorit.getSpecies(),
                favorit.getGender(),
                favorit.getOrigin()
        );
        dto.setId(favorit.getId());  // <-- Wichtig, sonst fehlt die ID im DTO!
        return dto;
    }

    private Favorit convertToEntity(FavoritDTO dto) {
        Favorit favorit = new Favorit();
        favorit.setId(dto.getId());  // ok, kann null sein bei neuen Einträgen

        // WICHTIG: Hier muss charakterId gesetzt werden!
        favorit.setCharakterId(dto.getCharakterId()); // Wenn dto.getCharakterId() null ist, dann gibt es den Fehler

        favorit.setName(dto.getName());
        favorit.setStatus(dto.getStatus());
        favorit.setImage(dto.getImage());
        favorit.setSpecies(dto.getSpecies());
        favorit.setGender(dto.getGender());
        favorit.setOrigin(dto.getOrigin());
        return favorit;
    }
}