#  Architektur & Klassendiagramm

## Architektur des Backends

![Architekturdiagramm](/docs/screenshots/Architekturdiagramm.png)
![Architekturdiagramm2](/docs/screenshots/Architekturdiagramm2.png)

Das Backend wurde nach dem klassischen Schichtenmodell (Layered Architecture) aufgebaut. Es besteht aus drei Hauptschichten:

1. **Controller-Layer (API-Schicht)**  
   Diese Schicht nimmt HTTP-Anfragen vom Frontend entgegen. Sie fungiert als Schnittstelle zwischen Benutzeroberfläche (React-Frontend) und dem Backend.  
   Sie verwendet `@RestController`, um REST-Endpunkte bereitzustellen.

2. **Service-Layer (Business-Logik)**  
   In dieser Schicht befindet sich die zentrale Geschäftslogik der Anwendung. Hier werden die Daten validiert, verarbeitet oder mit weiteren Regeln versehen. Die Service-Klassen sind vom Controller aufrufbar, verwenden jedoch selbst keine Web-spezifischen Abhängigkeiten – was sie testbar und wiederverwendbar macht.

3. **Repository-Layer (Datenzugriff)**  
   Diese Schicht ist für die Kommunikation mit der Datenbank zuständig. Sie nutzt Spring Data JPA und ermöglicht einfachen Zugriff auf Entitäten wie Charakter oder Favorit. Durch die Nutzung von `JpaRepository`-Interfaces entfällt dabei ein Grossteil des Boilerplate Codes.

---

### Warum diese Architektur?

- **Trennung von Verantwortlichkeiten (Separation of Concerns):**  
  Jede Schicht hat eine klar definierte Aufgabe. Das macht den Code übersichtlicher, verständlicher und leichter wartbar.

- **Wiederverwendbarkeit & Testbarkeit:**  
  Die Service-Schicht kann unabhängig vom Controller getestet werden. Ausserdem können mehrere Controller denselben Service verwenden.

- **Skalierbarkeit & Erweiterbarkeit:**  
  Neue Funktionen können einfach durch Erweiterung der Schichten ergänzt werden, ohne bestehende Logik zu brechen.

- **Best Practices & Konventionen:**  
  Diese Architektur folgt bewährten Spring-Boot-Standards und wird in der Praxis häufig verwendet. Sie erleichtert auch anderen Entwickler:innen den Einstieg in das Projekt.

---

## Klassendiagramm

Das folgende Diagramm zeigt die wichtigsten Entitäten und deren Beziehungen zueinander. Im Zentrum steht die Entity `Charakter`, die über das Repository angesprochen wird. Die Struktur wurde nach JPA-Standards modelliert.

![Klassendiagramm](/docs/screenshots/Klassendiagramm.png)

---