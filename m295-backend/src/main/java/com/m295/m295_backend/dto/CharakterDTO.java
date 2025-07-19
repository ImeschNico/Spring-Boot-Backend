package com.m295.m295_backend.dto;

/**
 * Data Transfer Object (DTO) für die {@code Charakter}-Entität.
 *
 * <p>Dieses DTO dient zur Übertragung von Charakterdaten zwischen Client und Server,
 * insbesondere für die Darstellung in REST-APIs.</p>
 *
 * <p><strong>Beispiel:</strong></p>
 * <pre>{@code
 * CharakterDTO charakter = new CharakterDTO();
 * charakter.setName("Rick Sanchez");
 * charakter.setSpecies("Human");
 * charakter.setStatus("Alive");
 * }</pre>
 *
 * @see com.m295.m295_backend.entity.Charakter Die zugehörige Entity-Klasse
 * @see com.m295.m295_backend.mapper.CharakterMapper Für die Konvertierung zwischen Entity und DTO
 */
public class CharakterDTO {
    /**
     * Die eindeutige ID des Charakters.
     */
    private final Long id;

    /**
     * Der vollständige Name des Charakters.
     */
    private final String name;

    /**
     * Der aktuelle Status des Charakters (z. B. "Alive", "Dead", "Unknown").
     */
    private final String status;

    /**
     * Die Spezies des Charakters (z. B. "Human", "Alien").
     */
    private final String species;

    /**
     * Das Geschlecht des Charakters (z. B. "Male", "Female", "Unknown").
     */
    private final String gender;

    /**
     * Der Herkunftsort des Charakters (z. B. "Earth", "Mars").
     */
    private final String origin;


    /**
     * Konstruktor zur Initialisierung aller Felder.
     *
     * @param id      Die ID des Charakters
     * @param name    Der Name des Charakters
     * @param status  Der Status (z. B. "Alive", "Dead")
     * @param species Die Spezies (z. B. "Human")
     * @param gender  Das Geschlecht (z. B. "Male")
     * @param origin  Der Herkunftsort
     */
    public CharakterDTO(Long id, String name, String status, String species, String gender, String origin) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.gender = gender;
        this.origin = origin;

    }

    /**
     * Gibt die ID des Charakters zurück.
     *
     * @return Die ID
     */
    public Long getId() {
        return id;
    }



    /**
     * Gibt den Namen des Charakters zurück.
     *
     * @return Der Name
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt den Status des Charakters zurück.
     *
     * @return Der Status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gibt die Spezies des Charakters zurück.
     *
     * @return Die Spezies
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Gibt das Geschlecht des Charakters zurück.
     *
     * @return Das Geschlecht
     */
    public String getGender() {
        return gender;
    }

    /**
     * Gibt den Herkunftsort des Charakters zurück.
     *
     * @return Der Herkunftsort
     */
    public String getOrigin() {
        return origin;
    }

}