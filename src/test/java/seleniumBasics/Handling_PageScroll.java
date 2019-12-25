/**
 * @author Jagatheshwaran
 * 
 */
// Package is created as pageScrollAndZoom
package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_PageScroll {

	public static void main(String[] args) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - It will maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to automation practice web site
		driver.get("http://automationpractice.com/index.php");

		// JavascriptExecutor is used to perform the page scroll related operations

		// window.scrollTo(0,document.body.scrollHeight) - It will scroll down to
		// bottom of the page
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

		// It will explicitly wait for specified mill seconds
		Thread.sleep(2000);

		// window.scrollTo(0,-document.body.scrollHeight) - It will scroll up to top of the page
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,-document.body.scrollHeight)");

		// It will explicitly wait for specified mill seconds
		Thread.sleep(2000);

		// window.scrollBy(0,500) - It will scroll to fixed position towards bottom of
		// page from top
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");

		// It will explicitly wait for specified mill seconds
		Thread.sleep(2000);

		// window.scrollBy(0,-200) - It will scroll to fixed position towards top of
		// page from bottom
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-200)");

		// It will explicitly wait for specified mill seconds
		Thread.sleep(2000);

		// arguments[0].scrollIntoView(true) - It will scroll to the particular web
		// element on the web page
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver
				.findElement(By.xpath(".//*[@id='homefeatured']//a[contains(text(),'Faded Short Sleeve T-shirts')]")));

		// close() - This will close the Browser window
		driver.close();

	}

}
