package com.lms.config;

import org.flywaydb.core.Flyway;

public class FlywayMigration {

    public static void migrate() {

        try {
            System.out.println("Starting DB migration...");

            // Load MySQL Driver (Required for some environments)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Configure Flyway
            Flyway flyway = Flyway.configure().dataSource("jdbc:mysql://localhost:3306/lms","root","root").locations("classpath:db/migration").baselineOnMigrate(true).load();

            // Run migration
            flyway.migrate();

            System.out.println("Database migrated successfully");

        } catch (Exception e) {
            System.out.println("Migration failed!");
            e.printStackTrace();
        }
    }
}
