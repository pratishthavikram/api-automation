package com.api.tests;

import com.api.clients.BookingClient;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateBookingTest {

    private static final Logger log =
            LoggerFactory.getLogger(CreateBookingTest.class);

    private final BookingClient bookingClient =
            new BookingClient();

    @Test
    public void createBooking() {

        log.info("Starting create booking test");

        String requestBody = """
                {
                    "firstname": "Jim",
                    "lastname": "Brown",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2026-08-20",
                        "checkout": "2026-08-25"
                    },
                    "additionalneeds": "Breakfast"
                }
                """;

        Response response =
                bookingClient.createBooking(requestBody);

        Assert.assertEquals(
                response.statusCode(),
                200,
                "Create booking request failed");

        Assert.assertNotNull(
                response.jsonPath().get("bookingid"),
                "Booking ID should not be null");

        log.info(
                "Create booking test completed successfully");
    }
}