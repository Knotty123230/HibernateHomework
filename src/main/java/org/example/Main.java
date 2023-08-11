package org.example;

import org.example.migration.FlywayMigration;

public class Main {
    public static void main(String[] args)  {
        new FlywayMigration().migration();
    }
}