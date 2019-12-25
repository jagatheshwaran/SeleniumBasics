/**
 * @author Jagatheshwaran
 * 
 */
// Package is created as pageScrollAndZoom
package seleniumAdvanced;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Zoom {

	public static void main(String[] args) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to automation practice testing web site
		driver.get("http://automationpractice.com/index.php");

		// JavascriptExecutor is used to perform the page Zoom - it will Zoom web page
		// by 50%
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='50%'");

		Thread.sleep(3000);

		// JavascriptExecutor is used to perform the page Zoom - it will Zoom web page
		// by 100%
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='100%'");

		Thread.sleep(3000);

		// JavascriptExecutor is used to perform the page Zoom - it will Zoom web page
		// by 70%
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='70%'");

		Thread.sleep(3000);

		// JavascriptExecutor is used to perform the page Zoom - it will Zoom web page
		// by 100%
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='100%'");

		Thread.sleep(3000);

		// close() - This will close the Browser window
		driver.close();

	}

}
