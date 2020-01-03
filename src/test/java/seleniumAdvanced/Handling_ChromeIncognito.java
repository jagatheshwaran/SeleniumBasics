package seleniumAdvanced;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Handling_ChromeIncognito {

	public static void main(String[] args) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// ChromeOptions - It is used to set options for chrome browser

		// ChromeOptions instance is created
		ChromeOptions options = new ChromeOptions();

		// addArguments() - It is used to add arguments to chrome browser
		options.addArguments("incognito");

		// The below code will disable the "Chrome being controlled by automated
		// software" message
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

		// Driver instance is created
		WebDriver driver = new ChromeDriver(options);

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to automation practice testing web site
		driver.get("http://automationpractice.com/index.php");

		Thread.sleep(3000);

		// close() - This will close the Browser window
		driver.close();

	}

}
