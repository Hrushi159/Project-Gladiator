package TestScript;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

public class Searching extends startingWebBrowser {
	
	@Test(priority = 1,description = "To Test search flight using valid from City and Destination City and  date ")
	public void Flight_TC_01() throws IOException, InterruptedException {
		test = extent.createTest("Flight_TC_01 :To Test search flight using valid from City and Destination City and  date ");
		FileReader reader = new FileReader("src/test/resources/details.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		webDriver.get(link);
		webDriver.manage().window().maximize();
		webDriver.findElement(By.id("FromSector_show")).clear();

		webDriver.findElement(By.id("FromSector_show")).sendKeys(From);
		webDriver.findElement(By.id("Editbox13_show")).clear();

		webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);
		webDriver.findElement(By.id("ddate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_5_26/11/2021\"]")).click();
//

		Thread.sleep(5000);
//		WebDriverWait wait1 = new WebDriverWait(webDriver, 10);
//		WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]")));
//		element1.click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
	}

	@Test(priority = 2,description = "To Ensure that flights can not be search using the value empty from city, empty Destination City  and date")
	public void Flight_TC_02() throws IOException, InterruptedException {
		test = extent.createTest("Flight_TC_02 :To Ensure that flights can not be search using the value empty from city, empty Destination City  and date");

		FileReader reader = new FileReader("src/test/resources/details.property");

		Properties p = new Properties();
		p.load(reader);
		String link = p.getProperty("link");

		webDriver.manage().window().maximize();

		webDriver.get(link);

		webDriver.findElement(By.id("FromSector_show")).clear();
		webDriver.findElement(By.id("FromSector_show")).sendKeys(" ");
		

		webDriver.findElement(By.id("Editbox13_show")).clear();
		webDriver.findElement(By.id("Editbox13_show")).sendKeys(" ");

		Thread.sleep(5000);

		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Alert alert = webDriver.switchTo().alert();
		String popUp = webDriver.switchTo().alert().getText();
		alert.accept();

		assertEquals("Enter valid destination city", popUp);
		//assertEquals("Enter valid origin city", popUp);

		System.out.println(popUp);

	}

	@Test(priority = 3,description = " To Ensure that flight can not booked using empty from city ")
	public void Flight_TC_03() throws IOException, InterruptedException {
		test = extent.createTest("Flight_TC_03 :To Ensure that flight can not booked using empty from city ");

		FileReader reader = new FileReader("src/test/resources/details.property");

		Properties p = new Properties();
		p.load(reader);
		String link = p.getProperty("link");
		String To = p.getProperty("To");
		String From = p.getProperty("From");

		webDriver.manage().window().maximize();
		webDriver.get(link);

		webDriver.findElement(By.id("FromSector_show")).clear();
		webDriver.findElement(By.id("FromSector_show")).sendKeys(From);
		;

		webDriver.findElement(By.id("Editbox13_show")).clear();
		webDriver.findElement(By.id("Editbox13_show")).sendKeys(" ");

		Thread.sleep(5000);

		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Alert alert2 = webDriver.switchTo().alert();
		String popUp2 = webDriver.switchTo().alert().getText();
		alert2.accept();


		assertEquals("Enter valid destination city", popUp2);
		System.out.println(popUp2);
		Thread.sleep(3000);

	}
	@Test(priority = 4,description = "To Ensure that flight can not booked using empty To block ")
	public void Flight_TC_04() throws IOException, InterruptedException {
		test = extent.createTest("Flight_TC_04 :To Ensure that flight can not booked using empty To block ");

		FileReader reader = new FileReader("src/test/resources/details.property");

		Properties p = new Properties();
		p.load(reader);
		String link = p.getProperty("link");
		String To = p.getProperty("To");
		String From = p.getProperty("From");
		webDriver.manage().window().maximize();
		webDriver.get(link);

		webDriver.findElement(By.id("FromSector_show")).clear();
		webDriver.findElement(By.id("FromSector_show")).sendKeys(" ");
		webDriver.findElement(By.id("FromSector_show")).click();

		;

		webDriver.findElement(By.id("Editbox13_show")).clear();
		webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);

		Thread.sleep(5000);

		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Alert alert3 = webDriver.switchTo().alert();
		String popUp3 = webDriver.switchTo().alert().getText();
		alert3.accept();


		//assertEquals("Enter valid destination city", popUp3);
		assertEquals("Enter valid origin city", popUp3);

		System.out.println(popUp3);
		Thread.sleep(3000);

	}
	
	@Test(priority = 5,description = "To Ensure that flight can not booked using empty To block ")
	public void Flight_TC_05() throws IOException, InterruptedException {
		test = extent.createTest("Flight_TC_05 :To Ensure that flight can not booked using empty To block ");

		FileReader reader = new FileReader("src/test/resources/details.property");

		Properties p = new Properties();
		p.load(reader);
		String link = p.getProperty("link");
		String To = p.getProperty("To");
		String From = p.getProperty("From");
		webDriver.manage().window().maximize();
		webDriver.get(link);

		webDriver.findElement(By.id("FromSector_show")).clear();
		webDriver.findElement(By.id("FromSector_show")).sendKeys(" ");
		webDriver.findElement(By.id("FromSector_show")).click();

		;

		webDriver.findElement(By.id("Editbox13_show")).clear();
		webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);

		Thread.sleep(5000);

		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Alert alert3 = webDriver.switchTo().alert();
		String popUp3 = webDriver.switchTo().alert().getText();
		alert3.accept();


		//assertEquals("Enter valid destination city", popUp3);
		assertEquals("Enter valid  city", popUp3);

		System.out.println(popUp3);
		Thread.sleep(3000);

	}
	@Test(priority = 6,description = "To verify Traveller details with valid title,firstName,LastName And phone number")
	public void Book_TC_04() throws IOException, InterruptedException {
		test = extent.createTest("Book_TC_04:To verify Traveller details with valid title,firstName,LastName And phone number");

		FileReader reader = new FileReader("src/test/resources/details.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		String mail = p.getProperty("mail");
		String fname = p.getProperty("firstname");
		String lname=p.getProperty("lastname");
		String mob=p.getProperty("mobile");
		webDriver.manage().window().maximize();

		webDriver.get(link);
		webDriver.findElement(By.id("FromSector_show")).clear();

		webDriver.findElement(By.id("FromSector_show")).sendKeys(From);
		webDriver.findElement(By.id("Editbox13_show")).clear();

		webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);
		webDriver.findElement(By.id("ddate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_5_26/11/2021\"]")).click();
		//

		Thread.sleep(5000);
//			WebDriverWait wait1//			webDriver.findElement(By.id("titleAdult4")).click();
//= new WebDriverWait(webDriver, 10);
//			WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]")));
//			element1.click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		webDriver.findElement(By.xpath("//*[@id=\"ResultDiv\"]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]"))
				.sendKeys(Keys.ENTER);

		webDriver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span")).click();
		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).clear();

		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).sendKeys(mail);
		webDriver.findElement(By.xpath("//*[@id=\"spnVerifyEmail\"]")).click();
		webDriver.findElement(By.xpath("//option[@value='Mr']")).click();
		webDriver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).sendKeys(fname);
		webDriver.findElement(By.xpath("//input[@placeholder='Enter Last Name']")).sendKeys(lname);
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).sendKeys(mob);
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//div[@class='con1']")).click();

		Thread.sleep(5000);
	}
	@Test(priority = 7,description = "To test Book Flight using valid mail id")
	void Book_TC_02() throws IOException, InterruptedException {
		test = extent.createTest("Book_TC_02: To test Book Flight using valid mail id");

			FileReader reader = new FileReader("src/test/resources/details.property");

			Properties p = new Properties();
			p.load(reader);
			String From = p.getProperty("From");
			String To = p.getProperty("To");
			String link = p.getProperty("link");
			String mail = p.getProperty("mail");
			String fname = p.getProperty("firstname");
			String lname=p.getProperty("lastname");
			String mob=p.getProperty("mobile");
			webDriver.manage().window().maximize();

			webDriver.get(link);
			webDriver.findElement(By.id("FromSector_show")).clear();

			webDriver.findElement(By.id("FromSector_show")).sendKeys(From);
			webDriver.findElement(By.id("Editbox13_show")).clear();

			webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);
			webDriver.findElement(By.id("ddate")).click();
			webDriver.findElement(By.xpath("//*[@id=\"frth_5_26/11/2021\"]")).click();
			//

			Thread.sleep(5000);
//				WebDriverWait wait1//			webDriver.findElement(By.id("titleAdult4")).click();
	//= new WebDriverWait(webDriver, 10);
//				WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]")));
//				element1.click();
			webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
					.sendKeys(Keys.ENTER);
			Thread.sleep(10000);
			webDriver.findElement(By.xpath("//*[@id=\"ResultDiv\"]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]"))
					.sendKeys(Keys.ENTER);

			webDriver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span")).click();
			webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).clear();

			webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).sendKeys(mail);
			webDriver.findElement(By.xpath("//*[@id=\"spnVerifyEmail\"]")).click();
		
	}
	@Test(priority = 8,description = "To test Book Flight using invalid mail id")
	void Book_Tc_03() throws InterruptedException, IOException {
		test = extent.createTest("Book_TC_03: To test Book Flight using invalid mail id");

		FileReader reader = new FileReader("src/test/resources/details.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		String mail = p.getProperty("mail");
		String fname = p.getProperty("firstname");
		String lname=p.getProperty("lastname");
		String mob=p.getProperty("mobile");
		String invalidMail = p.getProperty("invalidmail");
		webDriver.manage().window().maximize();

		webDriver.get(link);
		webDriver.findElement(By.id("FromSector_show")).clear();

		webDriver.findElement(By.id("FromSector_show")).sendKeys(From);
		webDriver.findElement(By.id("Editbox13_show")).clear();

		webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);
		webDriver.findElement(By.id("ddate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_5_26/11/2021\"]")).click();
		//

		Thread.sleep(5000);
//			WebDriverWait wait1//			webDriver.findElement(By.id("titleAdult4")).click();
//= new WebDriverWait(webDriver, 10);
//			WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]")));
//			element1.click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		webDriver.findElement(By.xpath("//*[@id=\"ResultDiv\"]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]"))
				.sendKeys(Keys.ENTER);

		webDriver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span")).click();
		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).clear();

		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).sendKeys(invalidMail);
		webDriver.findElement(By.xpath("//*[@id=\"spnVerifyEmail\"]")).click();
		WebElement invalid = webDriver.findElement(By.xpath("/html/body/form/div[11]/div[6]/div[1]/div[4]/div[2]/div[1]/form/div[1]/div[3]/span[2]"));
		String in = invalid.getText();
		assertEquals("Please enter a valid email Id", in);
	
		
	}
	@Test(priority = 9,description = "To Verify Traveller details without details")
	void Book_TC_05() throws IOException, InterruptedException {
		test = extent.createTest("Book_TC_05: To Verify Traveller details without details");

		FileReader reader = new FileReader("src/test/resources/details.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		String mail = p.getProperty("mail");
		String fname = p.getProperty("firstname");
		String lname=p.getProperty("lastname");
		String mob=p.getProperty("mobile");
		String invalidMail = p.getProperty("invalidmail");
		
		webDriver.manage().window().maximize();

		webDriver.get(link);
		webDriver.findElement(By.id("FromSector_show")).clear();

		webDriver.findElement(By.id("FromSector_show")).sendKeys(From);
		webDriver.findElement(By.id("Editbox13_show")).clear();

		webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);
		webDriver.findElement(By.id("ddate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_5_26/11/2021\"]")).click();
		//

		Thread.sleep(5000);
//			WebDriverWait wait1//			webDriver.findElement(By.id("titleAdult4")).click();
//= new WebDriverWait(webDriver, 10);
//			WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]")));
//			element1.click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		webDriver.findElement(By.xpath("//*[@id=\"ResultDiv\"]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]"))
				.sendKeys(Keys.ENTER);

		webDriver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span")).click();
		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).clear();

		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).sendKeys(mail);
		webDriver.findElement(By.xpath("//*[@id=\"spnVerifyEmail\"]")).click();
		//webDriver.findElement(By.xpath("//a[@class='add_adlt']")).click();
		Thread.sleep(3000);
//		webDriver.findElement(By.xpath("//option[@value='Mr']")).click();
//		webDriver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).sendKeys("aron");
//		webDriver.findElement(By.xpath("//input[@placeholder='Enter Last Name']")).sendKeys("finch");
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).clear();//clear phone no
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//div[@class='con1']")).click();
		WebElement mob1 = webDriver.findElement(By.xpath("/html/body/form/div[11]/div[6]/div[1]/div[4]/div[2]/form/div/div[3]/div[3]/span[2]"));
		String m1 = mob1.getText();
		assertEquals("Please enter a valid mobile number", m1);

		Thread.sleep(5000);
	}
	@Test(priority = 10,description = "To Verify Travellrr Detail withoud Entering Title")
	void Book_TC_06() throws IOException, InterruptedException {
		test = extent.createTest("Book_TC_06: To Verify Travellrr Detail withoud Entering Title");

		FileReader reader = new FileReader("src/test/resources/details.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		String mail = p.getProperty("mail");
		String fname = p.getProperty("firstname");
		String lname=p.getProperty("lastname");
		String mob=p.getProperty("mobile");
		String invalidMail = p.getProperty("invalidmail");
		webDriver.manage().window().maximize();

		webDriver.get(link);
		webDriver.findElement(By.id("FromSector_show")).clear();

		webDriver.findElement(By.id("FromSector_show")).sendKeys(From);
		webDriver.findElement(By.id("Editbox13_show")).clear();

		webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);
		webDriver.findElement(By.id("ddate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_5_26/11/2021\"]")).click();
		//

		Thread.sleep(5000);
//			WebDriverWait wait1//			webDriver.findElement(By.id("titleAdult4")).click();
//= new WebDriverWait(webDriver, 10);
//			WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]")));
//			element1.click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(12000);
		webDriver.findElement(By.xpath("//*[@id=\"ResultDiv\"]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]"))
				.sendKeys(Keys.ENTER);

		webDriver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span")).click();
		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).clear();

		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).sendKeys(mail);
		webDriver.findElement(By.xpath("//*[@id=\"spnVerifyEmail\"]")).click();
		Thread.sleep(12000);

		//webDriver.findElement(By.xpath("//a[@class='add_adlt']")).click();
//		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"titleAdult1\"]")));
//		Select drpdwn = new Select(webDriver.findElement(By.xpath("//*[@id=\"titleAdult1\"]")));
//		drpdwn.deselectAll();
		webDriver.findElement(By.xpath("//*[@id=\"mycheckbox\"]")).click();
		webDriver.findElement(By.xpath("//*[@id=\"titleAdult0\"]/option[1]")).click();
		//webDriver.findElement(By.xpath("//option[@value xpath='1']")).click();//clicking Title option
		webDriver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).sendKeys(" ");
		webDriver.findElement(By.xpath("//input[@placeholder='Enter Last Name']")).sendKeys(" ");
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).clear();//clear phone no
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).sendKeys(mob);//clear phone no

		webDriver.findElement(By.xpath("//div[@class='con1']")).click();
		WebElement mob2= webDriver.findElement(By.xpath("//*[@id=\"spanErrorAdult0\"]"));
		String m1 = mob2.getText();
		assertEquals("Adult 1 title is required", m1);

		Thread.sleep(5000);
	}
	@Test(priority = 11,description = "To verify Travellor details without Entering First Name")
	void Book_TC_07() throws IOException, InterruptedException {
		test = extent.createTest("Book_TC_07: To verify Travellor details without Entering First Name");

		FileReader reader = new FileReader("src/test/resources/details.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		String mail = p.getProperty("mail");
		String fname = p.getProperty("firstname");
		String lname=p.getProperty("lastname");
		String mob=p.getProperty("mobile");
		String invalidMail = p.getProperty("invalidmail");
		webDriver.manage().window().maximize();

		webDriver.get(link);
		webDriver.findElement(By.id("FromSector_show")).clear();

		webDriver.findElement(By.id("FromSector_show")).sendKeys(From);
		webDriver.findElement(By.id("Editbox13_show")).clear();

		webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);
		webDriver.findElement(By.id("ddate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_5_26/11/2021\"]")).click();
		//

		Thread.sleep(5000);
//			WebDriverWait wait1//			webDriver.findElement(By.id("titleAdult4")).click();
//= new WebDriverWait(webDriver, 10);
//			WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]")));
//			element1.click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		webDriver.findElement(By.xpath("//*[@id=\"ResultDiv\"]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]"))
				.sendKeys(Keys.ENTER);

		webDriver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span")).click();
		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).clear();

		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).sendKeys(mail);
		webDriver.findElement(By.xpath("//*[@id=\"spnVerifyEmail\"]")).click();
		Thread.sleep(12000);

		//webDriver.findElement(By.xpath("//a[@class='add_adlt']")).click();
//		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"titleAdult1\"]")));
//		Select drpdwn = new Select(webDriver.findElement(By.xpath("//*[@id=\"titleAdult1\"]")));
//		drpdwn.deselectAll();
		webDriver.findElement(By.xpath("//*[@id=\"mycheckbox\"]")).click();
		webDriver.findElement(By.xpath("//*[@id=\"titleAdult0\"]/option[2]")).click();
		//webDriver.findElement(By.xpath("//option[@value xpath='1']")).click();//clicking Title option
		webDriver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).clear();
		webDriver.findElement(By.xpath("//input[@placeholder='Enter Last Name']")).sendKeys(" ");
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).clear();//clear phone no
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).sendKeys(mob);//clear phone no

		webDriver.findElement(By.xpath("//div[@class='con1']")).click();
		WebElement mob3 = webDriver.findElement(By.xpath("//span[@id='spanErrorAdult0']"));
		String m1 = mob3.getText();
		assertEquals("Adult 1 First Name should have minimum 1", m1);

		Thread.sleep(5000);
	}
	@Test(priority = 12,description = "To verify Travellor Details withoud Entering Last Name")
	void Book_TC_08() throws IOException, InterruptedException {
		test = extent.createTest("Book_TC_08: To verify Travellor Details withoud Entering Last Name");

		FileReader reader = new FileReader("src/test/resources/details.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		String mail = p.getProperty("mail");
		String fname = p.getProperty("firstname");
		String lname=p.getProperty("lastname");
		String mob=p.getProperty("mobile");
		String invalidMail = p.getProperty("invalidmail");
		webDriver.manage().window().maximize();

		webDriver.get(link);
		webDriver.findElement(By.id("FromSector_show")).clear();

		webDriver.findElement(By.id("FromSector_show")).sendKeys(From);
		webDriver.findElement(By.id("Editbox13_show")).clear();

		webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);
		webDriver.findElement(By.id("ddate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_5_26/11/2021\"]")).click();
		//

		Thread.sleep(5000);
//			WebDriverWait wait1//			webDriver.findElement(By.id("titleAdult4")).click();
//= new WebDriverWait(webDriver, 10);
//			WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]")));
//			element1.click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		webDriver.findElement(By.xpath("//*[@id=\"ResultDiv\"]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]"))
				.sendKeys(Keys.ENTER);

		webDriver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span")).click();
		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).clear();

		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).sendKeys(mail);
		webDriver.findElement(By.xpath("//*[@id=\"spnVerifyEmail\"]")).click();
		Thread.sleep(12000);

		//webDriver.findElement(By.xpath("//a[@class='add_adlt']")).click();
//		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"titleAdult1\"]")));
//		Select drpdwn = new Select(webDriver.findElement(By.xpath("//*[@id=\"titleAdult1\"]")));
//		drpdwn.deselectAll();
		webDriver.findElement(By.xpath("//*[@id=\"mycheckbox\"]")).click();
		webDriver.findElement(By.xpath("//*[@id=\"titleAdult0\"]/option[2]")).click();
		//webDriver.findElement(By.xpath("//option[@value xpath='1']")).click();//clicking Title option
		webDriver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).clear();
		webDriver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).sendKeys(fname);

		webDriver.findElement(By.xpath("//input[@placeholder='Enter Last Name']")).clear();
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).clear();//clear phone no
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).sendKeys(mob);//clear phone no

		webDriver.findElement(By.xpath("//div[@class='con1']")).click();
		WebElement mob4 = webDriver.findElement(By.xpath("//span[@id='spanErrorAdult0']"));
		String m1 = mob4.getText();
		assertEquals("Adult 1 Last Name should have minimum 1character.", m1);

		Thread.sleep(5000);
	}
	
	@AfterMethod
	 public void tearDown(ITestResult result) throws IOException {
	  if (result.getStatus() == ITestResult.FAILURE) {
	   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
	   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
	String screenshotPath = Searching.getScreenshot(webDriver, result.getName());
	   test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
	  } else if (result.getStatus() == ITestResult.SKIP) {
	   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
	  }
	  else if (result.getStatus() == ITestResult.SUCCESS) {
	   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
	  }
	 }
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  
		  // after execution, you could see a folder "FailedTestsScreenshots" under src folder
		  String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		  File finalDestination = new File(destination);
		  
		  FileUtils.copyFile(source, finalDestination);

		  return destination;
		 }

 


	

}
