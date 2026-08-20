package com.api.clients;

import com.api.config.Config;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class BookingClient {

    private static final Logger log =
            LoggerFactory.getLogger(BookingClient.class);

    private static final String BOOKING_ENDPOINT = "/booking";

    public Response createBooking(String requestBody) {

        log.info("Creating booking");

        Response response =
                given()
                        .baseUri(Config.getBaseUrl())
                        .contentType("application/json")
                        .body(requestBody)
                .when()
                        .post(BOOKING_ENDPOINT);

        log.info(
                "Create booking response status: {}",
                response.statusCode());

        return response;
    }

    public Response getBooking(int bookingId) {

        log.info(
                "Getting booking with ID: {}",
                bookingId);

        Response response =
                given()
                        .baseUri(Config.getBaseUrl())
                        .contentType("application/json")
                .when()
                        .get(BOOKING_ENDPOINT + "/" + bookingId);

        log.info(
                "Get booking response status: {}",
                response.statusCode());

        return response;
    }
}