/**
 * @author Jagatheshwaran
 * 
 */
package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

public class Handling_ColorOfWebElement {

	public static void main(String ar[]) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to github web site
		driver.get("https://github.com/jagatheshwaran");

		// The below set of codes will check the SignUp button color displayed on the web page

		String expectedSignUpButtonBGColor = "rgba(40, 167, 69, 1)";

		// getCssValue() - It will fetch the color CSS value of the element on the web page
		String actualSignUpButtonBGColor = driver.findElement(By.xpath("//*[contains(@class,'btn-primary')]"))
				.getCssValue("background-color");

		System.out.println(actualSignUpButtonBGColor);

		// Assert.assertEquals() - It will check the actual and expected results, if
		// they are not equal, it will print the message
		Assert.assertEquals(actualSignUpButtonBGColor, expectedSignUpButtonBGColor,
				"The SignUp button color is not correct");

		// Thread.sleep() - It will explicitly wait for specified mill seconds
		Thread.sleep(5000);

		// close() - close the Browser window
		driver.close();

	}
}
