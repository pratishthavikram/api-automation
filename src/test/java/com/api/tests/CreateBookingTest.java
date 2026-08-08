package com.api.tests;

import com.api.builder.BookingBuilder;
import com.api.model.Booking;
import com.api.service.BookingService;
import com.api.tests.assertions.ResponseAssertions;
import com.api.tests.base.BaseTest;
import com.api.utils.TestData;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateBookingTest extends BaseTest {

    @Test
    public void createBooking() {

        Booking booking = BookingBuilder.createDefaultBooking();

        Response response = BookingService.createBooking(booking);

        response.prettyPrint();

        ResponseAssertions.verifyStatusCode(response, 200);

        ResponseAssertions.verifyResponseContains(
                response,
                "bookingid"
        );

        TestData.bookingId =
                response.jsonPath().getInt("bookingid");

        System.out.println("Booking ID : " + TestData.bookingId);
    }
}