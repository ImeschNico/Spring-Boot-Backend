package com.m295.m295_backend.repository;

import com.m295.m295_backend.entity.Charakter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository-Schnittstelle für die Verwaltung von {@link Charakter}-Entitäten.
 * <p>
 * Bietet CRUD-Operationen sowie spezielle Such- und Zählmethoden basierend auf
 * Charaktereigenschaften wie Species, Status, Gender und Origin.
 * </p>
 */
@Repository
public interface CharakterRepository extends JpaRepository<Charakter, Long> {
    /**
     * Findet alle Charaktere einer bestimmten Spezies (case-insensitive).
     *
     * @param species Die gesuchte Spezies
     * @return Liste der passenden Charaktere
     */
    List<Charakter> findBySpeciesIgnoreCase(String species);

    /**
     * Findet alle Charaktere mit einem bestimmten Status (case-insensitive).
     *
     * @param status Der gesuchte Status
     * @return Liste der passenden Charaktere
     */
    List<Charakter> findByStatusIgnoreCase(String status);

    /**
     * Findet alle Charaktere eines bestimmten Geschlechts (case-insensitive).
     *
     * @param gender Das gesuchte Geschlecht
     * @return Liste der passenden Charaktere
     */
    List<Charakter> findByGenderIgnoreCase(String gender);

    /**
     * Findet alle Charaktere mit einem bestimmten Ursprung (case-insensitive).
     *
     * @param origin Der gesuchte Ursprung
     * @return Liste der passenden Charaktere
     */
    List<Charakter> findByOriginIgnoreCase(String origin);

    /**
     * Zählt die Anzahl der Charaktere einer bestimmten Spezies (case-insensitive).
     *
     * @param species Die Spezies
     * @return Anzahl der Charaktere
     */
    long countBySpeciesIgnoreCase(String species);

    /**
     * Zählt die Anzahl der Charaktere mit einem bestimmten Status (case-insensitive).
     *
     * @param status Der Status
     * @return Anzahl der Charaktere
     */
    long countByStatusIgnoreCase(String status);

    /**
     * Zählt die Anzahl der Charaktere eines bestimmten Geschlechts (case-insensitive).
     *
     * @param gender Das Geschlecht
     * @return Anzahl der Charaktere
     */
    long countByGenderIgnoreCase(String gender);

    /**
     * Findet alle Charaktere, deren Name einen bestimmten Suchbegriff enthält (case-insensitive).
     *
     * @param keyword Der Suchbegriff
     * @return Liste der passenden Charaktere
     */
    List<Charakter> findByNameContainingIgnoreCase(String keyword);

    //JPQL-Query (Java Persistence Query Language). Damit schreibst du eine eigene
    // Datenbankabfragen direkt im Repository.
    /**
     * Findet alle unterschiedlichen (distinct) Spezies aus der Charakter-Tabelle.
     * <p>
     * Nützlich für Filter, Dropdowns oder Übersichten.
     * </p>
     *
     * @return Liste der eindeutigen Spezies
     */
    @Query("SELECT DISTINCT c.species FROM Charakter c")
    List<String> findDistinctSpecies();


    /**
     * Findet alle unterschiedlichen (distinct) Ursprünge aus der Charakter-Tabelle.
     * <p>
     * Nützlich für Filter, Dropdowns oder Übersichten.
     * </p>
     *
     * @return Liste der eindeutigen Ursprünge
     */
    @Query("SELECT DISTINCT c.origin FROM Charakter c")
    List<String> findDistinctOrigin();

}