package seleniumAdvanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandlingSSLCertificateInFirefox {

	public static void main(String[] args) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.gecko.driver", "src/main/resources/BrowserDrivers/geckodriver.exe");

		// FirefoxProfile - It is used to create new profile for firefox browser and
		// can customize the profile
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setAcceptUntrustedCertificates(true);
		firefoxProfile.setAssumeUntrustedCertificateIssuer(false);

		// DesiredCapabilities - It is used to set desired capabilities for firefox
		// browser
		DesiredCapabilities capability = new DesiredCapabilities();

		// The below code is used to handle untrusted site SSL exception
		capability.setCapability(FirefoxDriver.PROFILE, firefoxProfile);

		// FirefoxOptions - It is used to set options for firefox browser

		// FirefoxOptions instance is created
		FirefoxOptions firefoxOprions = new FirefoxOptions();

		firefoxOprions.merge(capability);

		// Driver instance is created
		WebDriver driver = new FirefoxDriver(firefoxOprions);

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to automation practice testing web site
		driver.get("https://untrusted-root.badssl.com/");

		Thread.sleep(5000);

		// close() - This will close the Browser window
		driver.close();

	}

}
