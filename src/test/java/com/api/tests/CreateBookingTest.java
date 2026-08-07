package com.api.tests;

import com.api.client.ApiClient;
import com.api.constants.Endpoints;
import com.api.model.Booking;
import com.api.model.BookingDates;
import com.api.tests.assertions.ResponseAssertions;
import com.api.tests.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateBookingTest extends BaseTest {

    @Test
    public void createBooking() {

        BookingDates bookingDates = new BookingDates(
                "2026-08-10",
                "2026-08-15"
        );

        Booking booking = new Booking();

        booking.setFirstname("Pratishtha");
        booking.setLastname("Singh");
        booking.setTotalprice(1500);
        booking.setDepositpaid(true);
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        Response response = ApiClient.post(
                Endpoints.BOOKING,
                booking
        );

        response.prettyPrint();

        ResponseAssertions.verifyStatusCode(response, 200);

        ResponseAssertions.verifyResponseContains(
                response,
                "bookingid"
        );

    }


}