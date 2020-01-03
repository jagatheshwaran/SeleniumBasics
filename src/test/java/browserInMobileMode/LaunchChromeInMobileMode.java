package browserInMobileMode;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchChromeInMobileMode {

	public static void main(String ar[]) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Instance for HashMap created and added device into HashMap
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", "Nexus 5");

		// ChromeOptions - It is used to enable/disable options of Chrome browser

		// The below code is used to open application window in mobile mode on Chrome
		// browser
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		// Driver instance is created
		WebDriver driver = new ChromeDriver(chromeOptions);

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// navigate().to() - It will take you to google home page
		driver.navigate().to("https://www.google.com/");

		Thread.sleep(5000);

		// close() - It is used to close current browser window
		driver.close();

	}
}
