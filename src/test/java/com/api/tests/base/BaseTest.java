package com.api.tests.base;

import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void setup() {
        System.out.println("Starting API Test Suite");
    }
}