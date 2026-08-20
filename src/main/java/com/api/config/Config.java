package com.api.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Properties properties = new Properties();

    static {

        String environment =
                System.getProperty("env", "qa");

        String configFile =
                "config-" + environment.toLowerCase() + ".properties";

        try (InputStream input =
                     Config.class
                             .getClassLoader()
                             .getResourceAsStream(configFile)) {

            if (input == null) {
                throw new RuntimeException(
                        "Configuration file not found: " + configFile
                );
            }

            properties.load(input);

            System.out.println(
        "Running tests against environment: "
                + environment.toUpperCase()
);

System.out.println(
        "Base URL: "
                + properties.getProperty("base.url")
);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to load configuration: " + configFile,
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

    public static String getUsername() {
    return properties.getProperty("username");
}

public static String getPassword() {
    return properties.getProperty("password");
}
}