package com.api.config;

import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import java.io.PrintStream;

public class LoggingConfig {

    private LoggingConfig() {
    }

    public static RequestLoggingFilter requestLogger(PrintStream stream) {
        return new RequestLoggingFilter(
                LogDetail.ALL,
                stream
        );
    }

    public static ResponseLoggingFilter responseLogger(PrintStream stream) {
        return new ResponseLoggingFilter(
                LogDetail.ALL,
                stream
        );
    }
}