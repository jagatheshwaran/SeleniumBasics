/**
 * @author Jagatheshwaran
 * 
 */
package seleniumAdvanced;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_HighLighter {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to Google Web site
		driver.get("https://www.google.com/");

		WebElement googleSearchBar = driver.findElement(By.name("q"));
		Handling_HighLighter.highLightElement(driver, googleSearchBar);
		googleSearchBar.sendKeys("selenium");

		Thread.sleep(2000);

		// close() - It will close the current browser window
		driver.close();
	}

	// HighLighter function - It used to high light the web element on the web page
	// before perform operations on it
	public static void highLightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid green;');",
				element);
	}
}
