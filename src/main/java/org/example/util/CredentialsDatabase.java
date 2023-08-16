package org.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

public class CredentialsDatabase {

        private static final String PROPERTIES_FILE = "hibernate.properties";

        public static Properties getCredentials() {
            Properties properties = new Properties();
            try (InputStream inputStream = CredentialsDatabase.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
                if (inputStream != null) {
                    properties.load(inputStream);
                } else {
                    throw new RuntimeException(PROPERTIES_FILE + " not found");
                }
            } catch (IOException e) {
                throw new RuntimeException("Error loading " + PROPERTIES_FILE, e);
            }
            return properties;
        }

        public static String getDatabaseUrl() {
            return getCredentials().getProperty(URL);
        }

        public static String getDatabaseUsername() {
            return getCredentials().getProperty(USER);
        }

        public static String getDatabasePassword() {
            return getCredentials().getProperty(PASS);
        }
        private CredentialsDatabase(){

        }
    }

