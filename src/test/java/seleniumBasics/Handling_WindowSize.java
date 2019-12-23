/**
 * @author Jagatheshwaran
 * 
 */
package seleniumBasics;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_WindowSize {

	public static void main(String ar[]) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// get() - It will take you to Git hub login page
		driver.get("https://github.com/jagatheshwaran");

		// manage().window().getSize() - It is used to get the actual window size
		Dimension windowSize = driver.manage().window().getSize();
		System.out.println("Actaul Window Size " + windowSize);

		// manage().window().maximize() - It will maximize Browser Window
		driver.manage().window().maximize();

		// It will explicitly wait for specified mill seconds
		Thread.sleep(2000);

		// manage().window().setSize(dimension) - It is used to set the desired size of
		// window based on requirement
		Dimension dimension = new Dimension(800, 600);
		driver.manage().window().setSize(dimension);

		// It will explicitly wait for specified mill seconds
		Thread.sleep(2000);

		// close() - It will close the Browser window
		driver.close();
	}
}
