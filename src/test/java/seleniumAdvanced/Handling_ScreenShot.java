/**
 * @author Jagatheshwaran
 * 
 */
// Package is created as screenCaptureMethod
package seleniumAdvanced;

// Importing the predefined class libraries
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_ScreenShot {

	// Global Variable declaration
	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		driver = new ChromeDriver();

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to GCRIT testing site
		driver.get("http://gcrit.com/build3/");

		driver.findElement(By.linkText("login")).click();

		// takesnap() - It is used to capture the screenshot with the System nano Time
		// as Screenshot name
		Handling_ScreenShot.takesnap(driver, "./SreenShots/" + System.nanoTime() + ".png");

		Thread.sleep(2000);

		driver.findElement(By.name("email_address")).sendKeys("testjaga007@gmail.com");
		driver.findElement(By.name("password")).sendKeys("jaga@12345");
		driver.findElement(By.id("tdb5")).click();

		// takesnap() - It is used to capture the screenshot with the System nano Time
		// as Screenshot name
		Handling_ScreenShot.takesnap(driver, "./SreenShots/" + System.nanoTime() + ".png");

		Thread.sleep(2000);

		// close() - It is used to close the current browser window
		driver.close();

	}

	public static void takesnap(WebDriver driver, String filepath) throws IOException {

		// TakesScreenshot instance is created by passing Driver instance
		TakesScreenshot src = ((TakesScreenshot) driver);

		// getScreenshotAs() - It is used to create screenshot as image file
		File source = src.getScreenshotAs(OutputType.FILE);

		// Create new destination file - It is used to store the captured
		// screenshot
		File destination = new File(filepath);

		// FileUtils.copyFile - It is used to copy screenshot from source file to
		// destination file
		FileUtils.copyFile(source, destination);

	}
}
