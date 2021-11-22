package com.lntinfotech.ExtentReport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	@Test
	void ExtentTest() {
		ExtentReports extent = new ExtentReports();
		ExtentHtmlReporter spark = new ExtentHtmlReporter("FlightBooking.html");
		extent.attachReporter(spark);
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Flight Booking");

	}

}
