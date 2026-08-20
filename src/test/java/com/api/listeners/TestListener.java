package com.api.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {

        System.out.println(
                "==========================================");

        System.out.println(
                "TEST SUITE STARTED: "
                        + context.getName());

        System.out.println(
                "==========================================");
    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println(
                "==========================================");

        System.out.println(
                "TEST SUITE FINISHED: "
                        + context.getName());

        System.out.println(
                "==========================================");
    }

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println(
                "STARTING TEST: "
                        + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println(
                "PASSED: "
                        + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        FailureLogger.logFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println(
                "SKIPPED: "
                        + result.getName());
    }
}