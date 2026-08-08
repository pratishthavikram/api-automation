package com.api.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input =
                     Config.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException(
                        "config.properties not found"
                );
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to load configuration",
                    e
            );
        }
    }

    private Config() {
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public static int getApiTimeout() {
        return Integer.parseInt(
                properties.getProperty("api.timeout")
        );
    }
}