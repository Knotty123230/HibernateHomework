package org.example;

import org.example.dto.Planet;
import org.example.service.PlanetService;
import org.flywaydb.core.Flyway;

public class Main {
    public static void main(String[] args) throws Exception {
        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:postgresql://localhost:5432/postgres", "mac", "")
                .load();
        flyway.migrate();
        PlanetService planetService = new PlanetService();
        Planet adadada = planetService.getPlanetByID("adadada");
        System.out.println(adadada);
    }
}