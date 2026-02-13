package com.lms.listener;

import com.lms.config.FlywayMigration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppStartupListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            System.out.println("Starting DB migration...");
            FlywayMigration.migrate();
        } catch (Exception e) {
            throw new RuntimeException("Migration failed", e);
        }
    }

}
