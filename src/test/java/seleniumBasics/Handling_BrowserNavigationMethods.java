/**
 * @author Jagatheshwaran
 * 
 */
package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_BrowserNavigationMethods {

	public static void main(String[] args) {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to Amazon site
		driver.get("https://www.amazon.in/");

		// getCurrentUrl() - It will get the current web page's URL
		String url = driver.getCurrentUrl();
		System.out.println(url);

		// navigate().to() - It will navigate to the Flipkart site from Amazon site
		driver.navigate().to("https://www.flipkart.com/");

		String url1 = driver.getCurrentUrl();
		System.out.println(url1);

		// navigate().back() - It will navigate back to the Amazon site from Flipkart
		// site
		driver.navigate().back();
		String url2 = driver.getCurrentUrl();
		System.out.println(url2);

		// navigate().forward() - It will navigate forward to the Flipkart site
		driver.navigate().forward();
		String url3 = driver.getCurrentUrl();
		System.out.println(url3);

		// navigate().refresh() - It will refresh the current web page
		driver.navigate().refresh();
		String url4 = driver.getCurrentUrl();
		System.out.println(url4);

		// close() - It will close the current browser window
		driver.close();
	}

}