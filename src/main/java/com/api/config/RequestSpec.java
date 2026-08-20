package com.api.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    private RequestSpec() {
    }

    public static RequestSpecification getRequestSpecification() {

        return new RequestSpecBuilder()
                .setBaseUri(Config.getBaseUrl())
                .setContentType("application/json")
                .addFilter(
                        LoggingConfig.requestLogger(System.out)
                )
                .addFilter(
                        LoggingConfig.responseLogger(System.out)
                )
                .build();
    }
}