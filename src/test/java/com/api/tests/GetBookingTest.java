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

        log.info("Creating booking before fetching it");

        // Create a booking first
        Response createResponse = bookingClient.createBooking();

        Assert.assertEquals(
                createResponse.statusCode(),
                200,
                "Booking creation failed");

        int bookingId =
                createResponse.jsonPath().getInt("bookingid");

        log.info("Created booking with ID: {}", bookingId);

        // Get the newly created booking
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
                "Successfully fetched booking with ID: {}",
                bookingId);
    }
}
