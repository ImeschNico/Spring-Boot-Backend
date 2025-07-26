package com.m295.m295_backend.entity;

import jakarta.persistence.*;


/**
 * Entity-Klasse für einen Charakter in der Datenbank.
 * Repräsentiert einen Charakter mit Attributen wie Name, Spezies,
 * Geschlecht, Herkunft und Status.
 * Die Entity wird in der Tabelle "charaktere" gespeichert.
 */
@Entity
@Table(name = "charaktere")
public class Charakter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Postgres macht auto Inrcrement
    private Long id;

    @Column(nullable = false, length = 100)
    //Spalte darf nicht 0 sein max 100 Zeichen
    private String name;

    @Column(nullable = false)
    // Spezies darf nicht null sein
    private String species;

    @Column(nullable = false)
    // Geschlecht darf nicht null sein
    private String gender;

    @Column(nullable = false, length = 100)
    // Herkunft darf nicht null sein und max. 100 Zeichen lang
    private String origin;

    @Column(nullable = false, length = 50)
    // Status darf nicht null sein und max. 50 Zeichen lang
    private String status;

    /**
     * Standard-Konstruktor für JPA.
     */
    public Charakter() {}

    /**
     * Konstruktor ohne ID, z.B. für neue Charaktere,
     * deren ID automatisch generiert wird.
     *
     * @param name    Name des Charakters
     * @param species Spezies des Charakters
     * @param gender  Geschlecht des Charakters
     * @param origin  Herkunft des Charakters
     * @param status  Status des Charakters (z.B. aktiv, inaktiv)
     */
    public Charakter(String name, String status, String gender, String origin, String species) {
        this.name = name;
        this.status = status;
        this.gender = gender;
        this.origin = origin;
        this.species = species;

    }

    /**
     * Konstruktor mit ID, z.B. zum Erstellen von Objekten
     * aus bestehenden Daten.
     *
     * @param id      Eindeutige ID des Charakters
     * @param name    Name des Charakters
     * @param species Spezies des Charakters
     * @param gender  Geschlecht des Charakters
     * @param origin  Herkunft des Charakters
     * @param status  Status des Charakters
     */
    public Charakter(Long id, String name, String status, String gender, String origin, String species) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.gender = gender;
        this.origin = origin;
        this.species = species;

    }


    /**
     * Liefert die ID des Charakters.
     *
     * @return die ID als Long
     */
    public Long getId() {
        return id;
    }

    /**
     * Setzt die ID des Charakters.
     *
     * @param id die zu setzende ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Liefert den Namen des Charakters.
     *
     * @return Name als String
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen des Charakters.
     *
     * @param name der neue Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Liefert die Spezies des Charakters.
     *
     * @return Spezies als String
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Setzt die Spezies des Charakters.
     *
     * @param species die neue Spezies
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * Liefert das Geschlecht des Charakters.
     *
     * @return Geschlecht als String
     */
    public String getGender() {
        return gender;
    }

    /**
     * Setzt das Geschlecht des Charakters.
     *
     * @param gender das neue Geschlecht
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Liefert die Herkunft des Charakters.
     *
     * @return Herkunft als String
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Setzt die Herkunft des Charakters.
     *
     * @param origin die neue Herkunft
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Liefert den Status des Charakters.
     *
     * @return Status als String
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setzt den Status des Charakters.
     *
     * @param status der neue Status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}