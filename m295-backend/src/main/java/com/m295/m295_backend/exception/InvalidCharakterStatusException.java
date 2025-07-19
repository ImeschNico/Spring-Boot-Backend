package com.m295.m295_backend.exception;

/**
 * Exception, die geworfen wird, wenn ein ungültiger Status für einen Charakter angegeben wurde.
 * Diese Exception signalisiert, dass der übergebene Status nicht zu den erlaubten
 * Werten (Alive, Dead, unknown) gehört.
 */
public class InvalidCharakterStatusException extends RuntimeException {
    /**
     * Erzeugt eine neue Exception mit einer spezifischen Fehlermeldung,
     * die den ungültigen Status beschreibt.
     *
     * @param status Der ungültige Status, der den Fehler ausgelöst hat
     */
    public InvalidCharakterStatusException(String status) {
        super("Ungültiger Status: '" + status + "'. Erlaubt: Alive, Dead, unknown.");
    }
}
