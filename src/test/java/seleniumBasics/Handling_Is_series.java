/**
 * @author Jagatheshwaran
 * 
 */
package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Is_series {

	public static void main(String[] args) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - It will maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to google home page
		driver.get("https://www.google.co.in");

		// isEnabled() - It will check whether the Web element is enabled on the web
		// page
		boolean enabled = driver.findElement(By.xpath("//input[@name='q']")).isEnabled();
		System.out.println("Web Element Enabled : " + enabled);

		// isDisplayed()- It will check whether the Web element is displayed on the web
		// page
		boolean displayed = driver.findElement(By.xpath("//input[@name='q']")).isDisplayed();
		System.out.println("Web Element Displayed : " + displayed);

		// get() - It will navigate to the below html page
		driver.get("D:\\ECLIPSE_ENV\\Workspace\\SeleniumBasics\\src\\test\\resources\\TestFiles\\checkbox.html");

		// isSelected() - It will check whether the Web element is selected on the web
		// page
		boolean selected = driver.findElement(By.name("option2")).isSelected();
		System.out.println("Web Element Selected : " + selected);

		// The below code will explicitly wait for specified mill seconds
		Thread.sleep(5000);

		// close() - It will close the Browser window
		driver.close();

	}

}
