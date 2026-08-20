package com.api.clients;

import com.api.config.Config;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class AuthClient {

    private static final Logger log =
            LoggerFactory.getLogger(AuthClient.class);

    private static final String AUTH_ENDPOINT = "/auth";

    public Response createToken(String username, String password) {

        log.info("Starting authentication request");

        String requestBody = """
                {
                    "username": "%s",
                    "password": "%s"
                }
                """.formatted(username, password);

        Response response =
                given()
                        .baseUri(Config.getBaseUrl())
                        .contentType("application/json")
                        .body(requestBody)
                .when()
                        .post(AUTH_ENDPOINT);

        log.info(
                "Authentication response status: {}",
                response.statusCode());

        return response;
    }
}