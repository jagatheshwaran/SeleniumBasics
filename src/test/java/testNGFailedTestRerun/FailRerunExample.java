/**
 * @author Jagatheshwaran
 * 
 */
package testNGFailedTestRerun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FailRerunExample {

	WebDriver driver;
	String baseURL = "https://www.linkedin.com/";

	@BeforeClass
	public void setup() {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		driver = new ChromeDriver();

		// manage().window().maximize() - To Maximize Browser Window
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void verifySingInButtonText() throws InterruptedException {

		// get() - It will take you to linked in site
		driver.get(baseURL);
		Thread.sleep(3000);
		System.out.println("Verify login page test started");
		WebElement element = driver.findElement(By.xpath("//button[contains(@class,'sign-in-form__submit-btn')]"));
		String SignInText = element.getText();
		Assert.assertEquals(SignInText, "Sign in");
		System.out.println("Verify login page test ended");

	}

	@Test(priority = 2)
	public void verifyForgotPasswordText() throws InterruptedException {

		// get() - It will take you to linked in site
		driver.get(baseURL);
		Thread.sleep(3000);
		System.out.println("Verify Forgot password page test started");
		WebElement element1 = driver.findElement(By.xpath("//a[contains(@class,'sign-in-form__forgot-password')]"));
		String ForgotPasswordText = element1.getText();
		Assert.assertEquals(ForgotPasswordText, "Wrong text");
		System.out.println("Verify Forgot password page test ended");
	}

	@AfterClass
	public void teardown() {
		driver.close();

	}

}
