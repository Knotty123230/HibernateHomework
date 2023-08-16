package org.example.migration;

import org.example.util.CredentialsDatabase;
import org.flywaydb.core.Flyway;

public class FlywayMigration {
    private final String url = CredentialsDatabase.getDatabaseUrl();
    private final String username = CredentialsDatabase.getDatabaseUsername();
    private final String password = CredentialsDatabase.getDatabasePassword();
    public void migration(){
        Flyway flyway = Flyway
                .configure()
                .dataSource(url, username, password)
                .load();
        flyway.migrate();
    }
}
