package com.saurabhAPIAuto.tests.extendDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentTest test;

    public static ExtentReports getInstance(){

        if(extent == null){
            htmlReporter = new ExtentHtmlReporter("extentReport.html");
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setDocumentTitle("Automation Report");
            htmlReporter.config().setReportName("Test Report");


            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("OS", "Windows 11");
            extent.setSystemInfo("Testing", "Saurabh");
        }

        return extent;
    }
    public static ExtentTest createTest(String name, String description){
        test = extent.createTest(name, description);
        return test;
    }



}
