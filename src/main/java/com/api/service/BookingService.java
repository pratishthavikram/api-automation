package com.api.service;

import com.api.client.ApiClient;
import com.api.constants.Endpoints;
import com.api.model.Booking;
import io.restassured.response.Response;

public class BookingService {

    public static Response createBooking(Booking booking) {

        return ApiClient.post(
                Endpoints.BOOKING,
                booking
        );
    }

    public static Response getBooking(int bookingId) {

        return ApiClient.get(
                Endpoints.BOOKING + "/" + bookingId
        );
    }

}