package com.api.tests;

import com.api.client.ApiClient;
import com.api.constants.Endpoints;
import com.api.model.Booking;
import com.api.model.BookingDates;
import com.api.tests.assertions.ResponseAssertions;
import com.api.tests.base.BaseTest;
import com.api.utils.TestData;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateBookingTest extends BaseTest {

    @Test
    public void createBooking() {

        // Create Booking Dates
        BookingDates bookingDates = new BookingDates(
                "2026-08-10",
                "2026-08-15"
        );

        // Create Booking Payload
        Booking booking = new Booking();

        booking.setFirstname("Pratishtha");
        booking.setLastname("Singh");
        booking.setTotalprice(1500);
        booking.setDepositpaid(true);
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        // Send POST Request
        Response response = ApiClient.post(
                Endpoints.BOOKING,
                booking
        );

        // Print Response
        response.prettyPrint();

        // Validate Status Code
        ResponseAssertions.verifyStatusCode(response, 200);

        // Validate bookingid exists
        ResponseAssertions.verifyResponseContains(
                response,
                "bookingid"
        );

        // Store Booking ID for other tests
        TestData.bookingId = response.jsonPath().getInt("bookingid");

        System.out.println("--------------------------------");
        System.out.println("Booking Created Successfully");
        System.out.println("Booking ID : " + TestData.bookingId);
        System.out.println("--------------------------------");
    }
}