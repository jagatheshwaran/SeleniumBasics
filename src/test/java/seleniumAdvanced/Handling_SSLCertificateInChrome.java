package seleniumAdvanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Handling_SSLCertificateInChrome {

	public static void main(String[] args) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// ChromeOptions - It is used to set options for chrome browser

		// ChromeOptions instance is created
		ChromeOptions options = new ChromeOptions();

		// DesiredCapabilities - It is used to set desired capabilities for chrome
		// browser
		DesiredCapabilities capability = new DesiredCapabilities();

		// The below code is used to handle untrusted site SSL exception
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		options.merge(capability);

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to automation practice testing web site
		driver.get("https://untrusted-root.badssl.com/");

		Thread.sleep(3000);

		// close() - This will close the Browser window
		driver.close();

	}

}
