/**
 * @author Jagatheshwaran
 * 
 */
package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Link {

	public static void main(String[] args) {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - It will maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to google home page
		driver.get("https://www.google.co.in");

		// linkText(String) - It will click the Gmail link on the web page using
		// linkText
		driver.findElement(By.linkText("Gmail")).click();

		// navigate().back() - It will navigate to previous web page
		driver.navigate().back();

		// partialLinkText(String) - It will click the Gmail link on the web page using
		// partial link text
		driver.findElement(By.partialLinkText("Gma")).click();

		// close() - It will close the Browser window
		driver.close();

	}

}
