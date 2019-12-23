/**
 * @author Jagatheshwaran
 * 
 */
package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Image {

	public static void main(String[] args) {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - It will maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to google home page
		driver.get("https://www.google.co.in");

		// The below code will check the Google logo image
		driver.findElement(By.xpath("//div[@id='hplogo']//a//img")).isDisplayed();

		// navigate().to() - It will redirect to the below web page
		driver.navigate().to("http://newtours.demoaut.com/");

		// The below code will click image Sign In button
		driver.findElement(By.xpath("//input[@type='image' and @name='login']")).click();

		// navigate().to() - It will redirect to the below web page
		driver.navigate().to("https://selenium.dev/");

		// The below code will click image Browser stack link
		driver.findElement(By.xpath("//img[@class='backer-logo' and @src='/images/sponsors/browserstack.png']"))
				.click();

		// close() - It will close the Browser window
		driver.close();

	}

}
