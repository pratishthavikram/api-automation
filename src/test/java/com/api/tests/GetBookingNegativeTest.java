package com.api.tests;

import com.api.service.BookingService;
import com.api.tests.base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBookingNegativeTest extends BaseTest {

    @Test
    public void getBookingWithInvalidId() {

        int invalidBookingId = 999999999;

        Response response =
                BookingService.getBooking(invalidBookingId);

        response.prettyPrint();

        Assert.assertEquals(
                response.getStatusCode(),
                404,
                "Expected 404 for invalid booking ID"
        );
    }
}