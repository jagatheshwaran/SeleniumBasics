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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FailRerunExample {

	WebDriver driver;
	String baseURL = "https://www.linkedin.com/";

	@BeforeClass
	public void setup() {

		// Provide the path of driver location
		System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		driver = new ChromeDriver();

		// To maximize Browser Window
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void verifySingInButtonText() {

		// Launching Browser with below URL
		driver.get(baseURL);

		System.out.println("Verify login page test started");
		WebElement element = driver.findElement(By.xpath("//*[contains(@class,'submit-button')]"));
		String SignInText = element.getAttribute("value");
		Assert.assertEquals(SignInText, "Sign in");
		System.out.println("Verify login page test ended");
	}

	@Test(priority = 2)
	public void verifyForgotPasswordText() {

		// Launching Browser with below URL
		driver.get(baseURL);

		System.out.println("Verify Forgot password page test started");
		WebElement element1 = driver.findElement(By.xpath("//*[contains(@class,'forgot-password')]"));
		String ForgotPasswordText = element1.getText();
		System.out.println(ForgotPasswordText);
		Assert.assertEquals(ForgotPasswordText, "Wrong text");
		System.out.println("Verify Forgot password page test ended");
	}
}
