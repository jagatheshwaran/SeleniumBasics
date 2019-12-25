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

public class Handling_MovingSlider {

	public static void main(String ar[]) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - It will maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to jquery slider example web page
		driver.get("http://jqueryui.com/slider/");

		// frame(int) - It will switch to frame window by frame index
		driver.switchTo().frame(0);

		WebElement slider = driver.findElement(By.xpath("//*[contains(@class,'ui-slider-handle')]"));

		// Instance of Actions class is created by passing driver instance
		Actions move = new Actions(driver);

		// The Actions class is used to perform slide move operation

		// The below code will move the Slider in Forward direction
		move.dragAndDropBy(slider, 50, 0).build().perform();
		Thread.sleep(2000);

		// The below code will move the Slider in Backward direction
		move.dragAndDropBy(slider, -20, 0).build().perform();
		
		Thread.sleep(2000);

		// close() - It will close the Browser window
		driver.close();

	}

}
