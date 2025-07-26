# Rick & Morty Game – Spring Boot Backend

Ein Spring-Boot-Backend für die Verwaltung von Charakteren und Favoriten mit vollständiger CRUD-Funktionalität entwickelt 
zur Integration mit dem React-Frontend der [Projektarbeit „Rick & Morty Game“](https://github.com/ImeschNico/React-Projektarbeit-Rick-Morty-Game).

---

## Einleitung

Dieses Projekt ist ein **Spring Boot Backend** zur Verwaltung von Charakteren und Favoriten aus dem Rick & Morty Universum. 
Es stellt eine moderne **REST-API** bereit, die das Erstellen, Lesen, Aktualisieren und Löschen von Charakteren und Favoriten ermöglicht.

Ziel ist es, dem React-Frontend alle nötigen Schnittstellen zur Verfügung zu stellen, um:
- Charaktere darzustellen,
- Favoriten zu speichern.

Das zugehörige Frontend findest du hier:  
[React-Projektarbeit-Rick-Morty-Game (GitHub)](https://github.com/ImeschNico/React-Projektarbeit-Rick-Morty-Game)

---

## Technologien & Tools

| Technologie / Tool | Beschreibung |
|--------------------|--------------|
| **Java 21** | Programmiersprache für das Backend |
| **Spring Boot** | Framework zur schnellen Entwicklung von RESTful Webservices |
| **Maven** | Build- und Dependency-Management |
| **PostgreSQL** | Produktionsdatenbank für persistente Speicherung |
| **Spring Data JPA** | ORM-Framework für Datenbankzugriffe über Repositorys |
| **Swagger / OpenAPI** | Automatisch generierte API-Dokumentation |
| **Docker** | Containerisierung von Datenbank und ggf. Backend |
| **Insomnia** | Tool zum Testen der HTTP-Endpunkte (ähnlich wie Postman) |
| **IntelliJ IDEA** | IDE für die Entwicklung |
| **Git & GitHub** | Versionskontrolle und Quellcodeverwaltung |
| **React (Frontend)** | React-Anwendung, welche das Backend konsumiert |

---

## Anforderungskatalog

Das Backend erfüllt folgende Hauptfunktionen:

### 1. Verwaltung von Charakteren
- Charaktere anlegen, lesen, aktualisieren und löschen (CRUD)
- Verwaltung der Attribute: **Name**, **Spezies**, **Status**, **Geschlecht**, **Herkunft**

### 2. Favoriten-Funktionalität
- Benutzer können Charaktere als Favoriten markieren
- Charaktere speichern, anzeigen, bearbeiten und löschen

### 3. REST-API Bereitstellung
- Alle Funktionen werden über **dokumentierte REST-Endpunkte** bereitgestellt

### 4. Validierung der Eingabedaten
- Es wird sichergestellt, dass nur **gültige Daten** gespeichert werden (z. B. keine leeren Felder)

### 5. Integration mit dem React-Frontend
- Die API ist optimiert für die Kommunikation mit dem React-Frontend
- Endpunkte sind so gestaltet, dass sie eine **reibungslose User Experience** im Frontend ermöglichen

---

