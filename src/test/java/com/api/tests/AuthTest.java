package com.api.tests;

import com.api.clients.AuthClient;
import com.api.config.Config;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest {

    private static final Logger log =
            LoggerFactory.getLogger(AuthTest.class);

    private final AuthClient authClient =
            new AuthClient();

    @Test
    public void validAuthentication() {

        log.info("Starting valid authentication test");

        Response response =
                authClient.createToken(
                        Config.getUsername(),
                        Config.getPassword());

        Assert.assertEquals(
                response.statusCode(),
                200,
                "Authentication failed");

        Assert.assertNotNull(
                response.jsonPath().getString("token"),
                "Token should not be null");

        log.info(
                "Valid authentication test completed successfully");
    }
}