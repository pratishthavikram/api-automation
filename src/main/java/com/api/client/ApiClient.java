package com.api.client;

import com.api.config.Config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiClient {

    private ApiClient() {
    }

    public static Response get(String endpoint) {

        return RestAssured
                .given()
                .baseUri(Config.get("baseUrl"))
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint);
    }

    public static Response post(String endpoint, Object body) {

        return RestAssured
                .given()
                .baseUri(Config.get("baseUrl"))
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(endpoint);
    }
}