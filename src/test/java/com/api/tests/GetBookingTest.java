package com.api.tests;

import com.api.clients.BookingClient;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBookingTest {

    private static final Logger log =
            LoggerFactory.getLogger(GetBookingTest.class);

    private final BookingClient bookingClient =
            new BookingClient();

    @Test
    public void getBooking() {

        int bookingId = 1;

        log.info(
                "Starting get booking test for ID: {}",
                bookingId);

        Response response =
                bookingClient.getBooking(bookingId);

        Assert.assertEquals(
                response.statusCode(),
                200,
                "Get booking request failed");

        Assert.assertNotNull(
                response.jsonPath().get("firstname"),
                "Firstname should not be null");

        Assert.assertNotNull(
                response.jsonPath().get("lastname"),
                "Lastname should not be null");

        log.info(
                "Get booking test completed successfully");
    }
}