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

## Arichitektur & Klassendiagramm
[Architektur & Klassendiagramm](m295-backend/docs/Architektur+Klassendiagramm.md)

---

## REST_Schnittstellen
[REST-Schnittstellen](docs/REST-Schnittstellen.md)

---

## Tests
[Tests](docs/Tests.md)

---

## Installationsanleitung
[Installationsanleitung](docs/Installationsanleitung.md) 

---

## JavaDoc Dokumentation

JavaDoc ist die automatisch generierte API-Dokumentation deines Java-Projekts. Sie beschreibt Klassen, Methoden und deren Nutzung.

### Wie man die JavaDoc erstellt und öffnet:

1. JavaDoc generieren:
```bash
mvn javadoc:javadoc
```

2. JavaDoc lokal öffnen(z.B im Terminal)
```bash
start .\target\site\apidocs\index.html
```

---

## Frontend-Integration

Die Integration des Backends mit dem Frontend wurde erfolgreich umgesetzt, obwohl dies nicht Teil der ursprünglichen Aufgabenstellung war. Dadurch ist eine nahtlose Kommunikation zwischen den beiden Komponenten gewährleistet.

Das Integrations-Repository, welches die Verbindung zwischen Backend und Frontend verwaltet, befindet sich separat und kann hier eingesehen werden:  
[Projekt-Repository](https://github.com/ImeschNico/Rick-Morty-Projekt-Komplett)

Für Details zur Integration und Nutzung der REST-APIs empfiehlt sich ein Blick in das Projekt-Repository.

---

## Hilfestellungen

Da dieses Backend mein erstes größeres Spring-Boot-Projekt ist, stellte die Umsetzung eine Herausforderung dar. Eine große Hilfe war dabei eine sehr genaue und strukturierte Anleitung eines anderen Schulprojekts, das wir im Unterricht erstellt hatten. Diese Anleitung diente mir als wichtige Orientierung, um mit dem Projekt zu starten.

Zusätzlich erhielt ich wertvolle Unterstützung von Klassenkameraden, die mir bei spezifischen Problemen weiterhelfen konnten. Auch nutzte ich KI-Tools wie ChatGPT, vor allem für Fehlerbehebungen, das Erstellen des SQL-Skripts sowie bei der Integration zwischen Backend und Frontend.

Durch die Schritt-für-Schritt-Anleitung der Lehrperson konnte ich viele Arbeitsschritte ableiten und gezielt auf mein Projekt übertragen. So legte ich eine solide Grundlage für das Backend, während ich bereits erlerntes Wissen vertiefte. Da die Integration mit dem Frontend nicht Teil der Aufgabenstellung war, ich diese aber dennoch umsetzen wollte, war die Unterstützung durch ChatGPT besonders hilfreich.

Des Weiteren habe ich intensiv Entwicklungswerkzeuge wie IntelliJ IDEA verwendet. Die Auto-Vervollständigungsfunktion und die Code-Vorschläge (unterstützt durch Tools wie GitHub Copilot) haben mir sehr geholfen, schneller und fehlerfreier zu programmieren. Diese Features erleichterten das Schreiben von sauberem und funktionalem Code, insbesondere bei wiederkehrenden Mustern und komplexeren Strukturen.

---

## Fazit und Learnings

Wie bereits erwähnt, war dies mein erstes Backend-Projekt in dieser Größe. Dementsprechend stand ich mehrfach vor größeren Herausforderungen. Dennoch war es eine sehr lehrreiche und bereichernde Erfahrung. Besonders gefallen hat mir, dass ich viele Themen, die wir im Unterricht an der WISS behandelt haben, direkt in die Praxis umsetzen konnte. Dazu gehörten unter anderem objektorientierte und funktionale Programmierung, das Erstellen von Docker-Compose-Files sowie der Umgang mit Datenbanken – alles Inhalte aus früheren Modulen, die ich durch dieses Projekt vertiefen konnte.

Die meisten Probleme hatte ich mit der Integration mit dem Frontend, welches ich ja bereits im vorherigen Modul erstellt habe. Da manche Funktionen im Frontend gefordert waren, welche das Backend noch nicht hatte, musste ich vieles nochmals neu bearbeiten, um das Backend auf das Frontend anzupassen.

Auch die ambitionierte Arbeit der Lehrperson hat mir bei diesem Projekt sehr geholfen. Entweder im direkten Austausch oder mit der exakten und strukturierten Anleitung des Demo-Projekts hat mir das sehr geholfen, das Projekt zu vollenden.

## Learnings

Mit diesem Projekt habe ich ein gutes Grundwissen für nächste Projekte aufgebaut. Jedoch werde ich mich in zukünftigen Projekten zuerst auf das Backend konzentrieren und darauf aufbauend das Frontend entwickeln, da mir die Integration zwischen den beiden am meisten Probleme gemacht hat. Somit musste ich an vielen Stellen im Backend, aber auch im Frontend Anpassungen vornehmen, welche durch ein anderes Vorgehen wahrscheinlich nicht so entstanden wären.
