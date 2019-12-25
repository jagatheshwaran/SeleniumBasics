/**
 * @author Jagatheshwaran
 * 
 */
package seleniumAdvanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_TextBoxSize {

	public static void main(String ar[]) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to Selenium home page
		driver.get("https://selenium.dev/");

		// getSize().getWidth() - It is used to get the web element width
		int googleSearchBtnWidth = driver.findElement(By.xpath("(//img[@class='getting-started-logo'])[1]")).getSize()
				.getWidth();
		System.out.println("Width of SeleniumWebDriverLogo : " + googleSearchBtnWidth);

		// getSize().getHeight() - It is used to get the web element height
		int googleSearchBtnHeight = driver.findElement(By.xpath("(//img[@class='getting-started-logo'])[1]")).getSize()
				.getHeight();
		System.out.println("Height of SeleniumWebDriverLogo : " + googleSearchBtnHeight);

		Thread.sleep(2000);

		// close() - It will close the Browser window
		driver.close();
	}

}
