package com.m295.m295_backend.exception;

/**
 * Exception, die geworfen wird, wenn Charakter-Daten ungültig oder unvollständig sind.
 *
 * Diese Exception wird genutzt, wenn Geschäftsregeln verletzt werden,
 * die nicht durch Bean Validation (@Valid) abgedeckt sind.
 */
public class InvalidCharakterDataException extends RuntimeException {
    /**
     * Erstellt eine neue InvalidCharakterDataException mit einer Fehlermeldung.
     *
     * @param message Beschreibung des Validierungsfehlers
     */
    public InvalidCharakterDataException(String message) {
        super(message);
    }

}
