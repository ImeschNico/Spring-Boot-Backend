## REST-Schnittstellen

Das Backend stellt eine RESTful API bereit, die es ermöglicht, Charaktere und Favoriten zu verwalten. Die API folgt den HTTP-Konventionen (GET, POST, PUT, DELETE) und verwendet JSON als Datenformat.

---

### Charaktere

#### `GET /api/charaktere`
- **Beschreibung**: Gibt eine Liste aller vorhandenen Charaktere zurück.
- **HTTP-Methode**: `GET`
- **Request-Body**: keiner
- **Response**:  
  ![REST1](/docs/screenshots/REST1.png)


---

#### `GET /api/charaktere/{id}`
- **Beschreibung**: Ruft einen bestimmten Charakter anhand seiner ID ab.
- **HTTP-Methode**: `GET`
- **Path-Parameter**:  
  `id: Long` – ID des gewünschten Charakters
- **Response**:  
  ![REST2](/docs/screenshots/REST2.png)


---

#### `POST /api/charaktere`
- **Beschreibung**: Erstellt einen neuen Charakter.
- **HTTP-Methode**: `POST`
- **Request-Body**:
- **Response**: Erstellter Charakter mit generierter ID:

  ![REST3](/docs/screenshots/REST3.png)


---

#### `PUT /api/charaktere/{id}`
- **Beschreibung**: Aktualisiert einen bestehenden Charakter anhand der ID.
- **HTTP-Methode**: `PUT`
- **Path-Parameter**:  
  `id: Long` – ID des zu aktualisierenden Charakters
- **Request-Body**: gleiche Struktur wie POST
- **Response**: aktualisierter Charakter

  ![REST4](/docs/screenshots/REST4.png)


---

#### `DELETE /api/charaktere/{id}`
- **Beschreibung**: Löscht einen Charakter anhand der ID.
- **HTTP-Methode**: `DELETE`
- **Path-Parameter**:  
  `id: Long`
- **Response**: HTTP 200 (bei Erfolg)

  ![REST5](/docs/screenshots/REST5.png)


---

#### `GET /api/charaktere/filter`
- **Beschreibung**: Filtert Charaktere nach optionalen Parametern.
- **HTTP-Methode**: `GET`
- **Query-Parameter**:
    - `species: String` (optional)
    - `status: String` (optional)
    - `gender: String` (optional)
    - `origin: String` (optional)
- **Response**: Liste der passenden Charaktere

  ![REST6](/docs/screenshots/REST6.png)


---

### Favoriten

#### `GET /api/favoriten`
- **Beschreibung**: Gibt alle gesetzten Favoriten zurück.
- **HTTP-Methode**: `GET`
- **Response**:  
  _Beispiel folgt_

  ![REST7](/docs/screenshots/REST7.png)


---

#### `POST /api/favoriten`
- **Beschreibung**: Fügt einen Charakter zu den Favoriten hinzu.
- **HTTP-Methode**: `POST`
- **Request-Body**:  
  _Beispiel folgt_
- **Response**: Der erstellte Favorit

  ![REST8](/docs/screenshots/REST8.png)


---

#### `DELETE /api/favoriten/{id}`
- **Beschreibung**: Entfernt einen Favoriten anhand seiner ID.
- **HTTP-Methode**: `DELETE`
- **Path-Parameter**:  
  `id: Long`
- **Response**: HTTP 200

  ![REST9](/docs/screenshots/REST9.png)

---

### Swagger

Swagger ist ein Tool zur Dokumentation und zum Testen von REST-APIs. Es erstellt automatisch eine interaktive Benutzeroberfläche, in der alle Endpunkte beschrieben und direkt getestet werden können.

Swagger ist unter folgendem Link im Browser verfügbar:
http://localhost:8080/swagger-ui/index.html#/
