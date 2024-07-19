package com.saurabhAPIAuto.tests.extendDemo;

import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // Assuming ExtentManager.createTest method creates a test case in the report
        ExtentManager.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Flushing the report instance after test success
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Flushing the report instance after test failure
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Flushing the report instance after test skipped
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onStart(ITestContext context) {
        // Initializing the report instance at the start of the test
        ExtentManager.getInstance();
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flushing the report instance at the end of the test
        ExtentManager.getInstance().flush();
    }
}
