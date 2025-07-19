package com.m295.m295_backend.service;

import com.m295.m295_backend.dto.CharakterDTO;
import com.m295.m295_backend.dto.CharakterFormDTO;
import com.m295.m295_backend.entity.Charakter;
import com.m295.m295_backend.exception.CharakterNotFoundException;
import com.m295.m295_backend.exception.InvalidCharakterDataException;
import com.m295.m295_backend.exception.InvalidCharakterSpeciesException;
import com.m295.m295_backend.exception.InvalidCharakterStatusException;
import com.m295.m295_backend.mapper.CharakterMapper;
import com.m295.m295_backend.repository.CharakterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service-Klasse für Charakter-Operationen.
 * Kümmert sich um Business-Logik, Validierung und DTO-Mapping.
 */
@Service
public class CharakterService {
    private final CharakterRepository repository;


    public CharakterService(CharakterRepository repository) {
        this.repository = repository;
    }

    /**
     * Gibt alle Charaktere als Liste von CharakterFormDTO zurück.
     *
     * @return Liste aller Charaktere als CharakterFormDTO
     */
    public List<CharakterFormDTO> getAllCharactersAsFormDTO() {
        List<Charakter> entities = repository.findAll();
        return CharakterMapper.toFormDTOList(entities);
    }

    /**
     * Holt einen Charakter per ID als CharakterFormDTO.
     *
     * @param id die ID des Charakters
     * @return CharakterFormDTO des Charakters mit der gegebenen ID
     * @throws IllegalArgumentException wenn die ID null ist
     * @throws RuntimeException         wenn kein Charakter mit der ID gefunden wird
     */
    public CharakterFormDTO getCharactersByIdAsFormDTO(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        Charakter entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Charakter with id " + id + " not found"));
        return CharakterMapper.toFormDTO(entity);
    }

    /**
     * Speichert einen neuen Charakter basierend auf den übergebenen Daten.
     *
     * @param charakter das DTO mit den Charakterdaten, die gespeichert werden sollen
     * @return das gespeicherte CharakterFormDTO mit der vergebenen ID
     * @throws IllegalArgumentException wenn formDTO null ist
     */
    public CharakterFormDTO createCharacterFromForm(Charakter charakter) {
        Charakter saved = repository.save(charakter);
        return CharakterMapper.toFormDTO(saved);
    }

    /**
     * Aktualisiert einen existierenden Charakter mit den neuen Daten.
     *
     * @param id        die ID des zu aktualisierenden Charakters
     * @param charakter das DTO mit den neuen Charakterdaten
     * @return das aktualisierte CharakterFormDTO
     * @throws IllegalArgumentException wenn id oder formDTO null ist
     * @throws RuntimeException         wenn kein Charakter mit der ID gefunden wird
     */
    public CharakterFormDTO updateCharakterFromForm(Long id, Charakter charakter) {
        if (!repository.existsById(id)) {
            throw new CharakterNotFoundException(id);
        }
        charakter.setId(id);
        Charakter updated = repository.save(charakter);
        return CharakterMapper.toFormDTO(updated);
    }

    /**
     * Gibt alle Charaktere als Liste von DTOs zurück.
     *
     * @return Liste aller Charaktere als CharakterDTO
     */
    public List<CharakterDTO> getAllCharaktersAsDTO() {
        List<Charakter> entities = repository.findAll();
        return CharakterMapper.toDTOList(entities);
    }

    /**
     * Holt einen Charakter per ID als DTO.
     *
     * @param id die ID des Charakters
     * @return CharakterDTO des Charakters mit der gegebenen ID
     * @throws CharakterNotFoundException wenn der Charakter nicht gefunden wird
     */
    public CharakterDTO getCharakterByIdAsDTO(Long id) {
        Charakter entity = getCharakterById(id);
        return CharakterMapper.toDTO(entity);
    }

    /**
     * Gibt alle Charaktere als Entity-Liste zurück.
     *
     * @return Liste aller Charakter-Entities
     */
    public List<Charakter> getAllCharakters() {
        return repository.findAll();
    }

    /**
     * Holt einen Charakter als Entity anhand seiner ID.
     *
     * @param id die ID des Charakters
     * @return Charakter-Entity
     * @throws CharakterNotFoundException wenn kein Charakter mit der ID existiert
     */
    public Charakter getCharakterById(Long id) {
        Optional<Charakter> optionalCharakter = repository.findById(id);

        if (optionalCharakter.isEmpty()) {
            throw new CharakterNotFoundException(id);
        }
        return optionalCharakter.get();
    }


    /**
     * Zählt Charaktere nach Spezies (case-insensitive).
     *
     * @param species die Spezies
     * @return Anzahl Charaktere mit der angegebenen Spezies
     */
    public long countBySpecies(String species) {
        return repository.countBySpeciesIgnoreCase(species);
    }

    /**
     * Zählt Charaktere nach Status (case-insensitive).
     *
     * @param status der Status
     * @return Anzahl Charaktere mit dem angegebenen Status
     */
    public long countByStatus(String status) {
        return repository.countByStatusIgnoreCase(status);
    }

    /**
     * Zählt Charaktere nach Geschlecht (case-insensitive).
     *
     * @param gender das Geschlecht
     * @return Anzahl Charaktere mit dem angegebenen Geschlecht
     */
    public long countByGender(String gender) {
        return repository.countByGenderIgnoreCase(gender);
    }

    /**
     * Sucht Charaktere nach einem Keyword im Namen (case-insensitive).
     *
     * @param keyword Suchbegriff
     * @return Liste der gefundenen Charaktere als DTOs
     */
    public List<CharakterDTO> searchByNameKeyword(String keyword) {
        List<Charakter> list = repository.findByNameContainingIgnoreCase(keyword);
        return CharakterMapper.toDTOList(list);
    }

    /**
     * Filtert Charaktere anhand optionaler Filterparameter.
     * Null bedeutet, dass dieser Filter nicht angewendet wird.
     *
     * @param species Spezies-Filter (optional)
     * @param status  Status-Filter (optional)
     * @param gender  Geschlecht-Filter (optional)
     * @param origin  Herkunfts-Filter (optional)
     * @return Liste der gefilterten Charaktere als DTOs
     */
    public List<CharakterDTO> filterCharacters(String species, String status, String gender, String origin) {
        List<Charakter> results = repository.findAll().stream()
                .filter(c -> species == null || c.getSpecies().equalsIgnoreCase(species))
                .filter(c -> status == null || c.getStatus().equalsIgnoreCase(status))
                .filter(c -> gender == null || c.getGender().equalsIgnoreCase(gender))
                .filter(c -> origin == null || c.getOrigin().equalsIgnoreCase(origin))
                .toList();

        return CharakterMapper.toDTOList(results);
    }

    /**
     * Gibt eine Liste aller verschiedenen Spezies zurück.
     *
     * @return Liste mit eindeutigen Spezies
     */
    public List<String> getDistinctSpecies() {
        return repository.findDistinctSpecies();
    }

    /**
     * Gibt eine Liste aller verschiedenen Herkunftsorte zurück.
     *
     * @return Liste mit eindeutigen Herkunftsorten
     */
    public List<String> getDistinctOrigins() {
        return repository.findDistinctOrigin();
    }

    /**
     * Erstellt einen neuen Charakter basierend auf dem DTO.
     * Führt Validierungen für Status, Geschlecht, Spezies und Herkunft durch.
     *
     * @param charakterDTO DTO mit Charakterdaten
     * @return DTO des neu erstellten Charakters
     * @throws InvalidCharakterDataException bei ungültigen Daten
     */
    public CharakterDTO createCharakter(CharakterDTO charakterDTO) {
        //Validierung
        if (charakterDTO == null) {
            throw new InvalidCharakterDataException("CharakterDTO darf nicht null sein");
        }
        validateStatus(charakterDTO.getStatus());
        validateGender(charakterDTO.getGender());
        validateSpecies(charakterDTO.getSpecies());
        validateOrigin(charakterDTO.getOrigin());
        //DTO zu Entity konventieren ( ohne ID = id = 0)
        Charakter entity = CharakterMapper.toEntity(charakterDTO);
        //repository.save aufrufen(erkennt automatisch create)
        Charakter newCharakter = repository.save(entity);
        //Entity zu DTO konventieren
        CharakterDTO newDTO = CharakterMapper.toDTO(newCharakter);
        //Dto zurückgeben
        return newDTO;
    }

    /**
     * Aktualisiert einen existierenden Charakter basierend auf ID und DTO.
     *
     * @param id           die ID des zu aktualisierenden Charakters
     * @param charakterDTO DTO mit den neuen Charakterdaten
     * @return DTO des aktualisierten Charakters
     * @throws CharakterNotFoundException wenn der Charakter nicht existiert
     */
    public CharakterDTO updateCharakter(Long id, CharakterDTO charakterDTO) {
        //Prüfen ob Charakter existert
        if (!repository.existsById(id)) {
            throw new CharakterNotFoundException(id);
        }
        //DTO zu EIntity konventieren und ID setzen
        Charakter entity = CharakterMapper.toEntity(charakterDTO);
        entity.setId(id); //setzt die ID für update erkennung
        //Repository.save aufrufen erkennt create automatisch
        Charakter updatedEntity = repository.save(entity);
        //aktualiserte Eintity als dto zurückgeben
        return CharakterMapper.toDTO(updatedEntity);
    }

    /**
     * Löscht einen Charakter anhand seiner ID.
     *
     * @param id ID des Charakters, der gelöscht werden soll
     */
    public void deleteCharakter(Long id) {
        repository.deleteById(id);   // wirft Exception falls ID nicht existiert
    }

    // --- Validierungsmethoden ---

    /**
     * Validiert den Status eines Charakters.
     *
     * @param status der Status
     * @throws InvalidCharakterStatusException wenn der Status ungültig ist
     */
    private void validateStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new InvalidCharakterStatusException("Status darf nicht leer sein");
        }

        List<String> valid = List.of("alive", "dead", "unknown");
        if (!valid.contains(status.toLowerCase())) {
            throw new InvalidCharakterStatusException(
                    "Invalid status: " + status + ". Valid statuses: " + valid);
        }
    }

    /**
     * Validiert das Geschlecht eines Charakters.
     *
     * @param gender das Geschlecht
     * @throws IllegalArgumentException wenn das Geschlecht ungültig ist
     */
    private void validateGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throw new IllegalArgumentException("Gender darf nicht leer sein");
        }

        List<String> valid = List.of("male", "female", "genderless", "unknown");
        if (!valid.contains(gender.toLowerCase())) {
            throw new IllegalArgumentException(
                    "Invalid gender: " + gender + ". Valid genders: " + valid);
        }
    }

    /**
     * Validiert die Spezies eines Charakters.
     *
     * @param species die Spezies
     * @throws InvalidCharakterSpeciesException wenn die Spezies ungültig ist
     */
    private void validateSpecies(String species) {
        if (species == null || species.trim().isEmpty()) {
            throw new InvalidCharakterSpeciesException("Species darf nicht leer sein");
        }

        List<String> valid = List.of("human", "alien", "robot", "animal", "mutant");
        if (!valid.contains(species.toLowerCase())) {
            throw new InvalidCharakterSpeciesException(
                    "Invalid species: " + species + ". Valid species: " + valid);
        }
    }

    /**
     * Validiert die Herkunft eines Charakters.
     *
     * @param origin die Herkunft
     * @throws IllegalArgumentException wenn die Herkunft ungültig ist
     */
    private void validateOrigin(String origin) {
        if (origin == null || origin.trim().isEmpty()) {
            throw new IllegalArgumentException("Origin darf nicht leer sein");
        }

        List<String> valid = List.of("earth (c-137)", "earth (replacement dimension)",
                "citadel of ricks", "galactic federation prison");
        if (!valid.contains(origin.toLowerCase())) {
            throw new IllegalArgumentException(
                    "Invalid origin: " + origin + ". Valid origins: " + valid);
        }
    }
}
