package com.api.tests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.api.model.AuthRequest;
import com.api.service.BookingService;
import com.api.tests.base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthNegativeTest extends BaseTest {
    private static final Logger log =
            LoggerFactory.getLogger(AuthTest.class);

    @Test
    public void invalidAuthentication() {

        log.info("Starting invalid authentication test");

        AuthRequest authRequest = new AuthRequest(
                "invalid_user",
                "invalid_password"
        );

        Response response =
                BookingService.authenticate(authRequest);

        response.prettyPrint();

        Assert.assertEquals(
                response.getStatusCode(),
                200
        );

        String reason =
                response.jsonPath().getString("reason");

        Assert.assertEquals(
                reason,
                "Bad credentials"
        );

        log.info("Invalid authentication test completed");
    }
}