/**
 * @author Jagatheshwaran
 * 
 */
package seleniumBasics;

//import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_GetMethod {

	public static void main(String[] args) {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - It will maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to google home page
		driver.get("https://www.google.co.in");

		// getPageSource() - It will get the current web page source
		String pagesource = driver.getPageSource();
		System.out.println("Page Source : " + pagesource);

		// getCurrentUrl() - It will get the current web page URL
		String url = driver.getCurrentUrl();
		System.out.println("URL : " + url);

		// getTitle() - It will get the current web page Title
		String title = driver.getTitle();
		System.out.println("Title : " + title);

		// getWindowHandle() - It will get the current web page Alphanumeric Id
		String windowID = driver.getWindowHandle();
		System.out.println("Window ID : " + windowID);

		// close() - It will close the Browser window
		driver.close();
	}

}
