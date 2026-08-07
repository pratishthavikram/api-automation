package com.api.tests;

import com.api.client.ApiClient;
import com.api.constants.Endpoints;
import com.api.tests.assertions.ResponseAssertions;
import com.api.tests.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetBookingTest extends BaseTest {

    @Test
    public void getBooking() {

        Response response = ApiClient.get(
                Endpoints.BOOKING + "/1"
        );

        response.prettyPrint();

        ResponseAssertions.verifyStatusCode(
                response,
                200
        );

    }

}