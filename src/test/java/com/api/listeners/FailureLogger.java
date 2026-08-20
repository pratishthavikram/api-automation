package com.api.listeners;

import org.testng.ITestResult;

public class FailureLogger {

    private FailureLogger() {
    }

    public static void logFailure(ITestResult result) {

        System.err.println(
                "=========================================="
        );

        System.err.println(
                "TEST FAILED: "
                        + result.getName()
        );

        if (result.getThrowable() != null) {

            System.err.println(
                    "Exception: "
                            + result.getThrowable()
            );
        }

        System.err.println(
                "=========================================="
        );
    }
}