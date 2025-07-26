package com.m295.m295_backend.entity;

import jakarta.persistence.*;

/**
 * Entity-Klasse für einen Favoriten.
 * Repräsentiert einen Charakter, der als Favorit markiert wurde.
 */
@Entity
@Table(name = "favoriten")
public class Favorit {

    /**
     * Eindeutige ID des Favoriten (Primärschlüssel).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Die ID des Charakters, der favorisiert wurde.
     */
    @Column(nullable = false)
    private Long charakterId;

    /**
     * Der Name des favorisierten Charakters.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Der Status des favorisierten Charakters.
     */
    @Column(nullable = false)
    private String status;

    /**
     * Die Bild-URL des favorisierten Charakters.
     */
    @Column(nullable = false)
    private String image;

    /**
     * Die Spezies des Charakters (z.B. "Human", "Alien").
     */
    @Column(nullable = true)
    private String species;

    /**
     * Das Geschlecht des Charakters (z.B. "Male", "Female", "Unknown").
     */
    @Column(nullable = true)
    private String gender;

    /**
     * Der Herkunftsort des Charakters (z.B. "Earth").
     */
    @Column(nullable = true)
    private String origin;

    /**
     * Standard-Konstruktor für JPA.
     */
    public Favorit() {
    }

    /**
     * Konstruktor für das Erstellen eines Favoriten mit zusätzlichen Feldern.
     *
     * @param charakterId ID des Charakters
     * @param name        Name des Charakters
     * @param status      Status des Charakters
     * @param image       Bild-URL des Charakters
     * @param species     Spezies des Charakters
     * @param gender      Geschlecht des Charakters
     * @param origin      Herkunftsort des Charakters
     */
    public Favorit(Long charakterId, String name, String status, String image,
                   String species, String gender, String origin) {
        this.charakterId = charakterId;
        this.name = name;
        this.status = status;
        this.image = image;
        this.species = species;
        this.gender = gender;
        this.origin = origin;
    }

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCharakterId() {
        return charakterId;
    }

    public void setCharakterId(Long charakterId) {
        this.charakterId = charakterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // Getter und Setter für species, gender, origin:

    /** Gibt die Spezies zurück. */
    public String getSpecies() {
        return species;
    }

    /** Setzt die Spezies. */
    public void setSpecies(String species) {
        this.species = species;
    }

    /** Gibt das Geschlecht zurück. */
    public String getGender() {
        return gender;
    }

    /** Setzt das Geschlecht. */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /** Gibt den Herkunftsort zurück. */
    public String getOrigin() {
        return origin;
    }

    /** Setzt den Herkunftsort. */
    public void setOrigin(String origin) {
        this.origin = origin;
    }
}