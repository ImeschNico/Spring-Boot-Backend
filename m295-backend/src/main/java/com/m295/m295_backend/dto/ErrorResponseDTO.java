package com.m295.m295_backend.dto;

import java.time.LocalDateTime;

/**
 * Standardisierte Error-Response für alle API-Fehler.
 * <p>
 * Diese Klasse bietet eine konsistente Struktur für Fehlerantworten,
 * die vom Backend an das Frontend gesendet werden. Sie erleichtert
 * das zentrale und einheitliche Fehler-Handling.
 * </p>
 *
 * <p><strong>Beispiel:</strong></p>
 * <pre>{@code
 * new ErrorResponseDTO(
 *     "QUESTION_NOT_FOUND",
 *     "Die Frage mit der angegebenen ID wurde nicht gefunden.",
 *     404,
 *     "/api/questions/42"
 * );
 * }</pre>
 */
public class ErrorResponseDTO {
    private String error;
    private String message;
    private int status;
    private LocalDateTime timestamp;
    private String path;

    /**
     * Erstellt eine neue Fehler-Antwort mit aktuellen Zeitstempel.
     *
     * @param error   Der technische Fehlercode (z.B. "QUESTION_NOT_FOUND")
     * @param message Benutzerfreundliche Fehlermeldung, die dem Client angezeigt werden kann
     * @param status  Der HTTP-Statuscode (z.B. 404, 500)
     * @param path    Der aufgerufene API-Pfad, bei dem der Fehler auftrat
     */
    public ErrorResponseDTO(String error, String message, int status, String path) {
        this.error = error;
        this.message = message;
        this.status = status;
        this.path = path;
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Gibt den technischen Fehlercode zurück.
     * @return error der technische Fehlercode
     */
    public String getError() {
        return error;
    }

    /**
     * Setzt den technischen Fehlercode.
     * @param error der technische Fehlercode
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Gibt die benutzerfreundliche Fehlermeldung zurück.
     * @return message die benutzerfreundliche Fehlermeldung
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setzt die benutzerfreundliche Fehlermeldung.
     * @param message die benutzerfreundliche Fehlermeldung
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gibt den HTTP-Statuscode zurück.
     * @return status der HTTP-Statuscode
     */
    public int getStatus() {
        return status;
    }

    /**
     * Setzt den HTTP-Statuscode.
     * @param status der HTTP-Statuscode
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Gibt den Zeitstempel zurück, wann der Fehler auftrat.
     * @return timestamp der Zeitstempel des Fehlers
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Setzt den Zeitstempel für den Fehler.
     * @param timestamp der Zeitstempel des Fehlers
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Gibt den API-Pfad zurück, an dem der Fehler auftrat.
     * @return path der API-Pfad des Fehlers
     */
    public String getPath() {
        return path;
    }

    /**
     * Setzt den API-Pfad, an dem der Fehler auftrat.
     * @param path der API-Pfad des Fehlers
     */
    public void setPath(String path) {
        this.path = path;
    }
}