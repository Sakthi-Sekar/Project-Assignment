package com.org.atmecs.reports;

import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class ExtentReport {
	public  WebDriver driver;

	public  void reportLog(String testname, String Failuremsg) {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("entendreport.html");
		ExtentReports extent = new ExtentReports();

		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest(testname);
		logger.log(Status.INFO, testname);
		logger.log(Status.PASS, testname);
		extent.flush();
	}

}