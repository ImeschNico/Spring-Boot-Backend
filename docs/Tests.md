# Testplan

## Ziel
Ziel des Tests ist es, die grundlegenden Funktionalitäten der Applikation sicherzustellen, insbesondere die REST-Schnittstellen für Charaktere und Favoriten. Getestet wird sowohl die Datenverarbeitung als auch das Verhalten der Web-API. Dabei werden Unit-Tests, Integrationstests sowie manuelle Tests durchgeführt.

---

## Testumgebung

| Komponente    | Version / Details                     |
|--------------|-------------------------------------|
| Java         | 21                                  |
| Spring Boot  | 3.x                                 |
| JUnit        | 5 (Jupiter)                         |
| Mockito      | 5 (für Mocking in Unit-Tests)       |
| Testframeworks| Spring Boot Test, WebMvcTest, Mockito |
| Build-Tool   | Maven                               |
| IDE          | IntelliJ IDEA                       |
| Testdatenbank| H2 In-Memory-Datenbank (für Tests konfiguriert mit application-test.properties) |

---

## Testarten

| Testart          | Beschreibung                                             |
|------------------|----------------------------------------------------------|
| Unit-Tests       | Einzelne Methoden in Service-Klassen werden isoliert getestet |
| Integrationstests| Repository-Schicht wird gegen H2-Datenbank getestet     |
| Web-Tests       | Controller-Endpoints werden mittels MockMvc auf korrektes Verhalten geprüft |

---

## Getestete Funktionalitäten Unit- und Integrationstests

| Funktionalität           | Testklasse                  | Beschreibung                                                                                     |
|-------------------------|-----------------------------|-------------------------------------------------------------------------------------------------|
| Context Loading         | M295BackendApplicationTests | Prüft, ob die Spring Boot Application ohne Fehler startet (Smoke Test).                         |
| CharakterService        | CharakterServiceTest         | - Alle Charaktere abrufen (getAllCharakters())<br>- Charakter anhand der ID abrufen (getCharakterById()) |
| CharakterRepository (DB)| CharakterRepositoryTest      | - Filtern nach Species, Status, Gender, Origin<br>- Zählen nach Species, Status, Gender<br>- Suche nach Name (Contains)<br>- Liste distinct Species und Origins abrufen |
| CharakterController (API)| CharakterControllerTest    | - GET /api/characters/all gibt eine JSON-Liste mit allen Charakteren zurück                     |

---

## Testdaten
Die Tests werden mit einer fixen H2-In-Memory-Datenbank durchgeführt. Es werden Testdatensätze wie z. B. „Rick Sanchez“, „Morty Smith“, „Birdperson“ und „Summer Smith“ verwendet.

---

## Erwartetes Ergebnis
Alle automatisierten und manuellen Tests sollen erfolgreich durchlaufen. Die REST-Schnittstellen sollen fehlerfrei auf HTTP-Requests reagieren, valide JSON-Daten liefern und erwartungsgemäss mit der Datenbank interagieren.

---

## Testausführung
Die Tests werden ausgeführt über:
- IntelliJ Test Runner (Rechtsklick > Run Tests)

---

## Testergebnisse

**CharakterControllerTest:**  

![Test1](/docs/screenshots/Test1.png)

Ergebnis: Test bestanden

---

**CharakterServiceTest:** 

![Test2](/docs/screenshots/Test2.png)

Ergebnis: Test bestanden

---

**CharakterRepositoryTest:**  

![Test3](/docs/screenshots/Test3.png)

Ergebnis: Test bestanden

---

## Fazit
Die Tests stellen sicher, dass die Repository-Methoden wie erwartet funktionieren und die Datenbankabfragen korrekt ausgeführt werden. Damit wird die Datenintegrität und die Funktionalität der Datenzugriffsschicht gewährleistet.