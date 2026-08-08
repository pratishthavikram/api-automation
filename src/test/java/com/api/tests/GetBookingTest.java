package com.api.tests;

import com.api.service.BookingService;
import com.api.tests.assertions.ResponseAssertions;
import com.api.tests.base.BaseTest;
import com.api.utils.TestData;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBookingTest extends BaseTest {

    @Test(dependsOnMethods = "com.api.tests.CreateBookingTest.createBooking")
    public void getBooking() {

        Response response =
                BookingService.getBooking(TestData.bookingId);

        response.prettyPrint();

        ResponseAssertions.verifyStatusCode(response, 200);

        Assert.assertEquals(
                response.jsonPath().getString("firstname"),
                "Pratishtha"
        );

        Assert.assertEquals(
                response.jsonPath().getString("lastname"),
                "Singh"
        );
    }
}