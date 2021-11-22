package TestScript;


import javax.swing.text.html.HTMLDocument.HTMLReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

class startingWebBrowser {
	static WebDriver webDriver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeTest
	public void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver\\chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		webDriver = new ChromeDriver(op);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/FligthBooking.html");
		htmlReporter.config().setDocumentTitle("Booking Flights");

		htmlReporter.config().setReportName("Flight Booking");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("os", "Windows10");
		extent.setSystemInfo("Tester Name", "Hrushikesh Bhelerao");
		extent.setSystemInfo("Browser", "Chrome");
		
		
	}

	@AfterTest
	public void tearDownAfterClass() throws Exception {
	extent.flush();	
	Thread.sleep(2000);
	webDriver.quit();
	}

}

