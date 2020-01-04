package pdfEmailReport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * @author Jagatheshwaran
 *
 */
public class takeSnapShot {

	public static WebDriver driver;

	/**
	 * This function will get Driver instance
	 *
	 */
	public static WebDriver getDriver() {

		try {

			if (driver == null) {
				System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
		} catch (Exception e) {
			System.out.println("Exception Occured while Invoking Driver : " + e);
		}

		return driver;
	}

	/**
	 * This function will take screenshot
	 * 
	 * @param webdriver
	 * @param filePath
	 * @throws Exception
	 */
	public static void takeSnap(WebDriver driver, String filePath) throws IOException {
		try {

			File destination = new File(filePath);
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, destination);
			System.out.println("Failed Test Case Snap Captured!");
		} catch (Exception e) {
			filePath = null;
			System.out.println("Exception Occured while taking Snap : " + e);
		}
	}

}
