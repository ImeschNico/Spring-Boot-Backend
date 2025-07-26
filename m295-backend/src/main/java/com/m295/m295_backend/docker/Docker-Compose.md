### PostgreSQL mit Docker Compose starten

## docker-compose.yml datei anlegen:

```dockerfile
version: '3.8'

services:
  postgres:
    image: postgres:15
    container_name: M295-LB
    environment:
      POSTGRES_DB: M295_db
      POSTGRES_USER: db_user
      POSTGRES_PASSWORD: db_password
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data
    restart: unless-stopped

volumes:
  postgres_data:
```

---

## Docker Container starten

Im Terminal im Ordner mit docker-compose.yml ausführe:

```
docker-compose up -d
```
PostgreSQL läuft jetzt auf localhost:5432

---

