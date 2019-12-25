/**
 * @author Jagatheshwaran
 * 
 */
package seleniumAdvanced;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Coordinates {

	public static void main(String ar[]) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// get() - It will take you to Google Web site
		driver.get("https://www.google.com/");

		// manage().window().getPosition() - It is used to fetch the x and y coordinates
		// of the window
		Point point = driver.manage().window().getPosition();
		System.out.println("X coordinate of Screen before maximize " + point.getX());
		System.out.println("Y coordinate of Screen before maximize " + point.getY());

		Thread.sleep(2000);

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// manage().window().getPosition() - It is used to fetch the x and y coordinates
		// of the window
		Point point1 = driver.manage().window().getPosition();
		System.out.println("X coordinate of Screen " + point1.getX());
		System.out.println("Y coordinate of Screen " + point1.getY());
		Thread.sleep(2000);

		// getLocation() - It is used to fetch the x and y coordinates of web element
		Point pointElement = driver.findElement(By.xpath("//input[@name='q']")).getLocation();
		System.out.println("X coordinate of Google search bar " + pointElement.getX());
		System.out.println("Y coordinate of Google search bar " + pointElement.getY());
		Thread.sleep(2000);

		// close() - It will close the Browser window
		driver.close();
	}

}
