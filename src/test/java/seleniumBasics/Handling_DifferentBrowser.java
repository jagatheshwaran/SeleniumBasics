/**
 * @author Jagatheshwaran
 * 
 */
package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Handling_DifferentBrowser {

	// Global variables declaration
	public static WebDriver driver;
	public static String browsername;
	public static int browser;

	public static void main(String[] args) {

		for (int browser = 1; browser <= 3; browser++) {
			if (browser == 1) {
				browsername = "FireFox";

				// Set the Browser Driver path
				System.setProperty("webdriver.gecko.driver", "src/main/resources/BrowserDrivers/geckodriver.exe");

				// Driver instance is created
				driver = new FirefoxDriver();

			} else if (browser == 2) {
				browsername = "Chrome";

				// Set the Browser Driver path
				System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

				// Driver instance is created
				driver = new ChromeDriver();
				driver.manage().window().maximize();

			} else if (browser == 3) {
				browsername = "Internet Explorer";

				// Set the Browser Driver path
				System.setProperty("webdriver.ie.driver", "src/main/resources/BrowserDrivers/IEDriverServer.exe");

				// Driver instance is created
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
			}

			// Based on Browser selection, get() - It will take us to the Google home page
			driver.get("https://www.google.co.in");

			// The current web page title is captured
			String title = driver.getTitle();

			// Verifying the actual captured Title of web page with expected Title
			if (title.equals("Google")) {
				System.out.println("Google Appliction Lunched in " + browsername);
			}

			// close() - It will close the current browser window
			driver.close();
		}

	}
}
