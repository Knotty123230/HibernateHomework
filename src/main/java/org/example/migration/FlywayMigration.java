package org.example.migration;

import org.flywaydb.core.Flyway;

public class FlywayMigration {
    public void migration(){
        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:postgresql://localhost:5432/postgres", "mac", "")
                .load();
        flyway.migrate();
    }
}
