package com.api.client;

import com.api.config.RequestSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiClient {

    private ApiClient() {
    }

    public static Response get(String endpoint) {

        return RestAssured
                .given()
                .spec(RequestSpec.getRequestSpecification())
                .when()
                .get(endpoint);
    }

    public static Response post(
            String endpoint,
            Object requestBody) {

        return RestAssured
                .given()
                .spec(RequestSpec.getRequestSpecification())
                .body(requestBody)
                .when()
                .post(endpoint);
    }
}