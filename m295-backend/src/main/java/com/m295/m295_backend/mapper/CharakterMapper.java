package com.m295.m295_backend.mapper;

import com.m295.m295_backend.dto.CharakterDTO;
import com.m295.m295_backend.dto.CharakterFormDTO;
import com.m295.m295_backend.entity.Charakter;

import java.util.List;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Mapper-Klasse zur Umwandlung zwischen Charakter-Entity und verschiedenen DTOs.
 * <p>
 * Bietet statische Methoden zur Konvertierung von Entity zu DTO, DTO zu Entity
 * sowie zur Umwandlung von Collections.
 * </p>
 */
public class CharakterMapper {
    /**
     * Konvertiert eine Charakter-Entity in ein CharakterDTO.
     *
     * @param entity Die zu konvertierende Entity
     * @return Das entsprechende DTO oder null, wenn die Entity null ist
     */
    public static CharakterDTO toDTO(Charakter entity) {
        if (entity == null) {
            return null;
        }

        return new CharakterDTO(
        entity.getId(),
        entity.getName(),
        entity.getStatus(),
        entity.getGender(),
        entity.getOrigin(),
        entity.getSpecies()
);
    }

    /**
     * Standard-Konstruktor für die Mapper-Klasse.
     */
    public CharakterMapper() {
        // Leer, da nur statische Methoden vorhanden sind
    }

    /**
     * Konvertiert ein CharakterDTO in eine Charakter-Entity.
     *
     * @param dto Das zu konvertierende DTO
     * @return Die entsprechende Entity oder null, wenn das DTO null ist
     */
    public static Charakter toEntity(CharakterDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Charakter(
                dto.getId(),
                dto.getName(),
                dto.getStatus(),
                dto.getGender(),
                dto.getOrigin(),
                dto.getSpecies()


        );
    }

    /**
     * Konvertiert eine Collection von Charakter-Entities in eine Liste von CharakterDTOs.
     *
     * @param entities Die Collection der Entities
     * @return Eine Liste der konvertierten DTOs
     */
    public static List<CharakterDTO> toDTOList(Collection<Charakter> entities) {
        return entities.stream().map(CharakterMapper::toDTO).collect(Collectors.toList());
    }


    /**
     * Konvertiert eine Charakter-Entity in ein CharakterFormDTO.
     *
     * @param entity Die zu konvertierende Entity
     * @return Das entsprechende FormDTO oder null, wenn die Entity null ist
     */
    public static CharakterFormDTO toFormDTO(Charakter entity) {
        if (entity == null) {
            return null;
        }
        return CharakterFormDTO.fromEntity(entity);
    }

    /**
     * Konvertiert eine Collection von Charakter-Entities in eine Liste von CharakterFormDTOs.
     *
     * @param entities Die Collection der Entities
     * @return Eine Liste der konvertierten FormDTOs
     */
    public static List<CharakterFormDTO> toFormDTOList(Collection<Charakter> entities) {
        return entities.stream().map(CharakterMapper::toFormDTO).collect(Collectors.toList());
    }

    /**
     * Konvertiert ein CharakterFormDTO in eine Charakter-Entity.
     *
     * @param dto Das zu konvertierende FormDTO
     * @return Die entsprechende Entity oder null, wenn das DTO null ist
     */
    public static Charakter fromFormDTO(CharakterFormDTO dto) {
        if (dto == null) {
            return null;
        }
        Charakter charakter = new Charakter();
        charakter.setId(dto.getId());
        charakter.setName(dto.getName());
        charakter.setStatus(dto.getStatus());
        charakter.setGender(dto.getGender());
        charakter.setOrigin(dto.getOrigin());
        charakter.setSpecies(dto.getSpecies());

        return charakter;
    }
}