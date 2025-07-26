# Installationsanleitung

## 1. Projekt herunterladen

- Repository klonen oder ZIP herunterladen:
    - `git clone https://github.com/ImeschNico/Spring-Boot-Backend.git`
    - Oder Projekt als ZIP herunterladen und entpacken.

---

## 2. Voraussetzungen

- Java 21 (OpenJDK 21 empfohlen) installiert
- Maven installiert
- Docker (Version ≥ 20.x) installiert
- Docker Compose (Version ≥ 1.29.x) installiert
- Datenbank-Client wie DBeaver (optional, für DB-Zugriff)

---

## 3. Java- und Spring Boot-Version

- Java Version: 21
- Spring Boot Version: 3.1.0 (empfohlen für Java 21)

Im `pom.xml` bitte auf folgende Versionen achten:

```xml
<properties>
    <java.version>21</java.version>
    <spring-boot.version>3.1.0</spring-boot.version>
</properties>
```

---

## 4. PostgreSQL mit Docker Compose starten

[Dockeranleitung](/src/main/java/com/m295/m295_backend/docker/Docker-Compose.md)

---

## 4. Datenbankzugriff (z.B. mit DBeaver)

- Host: localhost
- Port: 5432
- Datenbank: M295_db
- Benutzername: db_user
- Passwort: db_password

## 5. Beispiel SQL-Skript zur Initialisierung

```sql
INSERT INTO charaktere (name, species, gender, origin, status) VALUES
('Rick Sanchez',           'Human',      'Male',    'Earth (C 137)',                'Alive'),
('Morty Smith',            'Human',      'Male',    'Earth (C 137)',                'Alive'),
('Summer Smith',           'Human',      'Female',  'Earth (Replacement Dimension)','Alive'),
('Beth Smith',             'Human',      'Female',  'Earth (Replacement Dimension)','Alive'),
('Jerry Smith',            'Human',      'Male',    'Earth (Replacement Dimension)','Alive'),
('Abadango Cluster Prince','Alien',      'Male',    'Abadango',                     'Alive'),
('Abradolf Lincler',       'Human',      'Male',    'Earth (Replacement Dimension)','Alive'),
('Adjudicator Rick',       'Human',      'Male',    'Citadel of Ricks',             'Dead'),
('Agency Director',        'Human',      'Male',    'Earth (Replacement Dimension)','Dead'),
('Alan Rails',             'Human',      'Male',    'Earth (Unknown dimension)',    'Dead'),

('Albert Einstein',        'Human',      'Male',    'Earth (C 137)',                'Alive'),
('Alexander',              'Human',      'Male',    'Earth (C 137)',                'Dead'),
('Alien Googah',           'Alien',      'Unknown', 'Unknown',                      'Unknown'),
('Alien Morty',            'Alien',      'Male',    'Citadel of Ricks',             'Unknown'),
('Alien Rick',             'Alien',      'Male',    'Citadel of Ricks',             'Unknown'),
('Amish Cyborg',           'Alien',      'Male',    'Alien Spa',                    'Dead'),
('Annie',                  'Human',      'Female',  'Anatomy Park',                 'Alive'),
('Antenna Morty',          'Human',      'Male',    'Citadel of Ricks',             'Alive'),
('Antenna Rick',           'Human',      'Male',    'Citadel of Ricks',             'Unknown'),
('Ants in my Eyes Johnson','Human',      'Male',    'Interdimensional Cable',       'Alive'),

('Armagheadon',            'Alien',      'Male',    'Giant Arm Planet',             'Alive'),
('Armothy',                'Unknown',    'Unknown', 'Unknown',                      'Alive'),
('Arthricia',              'Alien',      'Female',  'Purge Planet',                 'Alive'),
('Artist Morty',           'Human',      'Male',    'Citadel of Ricks',             'Alive'),
('Attila Starwar',         'Human',      'Male',    'Earth (Unknown dimension)',    'Alive'),
('Baby Legs',              'Human',      'Male',    'Earth (Unknown dimension)',    'Alive'),
('Baby Poopybutthole',     'Poopybutthole','Male',  'Earth (Unknown dimension)',    'Alive'),
('Baby Wizard',            'Alien',      'Male',    'Earth (Unknown dimension)',    'Dead'),
('Bearded Lady',           'Human',      'Female',  'Earth (Unknown dimension)',    'Alive'),
('Beebo',                  'Alien',      'Male',    'Nuoclear Dimension',           'Dead'),

('Benjamin',               'Poopybutthole','Male',  'Earth (Replacement Dimension)','Alive'),
('Bepisian',               'Alien',      'Genderless','Bepis 9',                    'Alive'),
('Beta-Seven',             'Alien',      'Male',    'Unknown',                      'Alive'),
('Beth Smith (C 500A)',    'Human',      'Female',  'Earth (C 500A)',               'Alive'),
('Beth Smith (J19ζ7)',     'Human',      'Female',  'Earth (J19ζ7)',                'Alive'),
('Big Boobed Waitress',    'Human',      'Female',  'Chinatown Planet',             'Alive'),
('Big Head Morty',         'Human',      'Male',    'Citadel of Ricks',             'Dead'),
('Big Morty',              'Human',      'Male',    'Citadel of Ricks',             'Dead'),
('Body Guard Morty',       'Human',      'Male',    'Citadel of Ricks',             'Alive'),
('Bill',                   'Alien',      'Male',    'Venzenulon 7',                 'Alive'),

('Birdperson',             'Alien',      'Male',    'Bird World',                   'Alive'),
('Black Rick',             'Human',      'Male',    'Citadel of Ricks',             'Alive'),
('Blamph',                 'Alien',      'Unknown', 'Blamph',                       'Alive'),
('Blim Blam',              'Alien',      'Male',    'Juicy Planet',                 'Alive'),
('Blue Shirt Morty',       'Human',      'Male',    'Citadel of Ricks',             'Alive'),
('Boobloosian',            'Alien',      'Female',  'Immortality Field Resort',     'Dead'),
('Bootleg Portal Chemist', 'Human',      'Male',    'Froopyland',                   'Alive'),
('Borpocian',              'Alien',      'Male',    'Borpocian Prime',              'Dead'),
('Brad',                   'Human',      'Male',    'Earth (Replacement Dimension)','Alive'),
('Bride of Birdperson',    'Alien',      'Female',  'Bird World',                   'Dead'),

('Broken Rick',            'Human',      'Male',    'Citadel of Ricks',             'Alive'),
('Mr. Goldenfold',         'Human',      'Male',    'Earth (Replacement Dimension)','Alive'),
('Coach Feratu',           'Vampire',    'Male',    'Earth (Unknown dimension)',    'Dead'),
('Conroy',                 'Robot',      'Genderless','HeistCon',                   'Alive'),
('Cool Rick',              'Human',      'Male',    'Citadel of Ricks',             'Alive'),
('Cop Morty',              'Human',      'Male',    'Citadel of Ricks',             'Alive'),
('Cop Rick',               'Human',      'Male',    'Citadel of Ricks',             'Alive'),
('Courier Flap',           'Alien',      'Male',    'Earth (Unknown dimension)',    'Alive'),
('Cousin Nicky',           'Human',      'Male',    'Earth (Unknown dimension)',    'Alive'),
('Creepy Rick',            'Human',      'Male',    'Citadel of Ricks',             'Alive');
```

---

## 6. SQL-Skript importieren

- In DBeaver: Rechtsklick auf die Datenbank `M295_db` → SQL Editor → Skript laden und ausführen.

---

## 7. Spring Boot Anwendung starten

- Stelle sicher, dass in der `application-test.properties` bzw. `application.properties` die DB-Verbindungsdaten stimmen:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/M295_db
spring.datasource.username=db_user
spring.datasource.password=db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

Anwendung mit Maven starten:
```bash
./mvnw spring-boot:run
```
