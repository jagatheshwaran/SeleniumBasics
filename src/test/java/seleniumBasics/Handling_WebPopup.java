/**
 * @author Jagatheshwaran
 * 
 */
package seleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_WebPopup {

	public static void main(String[] args) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - It will maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to rediff mail login page
		driver.get("http://www.rediffmail.com/cgi-bin/login.cgi");

		driver.findElement(By.name("proceed")).click();

		// Alert interface is used to handle Web based Pop-ups
		// switchTo().alert() - It is used to switch from normal window to alert pop up
		// window
		Alert alertobj = driver.switchTo().alert();

		// The bellow code will fetch the warning message text from alert pop up
		String warning = alertobj.getText();
		System.out.println("Warning Message from pop up : " + warning);

		// The below code will accept the alert pop up
		alertobj.accept();

		// It will explicitly wait for specified mill seconds
		Thread.sleep(3000);

		// close() - It will close the Browser window
		driver.close();
	}

}
