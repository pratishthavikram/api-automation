package com.api.tests.data;

import org.testng.annotations.DataProvider;

public class BookingDataProvider {

    @DataProvider(name = "bookingNames")
    public Object[][] bookingNames() {

        return new Object[][]{
                {"Pratishtha", "Singh"},
                {"John", "Doe"},
                {"Alice", "Smith"}
        };
    }
}