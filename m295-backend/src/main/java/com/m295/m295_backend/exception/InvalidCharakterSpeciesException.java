package com.m295.m295_backend.exception;

/**
 * Exception, die geworfen wird, wenn eine ungültige Spezies für einen Charakter angegeben wurde.
 *
 * Diese Exception signalisiert, dass die übergebene Spezies nicht zu den erlaubten
 * Werten gehört.
 */
public class InvalidCharakterSpeciesException extends RuntimeException {
    /**
     * Erzeugt eine neue Exception mit einer spezifischen Fehlermeldung,
     * die die ungültige Spezies beschreibt.
     *
     * @param species Die ungültige Spezies, die den Fehler ausgelöst hat
     */
    public InvalidCharakterSpeciesException(String species) {
        super("Ungültige Spezies: '" + species + "'. Nur bestimmte Spezies sind erlaubt.");
    }
}
