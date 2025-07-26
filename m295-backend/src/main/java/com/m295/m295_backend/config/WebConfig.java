package com.m295.m295_backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Konfiguriert CORS (Cross-Origin Resource Sharing) für das Backend.
 *
 * <p>
 * Diese Klasse ermöglicht Cross-Origin-Anfragen vom Frontend, z. B. bei einer
 * lokalen Entwicklung mit <code><a href="http://localhost:5173">...</a></code>.
 * </p>
 *
 * <p><strong>Details:</strong></p>
 * <ul>
 *   <li>Erlaubt Zugriffe auf Pfade unter <code>/api/**</code></li>
 *   <li>Erlaubt HTTP-Methoden: GET, POST, PUT, DELETE, OPTIONS</li>
 *   <li>Erlaubt alle Header</li>
 *   <li>Keine Weitergabe von Cookies/Credentials</li>
 *   <li>Maximale Cache-Dauer für Preflight-Requests: 3600 Sekunden</li>
 * </ul>
 *
 * <p><strong>Beispiel:</strong></p>
 * <pre>{@code
 * // Frontend läuft auf http://localhost:5173
 * fetch('http://localhost:8080/api/characters')
 *   .then(response => response.json())
 *   .then(data => console.log(data));
 * }</pre>
 *
 * @see CorsRegistry
 * @see WebMvcConfigurer
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Konfiguriert globale CORS-Regeln für REST-Endpunkte.
     *
     * @param registry das {@link CorsRegistry} Objekt zur Registrierung der Regeln
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(false)
                .maxAge(3600);
    }

}
