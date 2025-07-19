package com.m295.m295_backend.exception;

import com.m295.m295_backend.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.validation.FieldError;
import java.util.HashMap;
import java.util.Map;

/**
 * Globaler Exception Handler, der alle unbehandelten Exceptions abfängt
 * und in strukturierte Error-Responses konvertiert.
 *
 * {@code @ControllerAdvice} macht diese Klasse zu einem globalen Exception-Interceptor,
 * der Exceptions aus allen Controllern abfängt.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Behandelt CharakterNotFoundException und gibt HTTP 404 zurück.
     *
     * @param ex      Gefangene CharakterNotFoundException
     * @param request Aktueller HTTP-Request
     * @return ResponseEntity mit ErrorResponseDTO und Status 404
     */
    @ExceptionHandler(CharakterNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleCharakterNotFoundException(CharakterNotFoundException ex, WebRequest request) {

        ErrorResponseDTO error = new ErrorResponseDTO(
                "Charakter not found",
                "Charakter mit ID " + ex.getCharakterId() + " wurde nicht gefunden",
                404,
                extractPath(request)
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * Behandelt InvalidCharakterDataException und gibt HTTP 400 zurück.
     *
     * @param ex      Gefangene InvalidCharakterDataException
     * @param request Aktueller HTTP-Request
     * @return ResponseEntity mit ErrorResponseDTO und Status 400
     */
    @ExceptionHandler(InvalidCharakterDataException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidCharakterData(InvalidCharakterDataException ex, WebRequest request) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                "INVALID_CHARATCER_DATA",
                ex.getMessage(),
                400,
                extractPath(request)
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Behandelt InvalidCharakterStatusException und gibt HTTP 400 zurück.
     *
     * @param ex      Gefangene InvalidCharakterStatusException
     * @param request Aktueller HTTP-Request
     * @return ResponseEntity mit ErrorResponseDTO und Status 400
     */
    @ExceptionHandler(InvalidCharakterStatusException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidCharakterStatus(InvalidCharakterStatusException ex, WebRequest request) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                "INVALID_CHARACTER_STATUS",
                    ex.getMessage(),
                400,
                extractPath(request)
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Behandelt InvalidCharakterSpeciesException und gibt HTTP 400 zurück.
     *
     * @param ex      Gefangene InvalidCharakterSpeciesException
     * @param request Aktueller HTTP-Request
     * @return ResponseEntity mit ErrorResponseDTO und Status 400
     */
    @ExceptionHandler(InvalidCharakterSpeciesException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidSpecies(InvalidCharakterSpeciesException ex, WebRequest request) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                "INVALID_CHARATER_SPECIES",
                ex.getMessage(),
                400,
                extractPath(request)
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Fallback-Handler für alle anderen Exceptions.
     * Gibt HTTP 500 zurück ohne technische Details im Response-Body.
     *
     * @param ex      Gefangene Exception
     * @param request Aktueller HTTP-Request
     * @return ResponseEntity mit ErrorResponseDTO und Status 500
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGeneralException(
            Exception ex, WebRequest request) {

        // Log the actual exception for debugging (nicht an Frontend senden!)
        System.err.println("Unhandled exception: " + ex.getMessage());
        ex.printStackTrace();

        ErrorResponseDTO error = new ErrorResponseDTO(
                "INTERNAL_SERVER_ERROR",
                "Ein unerwarteter Fehler ist aufgetreten. Bitte versuchen Sie es später erneut.",
                500,
                extractPath(request)
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Behandelt Validierungsfehler bei Bean Validation (@Valid).
     * Sammelt alle Feldfehler und gibt eine konsolidierte Fehlermeldung mit HTTP 400 zurück.
     *
     * @param ex      MethodArgumentNotValidException mit Validierungsdetails
     * @param request Aktueller HTTP-Request
     * @return ResponseEntity mit ErrorResponseDTO und Status 400
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationErrors(
            MethodArgumentNotValidException ex, WebRequest request) {

        // Sammle alle Validierungsfehler
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        // Erstelle benutzerfreundliche Fehlermeldung
        StringBuilder message = new StringBuilder("Validierungsfehler: ");
        errors.forEach((field, error) -> message.append(field)
                .append(" - ").append(error).append("; "));

        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                "VALIDATION_ERROR",
                message.toString(),
                400,
                extractPath(request)
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Hilfsmethode zum Extrahieren des API-Pfads aus dem WebRequest.
     *
     * @param request WebRequest des aktuellen Aufrufs
     * @return API-Pfad als String (z.B. "/api/charaktere/42")
     */
    private String extractPath(WebRequest request) {
        return request.getDescription(false).replace("uri=", "");
    }
}



