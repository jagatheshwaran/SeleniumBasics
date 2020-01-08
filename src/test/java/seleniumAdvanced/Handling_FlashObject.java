package seleniumAdvanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Flash.FlashObjectWebDriver;

public class Handling_FlashObject {

	public static void main(String[] args) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		FlashObjectWebDriver flash = new FlashObjectWebDriver(driver, "myFlashMovie");
		// Pass the URL of video
		driver.get("http://demo.guru99.com/test/flash-testing.html");
		Thread.sleep(5000);
		flash.callFlashObject("Play");
		Thread.sleep(5000);
		flash.callFlashObject("StopPlay");
		Thread.sleep(5000);
		flash.callFlashObject("SetVariable", "/:message", "Flash testing using selenium Webdriver");
		System.out.println(flash.callFlashObject("GetVariable", "/:message"));
	}

}
