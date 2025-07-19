package com.m295.m295_backend.dto;

import com.m295.m295_backend.entity.Charakter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Data Transfer Object (DTO) für die Charakter-Formular-Daten.
 *
 * <p>Dieses DTO wird verwendet, um Charakterdaten von Formularen sicher und validiert
 * zwischen Client und Server zu übertragen.</p>
 *
 * <p>Validierungen:</p>
 * <ul>
 *   <li>name: darf nicht leer sein, Länge zwischen 2 und 100 Zeichen</li>
 *   <li>species, gender, origin, status: dürfen nicht leer sein</li>
 *   <li>origin: maximal 100 Zeichen</li>
 *   <li>status: maximal 50 Zeichen</li>
 * </ul>
 *
 * <p><strong>Beispiel:</strong></p>
 * <pre>{@code
 * CharakterFormDTO formDTO = new CharakterFormDTO(
 *     null,
 *     "Rick Sanchez",
 *     "Männlich",
 *     "Mensch",
 *     "Erde",
 *     "Alive"
 * );
 * }</pre>
 *
 * @see com.m295.m295_backend.entity.Charakter Entity-Klasse, von der Daten konvertiert werden können
 */
public class CharakterFormDTO {
    private final Long id;

    @NotBlank
    @Size(min = 2, max = 100)
    private final String name;

    @NotBlank
    private final String species;

    @NotBlank
    private final String gender;

    @NotBlank
    @Size(max = 100)
    private final String origin;

    @NotBlank
    @Size(max = 50)
    private final String status;


    /**
     * Konstruktor für CharakterFormDTO.
     *
     * @param id      Die eindeutige ID des Charakters, kann null sein für neue Charaktere
     * @param name    Name des Charakters (2-100 Zeichen, nicht leer)
     * @param gender  Geschlecht des Charakters (nicht leer)
     * @param species Spezies des Charakters (nicht leer)
     * @param origin  Herkunft des Charakters (max. 100 Zeichen, nicht leer)
     * @param status  Status des Charakters (max. 50 Zeichen, nicht leer)
     */
    public CharakterFormDTO(Long id, String name, String gender, String species, String origin, String status) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.species = species;
        this.origin = origin;
        this.status = status;
    }

    /**
     * Wandelt eine Charakter-Entity in ein CharakterFormDTO um.
     *
     * @param charakter Die Charakter-Entity, die konvertiert werden soll
     * @return Ein neues CharakterFormDTO mit den Daten aus der Entity
     */
    public static CharakterFormDTO fromEntity(Charakter charakter) {
        return new CharakterFormDTO(
                charakter.getId(),
                charakter.getName(),
                charakter.getSpecies(),
                charakter.getGender(),
                charakter.getOrigin(),
                charakter.getStatus()
        );
    }

    /**
     * Gibt die ID des Charakters zurück.
     *
     * @return id die eindeutige Identifikationsnummer des Charakters
     */
    public Long getId() {
        return id;
    }

    /**
     * Gibt den Namen des Charakters zurück.
     *
     * @return name der Name des Charakters
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt die Spezies des Charakters zurück.
     *
     * @return species die Spezies des Charakters
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Gibt das Geschlecht des Charakters zurück.
     *
     * @return gender das Geschlecht des Charakters
     */
    public String getGender() {
        return gender;
    }

    /**
     * Gibt die Herkunft des Charakters zurück.
     *
     * @return origin die Herkunft des Charakters
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Gibt den Status des Charakters zurück.
     *
     * @return status der Status des Charakters
     */
    public String getStatus() {
        return status;
    }
}