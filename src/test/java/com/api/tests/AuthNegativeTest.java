package com.api.tests;

import com.api.model.AuthRequest;
import com.api.service.BookingService;
import com.api.tests.base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthNegativeTest extends BaseTest {

    @Test
    public void invalidAuthentication() {

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
    }
}