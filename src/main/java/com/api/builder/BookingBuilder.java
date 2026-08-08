package com.api.builder;

import com.api.model.Booking;
import com.api.model.BookingDates;

public class BookingBuilder {

    public static Booking createDefaultBooking() {

        BookingDates dates = new BookingDates(
                "2026-08-10",
                "2026-08-15"
        );

        Booking booking = new Booking();

        booking.setFirstname("Pratishtha");
        booking.setLastname("Singh");
        booking.setTotalprice(1500);
        booking.setDepositpaid(true);
        booking.setBookingdates(dates);
        booking.setAdditionalneeds("Breakfast");

        return booking;
    }
}