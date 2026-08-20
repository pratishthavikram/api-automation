package com.api.tests;

import com.api.clients.BookingClient;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBookingNegativeTest {

    private static final Logger log =
            LoggerFactory.getLogger(
                    GetBookingNegativeTest.class);

    private final BookingClient bookingClient =
            new BookingClient();

    @Test
    public void getBookingWithInvalidId() {

        int invalidBookingId = 999999;

        log.info(
                "Starting negative get booking test for ID: {}",
                invalidBookingId);

        Response response =
                bookingClient.getBooking(
                        invalidBookingId);

        Assert.assertEquals(
                response.statusCode(),
                404,
                "Expected booking not found response");

        log.info(
                "Negative get booking test completed successfully");
    }
}