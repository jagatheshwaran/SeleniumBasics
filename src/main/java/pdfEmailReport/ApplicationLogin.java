package pdfEmailReport;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author Jagatheshwaran
 */

// The below line will listen test execution
@Listeners(PdfReportListener.class)
public class ApplicationLogin extends takeSnapShot {

	// The global variable is declared
	public static WebDriver driver = takeSnapShot.getDriver();

	@Test(priority = 1)
	public static void registerToApplication() {

		// Maximize Browser window
		driver.manage().window().maximize();

		// Launching the browser with the below url
		driver.get("http://www.gcrit.com/build3/login.php");

		driver.findElement(By.xpath("//a[@id='tdb4']")).click();

		driver.findElement(By.xpath("//input[@name='gender' and @value='m']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Jaga");
		driver.findElement(By.name("lastname")).sendKeys("Waran");
		driver.findElement(By.name("dob")).sendKeys("01/21/2019");
		driver.findElement(By.name("email_address")).sendKeys("jagathesh5987@gmail.com");
		driver.findElement(By.name("street_address")).sendKeys("MGRStreet");
		driver.findElement(By.name("postcode")).sendKeys("123456");
		driver.findElement(By.name("city")).sendKeys("Chennai");
		driver.findElement(By.name("state")).sendKeys("TamilNadu");
		Select selectObj = new Select(driver.findElement(By.name("country")));
		selectObj.selectByVisibleText("India");
		driver.findElement(By.name("telephone")).sendKeys("1234567890");
		driver.findElement(By.name("password")).sendKeys("jaga@123");
		driver.findElement(By.name("confirmation")).sendKeys("jaga@123");
		driver.findElement(By.xpath("//span[contains(@class,'buttonAction')]")).click();

		String ActualUrl = driver.getCurrentUrl();
		String ExpectedUrl = "http://www.gcrit.com/build3/create_account_success.php";

		if (ActualUrl.contains(ExpectedUrl)) {
			System.out.println("The Account has been Registered and Created Successfully");
			Assert.assertEquals(ActualUrl, ExpectedUrl);

		} else {
			System.out.println("The Account has not been Registered and Created");
			Assert.assertEquals(ActualUrl, ExpectedUrl);

		}

	}

	@Test(priority = 2)
	public static void loginToApplication() {

		/*
		 * // Driver instance created driver = takeSnapShot.getDriver();
		 */

		// Maximize Browser window
		driver.manage().window().maximize();

		// Launching the browser with the below url
		driver.get("http://www.gcrit.com/build3/login.php");

		driver.findElement(By.name("email_address")).sendKeys("jagathesh123@gmail.com");
		driver.findElement(By.name("password")).sendKeys("jaga@1234");
		driver.findElement(By.id("tdb5")).click();

		// Capturing the Current page url
		String url = driver.getCurrentUrl();
		String expectedUrl = "http://www.gcrit.com/build3/index.php";

		// Verifying the captured url
		if (url.contains("http://www.gcrit.com/build3/index.php")) {

			System.out.println("Login Successful - Passed");
			Assert.assertEquals(url, expectedUrl);

		} else {

			System.out.println("Login Unsuccessful - Failed");
			Assert.assertEquals(url, expectedUrl);
		}

	}

	@AfterTest
	public void tearDown() throws IOException, InterruptedException {

		// The below line will close the browser window
		driver.close();

		PdfGeneration.sendPDFReportByMail("FromEmail", "Password", "ToEmail",
				"Test Execution Report", "Please find the test execution report");
	}

}
