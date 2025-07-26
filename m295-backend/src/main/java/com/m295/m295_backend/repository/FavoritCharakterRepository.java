package com.m295.m295_backend.repository;

import com.m295.m295_backend.entity.Favorit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository-Schnittstelle für Favoriten.
 * Bietet CRUD-Methoden für den Zugriff auf die Datenbank.
 */
@Repository
public interface FavoritCharakterRepository extends JpaRepository<Favorit, Long> {
}