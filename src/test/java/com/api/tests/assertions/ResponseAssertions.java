package com.api.tests.assertions;

import io.restassured.response.Response;
import org.testng.Assert;

public class ResponseAssertions {

    private ResponseAssertions() {
    }

    public static void verifyStatusCode(Response response, int expectedStatusCode) {

        Assert.assertEquals(
                response.getStatusCode(),
                expectedStatusCode,
                "Status code mismatch"
        );
    }

    public static void verifyResponseContains(Response response, String expectedText) {

        Assert.assertTrue(
                response.asString().contains(expectedText),
                "Expected text not found in response"
        );
    }

    public static void verifyEquals(String actual, String expected) {
        Assert.assertEquals(
                actual,
                expected,
                "Values do not match"
        );
    }

    public static void verifyResponseTime(
        Response response,
        long maxResponseTime) {

    Assert.assertTrue(
            response.getTime() <= maxResponseTime,
            "Response time exceeded expected limit. Actual: "
                    + response.getTime()
                    + " ms"
    );
}

public static void verifyHeaderExists(
        Response response,
        String headerName) {

    Assert.assertNotNull(
            response.getHeader(headerName),
            "Expected header not found: " + headerName
    );
}

}