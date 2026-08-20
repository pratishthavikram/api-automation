package com.api.tests;

import com.api.clients.AuthClient;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthNegativeTest {

    private static final Logger log =
            LoggerFactory.getLogger(AuthNegativeTest.class);

    private final AuthClient authClient =
            new AuthClient();

    @Test
    public void invalidAuthentication() {

        log.info("Starting invalid authentication test");

        Response response =
                authClient.createToken(
                        "invalid-user",
                        "invalid-password");

        log.info(
                "Authentication response status: {}",
                response.statusCode());

        log.info(
                "Authentication response body: {}",
                response.asString());

        Assert.assertEquals(
                response.statusCode(),
                200,
                "Unexpected HTTP status");

        Assert.assertTrue(
                response.asString().contains("Bad credentials"),
                "Expected authentication failure message was not found");

        log.info(
                "Invalid authentication test completed successfully");
    }
}