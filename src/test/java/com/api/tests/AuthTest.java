package com.api.tests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.api.config.Config;
import com.api.model.AuthRequest;
import com.api.service.BookingService;
import com.api.tests.assertions.ResponseAssertions;
import com.api.tests.base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest extends BaseTest {
    private static final Logger log =
            LoggerFactory.getLogger(AuthTest.class);

    @Test
    public void validAuthentication() {

        log.info("Starting valid authentication test");

        AuthRequest authRequest = new AuthRequest(
                Config.getUsername(),
                Config.getPassword());

        Response response = BookingService.authenticate(authRequest);

        response.prettyPrint();

        ResponseAssertions.verifyStatusCode(
                response,
                200);

        ResponseAssertions.verifyResponseTime(
                response,
                5000);

        ResponseAssertions.verifyHeaderExists(
                response,
                "Content-Type");

        String token = response.jsonPath().getString("token");

        Assert.assertNotNull(
                token,
                "Authentication token should not be null");

        Assert.assertFalse(
                token.isEmpty(),
                "Authentication token should not be empty");

        log.info("Valid authentication test completed successfully");
    }

    
}