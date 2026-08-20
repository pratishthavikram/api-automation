package com.api.tests;

import com.api.clients.BookingClient;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateBookingDataDrivenTest {

    private static final Logger log =
            LoggerFactory.getLogger(
                    CreateBookingDataDrivenTest.class);

    private final BookingClient bookingClient =
            new BookingClient();

    @DataProvider(name = "bookingData")
    public Object[][] bookingData() {

        return new Object[][]{
                {"John", "Doe"},
                {"Alice", "Smith"},
                {"Robert", "Brown"}
        };
    }

    @Test(dataProvider = "bookingData")
    public void createBookingWithDifferentNames(
            String firstName,
            String lastName) {

        log.info(
                "Creating booking for firstName={} lastName={}",
                firstName,
                lastName);

        String requestBody = """
                {
                    "firstname": "%s",
                    "lastname": "%s",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2026-08-20",
                        "checkout": "2026-08-25"
                    },
                    "additionalneeds": "Breakfast"
                }
                """.formatted(
                firstName,
                lastName);

        Response response =
                bookingClient.createBooking(requestBody);

        Assert.assertEquals(
                response.statusCode(),
                200,
                "Create booking failed");

        Assert.assertNotNull(
                response.jsonPath().get("bookingid"),
                "Booking ID should not be null");

        Assert.assertEquals(
                response.jsonPath().getString(
                        "booking.firstname"),
                firstName);

        Assert.assertEquals(
                response.jsonPath().getString(
                        "booking.lastname"),
                lastName);

        log.info(
                "Booking created successfully for {} {}",
                firstName,
                lastName);
    }
}