package com.m295.m295_backend.controller;

import com.m295.m295_backend.dto.CharakterDTO;
import com.m295.m295_backend.dto.CharakterFormDTO;
import com.m295.m295_backend.entity.Charakter;
import com.m295.m295_backend.mapper.CharakterMapper;
import com.m295.m295_backend.service.CharakterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * REST-Controller zur Verwaltung von {@link Charakter}-Objekten.
 * <p>Stellt verschiedene Endpunkte für CRUD-Operationen, Filterung, Suche und DTO-Mapping bereit.</p>
 *
 * <p><strong>Beispiel:</strong></p>
 * <pre>{@code
 * GET /api/characters/all
 * POST /api/characters/create
 * }</pre>
 *
 * @see CharakterService
 * @see CharakterDTO
 * @see CharakterFormDTO
 */
@RestController
@RequestMapping("/api/characters")
@Tag(name = "Charakter", description = "Charaktere verwalten")
public class CharakterController {
    private final CharakterService service;

    /**
     * Konstruktor für {@link CharakterController}.
     *
     * @param service Service zur Verwaltung von Charakteren
     */
    public CharakterController(CharakterService service) {
        this.service = service;
    }

    /**
     * Gibt eine Liste aller Charaktere als {@link CharakterDTO} zurück.
     *
     * @return Liste aller gespeicherten Charaktere
     */
    @GetMapping("/all")
    @Operation(
            summary = "Alle Charaktere aufrufen",
            description = "Gibt alle Charaktere der API zurück"
    )
    public List<CharakterDTO> getAll() {
        return service.getAllCharaktersAsDTO();
    }

    /**
     * Sucht einen Charakter anhand seiner ID.
     *
     * @param id Die eindeutige ID des Charakters
     * @return {@link CharakterDTO} des gefundenen Charakters
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Charakter nach id",
            description = "Gibt alle Chars nach id gefitlert zurück"
    )
    @ApiResponse(responseCode = "200", description = "Charakter gefunden")
    @ApiResponse(responseCode = "404", description = "Charakter nicht gefunden")
    public CharakterDTO getCharakter(
            @Parameter(description = "ID des gesuchten Charakter", example = "1", required = true)
            @PathVariable Long id) {
        return service.getCharakterByIdAsDTO(id);

    }

    /**
     * Gibt die Anzahl der gespeicherten Charaktere zurück.
     *
     * @return Liste aller Charaktere
     */
    @GetMapping("/count")
    @Operation(
            summary = "Anzahl Charaktere",
            description = "gibt die Anzahl der Chars zurück"
    )
    public List<CharakterDTO> getAllCharakter() {
        return service.getAllCharaktersAsDTO();
    }

    /**
     * Erstellt einen neuen Charakter basierend auf {@link CharakterDTO}.
     *
     * @param dto Der zu erstellende Charakter
     * @return Der erstellte Charakter
     */
    @PostMapping
    @Operation(
            summary = "neuen Charakter erstellen",
            description = "erstellt einen neuen charakter mit übergenene Daten"
    )
    @ApiResponse(responseCode = "200", description = "Charakter erfolgreich erstellt")

    public CharakterDTO createCharakter(@Valid @RequestBody CharakterDTO dto) {
        return service.createCharakter(dto);
        //Validierung automatisch vor diesem code
    }

    /**
     * Aktualisiert einen bestehenden Charakter anhand seiner ID und den neuen Daten.
     *
     * @param id  ID des zu aktualisierenden Charakters
     * @param dto Neue Charakterdaten
     * @return Aktualisierter Charakter als {@link CharakterDTO}
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Charakter aktualisieren",
            description = "Cahrakter anahnd der id mit angebenen Daten aktualiseiren"
    )
    @ApiResponse(responseCode = "200", description = "Charakter erfolgreich aktualisiert")
    @ApiResponse(responseCode = "404", description = "Cahrakter nicht gefunden")

    public CharakterDTO updateCharakter(
            @Parameter(description = "Id des zu aktualiserenden Charakters", example = "1", required = true)
            @PathVariable Long id, @Valid @RequestBody CharakterDTO dto) {
        return service.updateCharakter(id, dto);
    }

    /**
     * Löscht einen Charakter anhand der ID.
     *
     * @param id ID des zu löschenden Charakters
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Charakter löschen",
            description = "Löscht den Charakter mit der angebenen ID"
    )
    @ApiResponse(responseCode = "200", description = "Charakter gelöscht")
    @ApiResponse(responseCode = "404", description = "Charakter nicht gefunden")

    public void deleteCharakter(
            @Parameter(description = "Id des zu löschenden Charakters", example = "1")
            @PathVariable Long id) {
        service.deleteCharakter(id);
    }

    /**
     * Filtert Charaktere anhand von optionalen Parametern.
     *
     * @param species Spezies des Charakters (optional)
     * @param status  Status des Charakters (optional)
     * @param gender  Geschlecht des Charakters (optional)
     * @param origin  Herkunft des Charakters (optional)
     * @return Gefilterte Liste der Charaktere
     */
    //Kombinierte Filter
    @GetMapping("/filter")
    @Operation(
            summary = "Charakter filtern",
            description = "Gibt eine Liste von Chars zurück, die dem Filter entsprechen"
    )
    public List<CharakterDTO> getFilteredCharacters(
            @Parameter(description = "Spezies des Chars")
            @RequestParam(required = false) String species,

            @Parameter(description = "Status des Chars")
            @RequestParam(required = false) String status,

            @Parameter(description = "Geschlecht des Chars")
            @RequestParam(required = false) String gender,

            @Parameter(description = "Herkunft des Chars")
            @RequestParam(required = false) String origin
    ) {
        return service.filterCharacters(species, status, gender, origin);
    }

    /**
     * Zählt Charaktere nach Spezies.
     *
     * @param species Die zu filternde Spezies
     * @return Anzahl der Charaktere dieser Spezies
     */
    @GetMapping("/count/species/{species}")
    @Operation(
            summary = "Anzahl der Charaktere nach Spezies",
            description = "Gibt die Anzahl der Charaktere zurück, die den angegebene Spezies haben"
    )
    public long countBySpecies(
            @Parameter(description = "Spezies der Charaktere", example = "Erde", required = true)
            @PathVariable String species) {
        return service.countBySpecies(species);
    }

    /**
     * Zählt Charaktere nach Status.
     *
     * @param status Der zu filternde Status
     * @return Anzahl der Charaktere mit diesem Status
     */
    @GetMapping("/count/status/{status}")
    @Operation(
            summary = "Anzahl der Charaktere nach Status",
            description = "Gibt die Anzahl der Charaktere zurück, die den angegebenen Status haben"
    )
    @ApiResponse(responseCode = "200", description = "Anzahl erfolgreich zurückgegeben")
    @Parameter(description = "Status der Charaktere", example = "Alive", required = true)
    public long countByStatus(@PathVariable String status) {
        return service.countByStatus(status);
    }

    /**
     * Zählt Charaktere nach Geschlecht.
     *
     * @param gender Das zu filternde Geschlecht
     * @return Anzahl der Charaktere mit diesem Geschlecht
     */
    @GetMapping("/count/gender/{gender}")
    @Operation(
            summary = "Anzahl der Charaktere nach Geschlecht",
            description = "Gibt die Anzahl der Charaktere zurück, die den angegebene Geschlecht haben"
    )
    public long countByGender(
            @Parameter(description = "Geschlecht der Charaktere", example = "Männlich", required = true)
            @PathVariable String gender) {
        return service.countByGender(gender);
    }

    // --- Textsuche ---

    /**
     * Sucht Charaktere anhand eines Namens-Keywords.
     *
     * <p><strong>Beispiel:</strong></p>
     * <pre>{@code
     * GET /api/characters/search/name?keyword=Rick
     * }</pre>
     *
     * @param keyword Teilstring des Namens
     * @return Liste der passenden Charaktere
     */
    @GetMapping("/search/name")
    @Operation(
            summary = "Charakter nach Name suchen",
            description = "Charakter nach angebenem Keyword suchen"
    )
    @ApiResponse(responseCode = "200", description = "Suchergebniss erfolgreich")

    public List<CharakterDTO> searchByName(
            @Parameter(description = "Suchbegriff für den Namen", example = "Rick", required = true)
            @RequestParam String keyword) {
        return service.searchByNameKeyword(keyword);
    }

    //Für Drop Down Felder
    /**
     * Gibt eine Liste aller einzigartigen Spezies zurück.
     *
     * @return Liste der Spezies
     */
    @GetMapping("/distinct/species")
    @Operation(
            summary = "Liste aller einzigartigen Arten (species)",
            description = "Gibt eine Liste aller einzigartigen Arten zurück, die in der Datenbank vorhanden sind"
    )
    public List<String> getSpeciesList() {
        return service.getDistinctSpecies();
    }

    /**
     * Gibt eine Liste aller einzigartigen Herkunftsorte zurück.
     *
     * @return Liste der Herkunftsorte
     */
    @GetMapping("/distinct/origin")
    @Operation(
            summary = "Liste aller einzigartigen Herkunftsorte",
            description = "Gibt eine Liste aller einzigartigen Herkunftsorte der Charaktere zurück"
    )
    public List<String> getOriginList() {
        return service.getDistinctOrigins();
    }

    //Methoden für formular mit charakterFormDTO
    /**
     * Gibt alle Charaktere als {@link CharakterFormDTO} zurück.
     *
     * @return Liste aller Charaktere im FormDTO-Format
     */
    @GetMapping("/all/form")
    @Operation(
            summary = "Alle Charakter als FormDTO",
            description = "GIbt eine Liste aller Charaktere als FormDTO zurück"
    )
    @ApiResponse(responseCode = "200", description = "Erfolgreiche Rückgabe der Charakterliste")

    public List<CharakterFormDTO> getAllCharactersAsFormDTO(){
        return service.getAllCharactersAsFormDTO();
    }

    /**
     * Gibt einen Charakter im {@link CharakterFormDTO} Format zurück.
     *
     * @param id ID des gesuchten Charakters
     * @return Charakterdaten im Formularformat
     */
    @GetMapping("/{id}/edit")
    @Operation(
            summary = "Charakter von Form DTO nach id",
            description = "Gibt die Daten des Chars als Form DTO zurück"
    )
    @ApiResponse(responseCode = "200", description = "Charakter gefunden")
    @ApiResponse(responseCode = "400", description = "Charakter nicht gefunden")
    public CharakterFormDTO getCharakterFormDTO(@PathVariable long id) {
        return service.getCharactersByIdAsFormDTO(id);
    }

    /**
     * Erstellt einen neuen Charakter basierend auf {@link CharakterFormDTO}.
     *
     * @param formDTO Formulardaten für den Charakter
     * @return Erstellter Charakter als FormDTO
     */
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Erstellt einen neuen Char",
            description = "Erstellt einen neuen char basierend auf Form DTO daten"
    )
    @ApiResponse(responseCode = "201", description = "Charakter erfolgreich erstellt")
    @ApiResponse(responseCode = "400", description = "Ungültige Eingabe")

    public CharakterFormDTO createCharacterFromFormDTO(@Valid @RequestBody CharakterFormDTO formDTO) {
        Charakter charakter = CharakterMapper.fromFormDTO(formDTO);
        return service.createCharacterFromForm(charakter);
    }

    /**
     * Aktualisiert einen bestehenden Charakter mit neuen Formdaten.
     *
     * @param id      ID des Charakters
     * @param formDTO Neue Formulardaten
     * @return Aktualisierter Charakter als FormDTO
     */
    @PutMapping("/{id}/update")
    @Operation(
            summary = "Aktualisierte Charakter",
            description = "Aktualisiert einen Char mit den neuen Form Daten"
    )
    @ApiResponse(responseCode = "200", description = "Charakter erfolgreich aktualisiert")
    @ApiResponse(responseCode = "400", description = "Ungültige EIngabe")
    @ApiResponse(responseCode = "404", description = "Charakter nicht gefunden")

    public CharakterFormDTO updateCharacterFromFormDTO(@PathVariable long id, @Valid @RequestBody CharakterFormDTO formDTO) {
        Charakter charakter = CharakterMapper.fromFormDTO(formDTO);
        return service.updateCharakterFromForm(id, charakter);
    }

    /**
     * Gibt einen zufälligen Charakter aus der Datenbank zurück.
     *
     * @return Ein zufälliger {@link Charakter} als ResponseEntity oder 404, falls keine vorhanden sind.
     */
    @GetMapping("/random")
    @Operation(
            summary = "Zufälliger Charakter",
            description = "Gibt einen zufällig ausgewählten Charakter aus der Datenbank zurück"
    )
    @ApiResponse(responseCode = "200", description = "Zufälliger Charakter erfolgreich gefunden")
    @ApiResponse(responseCode = "404", description = "Keine Charaktere vorhanden")
    public ResponseEntity<?> getRandomCharacter() {
        List<CharakterDTO> allCharacters = service.getAllCharaktersAsDTO();

        if (allCharacters.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Keine Charaktere vorhanden.");
        }

        int randomIndex = new Random().nextInt(allCharacters.size());
        CharakterDTO randomCharacter = allCharacters.get(randomIndex);

        return ResponseEntity.ok(randomCharacter);
    }
}
