package com.m295.m295_backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Konfiguriert Swagger/OpenAPI für die Dokumentation der REST API.
 *
 * <p>
 * Diese Konfiguration stellt die OpenAPI-Metadaten bereit, wie Titel,
 * Version, Beschreibung und Kontaktinformationen.
 * </p>
 *
 * <p><strong>Beispiel-Konfiguration in Swagger UI:</strong></p>
 * <pre>{@code
 * {
 *   "openapi": "3.0.1",
 *   "info": {
 *     "title": "M295 Backend",
 *     "version": "1.0.0",
 *     "description": "Rest API für M294 Frontend mit CRUD-Operations",
 *     "contact": {
 *       "name": "M294 Backend"
 *     }
 *   }
 * }
 * }</pre>
 *
 * @author Nico Imesch
 * @see <a href="https://springdoc.org/">springdoc-openapi</a>
 */
@Configuration
public class SwaggerConfig {

    /**
     * Erstellt und konfiguriert ein {@link OpenAPI}-Objekt zur Bereitstellung
     * der API-Dokumentation in Swagger UI.
     *
     * @return ein konfiguriertes {@link OpenAPI} Objekt mit API-Informationen
     *
     * @see OpenAPI
     * @see Info
     * @see Contact
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("M295 Backend")
                        .version("1.0.0")
                        .description("Rest API für M294 Frontend mit CRUD-Operations")
                        .contact(new Contact()
                        .name("M294 Backend")));
    }
}