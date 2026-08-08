package com.api.tests;

import com.api.builder.BookingBuilder;
import com.api.model.Booking;
import com.api.service.BookingService;
import com.api.tests.assertions.ResponseAssertions;
import com.api.tests.base.BaseTest;
import com.api.tests.data.BookingDataProvider;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateBookingDataDrivenTest extends BaseTest {

    @Test(
        dataProvider = "bookingNames",
        dataProviderClass = BookingDataProvider.class
    )
    public void createBookingWithDifferentNames(
            String firstname,
            String lastname) {

        Booking booking = BookingBuilder.createDefaultBooking();

        booking.setFirstname(firstname);
        booking.setLastname(lastname);

        Response response = BookingService.createBooking(booking);

        response.prettyPrint();

        ResponseAssertions.verifyStatusCode(response, 200);

        ResponseAssertions.verifyResponseContains(
                response,
                "bookingid"
        );

        System.out.println(
                "Created booking for: "
                        + firstname
                        + " "
                        + lastname
        );
    }
}