package com.m295.m295_backend.exception;

/**
 * Exception, die geworfen wird, wenn ein Charakter
 * mit der angegebenen ID nicht gefunden wurde.
 *
 * Diese Exception sollte idealerweise zu einem HTTP 404 Statuscode
 * (Not Found) führen, wenn sie im Web-Kontext verwendet wird.
 */
public class CharakterNotFoundException extends RuntimeException {

    private final Long charakterId;

    /**
     * Erzeugt eine neue {@code CharakterNotFoundException} mit der ID
     * des nicht gefundenen Charakters.
     *
     * @param charakterId Die ID des Charakters, der nicht gefunden wurde.
     */
    public CharakterNotFoundException(Long charakterId) {
        super("Charakter with id " + charakterId + " not found");
        this.charakterId = charakterId;
    }
    /**
     * Gibt die ID des Charakters zurück, der nicht gefunden wurde.
     *
     * @return Die Charakter-ID.
     */
    public Long getCharakterId() {
        return charakterId;
    }

}