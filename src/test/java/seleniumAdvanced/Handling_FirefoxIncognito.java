package seleniumAdvanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Handling_FirefoxIncognito {

	public static void main(String[] args) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.gecko.driver", "src/main/resources/BrowserDrivers/geckodriver.exe");

		// FireFoxProfile instance is created
		FirefoxProfile firefoxProfile = new FirefoxProfile();

		// setPreference() - It is used to set preference for firefox browser
		firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);

		// FireFoxOptions instance is created
		FirefoxOptions option = new FirefoxOptions();

		// setProfile() - It is used to set the custom firefox profile
		option.setProfile(firefoxProfile);

		// Driver instance is created
		WebDriver driver = new FirefoxDriver(option);

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to automation practice testing web site
		driver.get("http://automationpractice.com/index.php");

		Thread.sleep(3000);

		// close() - This will close the Browser window
		driver.close();

	}

}
