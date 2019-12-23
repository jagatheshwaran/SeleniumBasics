/**
 * @author Jagatheshwaran
 * 
 */
package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Handling_MouseOver {

	public static void main(String[] args) {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - It will maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to CarMax site
		driver.get("http://www.carmax.com/");

		// The Actions class is used to handle the mouse hand over operations

		// Instance of Actions class is created with driver instance
		Actions builder = new Actions(driver);

		// Actions class is used to handle the mouse hover operation
		WebElement menu = driver.findElement(By.xpath("//span[@class='header-helpful-links-title']"));

		// The below code will movwe to the above web element and hover on it
		builder.moveToElement(menu).build().perform();

		// The below code will click link from mouse hover options
		driver.findElement(By.xpath("//a[@class='header-link'][text()='Why CarMax?']")).click();

		// close() - It will close the Browser window
		driver.close();
	}

}
