package com.m295.m295_backend.dto;



/**
 * Data Transfer Object (DTO) für Favoriten.
 * Diese Klasse repräsentiert die Informationen eines Charakters, der als Favorit gespeichert wurde.
 * Sie wird verwendet, um Daten zwischen Backend und Frontend zu übertragen.
 */
public class FavoritDTO {

    /**
     * Die eindeutige ID des Favoriten.
     */
    private Long id;

    /**
     * Die ID des zugehörigen Charakters.
     */
    private final Long charakterId;

    /**
     * Der Name des Charakters.
     */
    private String name;

    /**
     * Der Status des Charakters (z. B. "Alive", "Dead", "Unknown").
     */
    private String status;

    /**
     * Die Bild-URL des Charakters.
     */
    private final String image;

    /**
     * Die Spezies des Charakters (z. B. "Human", "Alien").
     */
    private final String species;

    /**
     * Das Geschlecht des Charakters (z. B. "Male", "Female", "Unknown").
     */
    private final String gender;

    /**
     * Der Herkunftsort des Charakters (z. B. "Earth").
     */
    private final String origin;


    /**
     * Konstruktor ohne ID – wird z. B. für neue Favoriten aus dem Frontend verwendet.
     *
     * @param charakterId Die ID des Charakters
     * @param name        Der Name des Charakters
     * @param status      Der Status des Charakters
     * @param image       Die Bild-URL des Charakters
     * @param species     Die Spezies des Charakters
     * @param gender      Das Geschlecht des Charakters
     * @param origin      Der Herkunftsort des Charakters
     */
    public FavoritDTO(Long charakterId, String name, String status, String image, String species, String gender, String origin) {
        this.charakterId = charakterId;
        this.name = name;
        this.status = status;
        this.image = image;
        this.species = species;
        this.gender = gender;
        this.origin = origin;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCharakterId() {
        return charakterId;
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



    public String getSpecies() {
        return species;
    }


    public String getGender() {
        return gender;
    }


    public String getOrigin() {
        return origin;
    }

}
