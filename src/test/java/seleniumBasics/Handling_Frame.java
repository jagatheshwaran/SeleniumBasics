/**
 * @author Jagatheshwaran
 * 
 */
package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Frame {

	public static void main(String[] args) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - It will maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to the below web page
		driver.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");

		// switchTo().frame(String) - It will switch to frame by name
		driver.switchTo().frame("classFrame");

		// The below code will click a link on frame
		driver.findElement(By.xpath("//td[@class='colFirst']//a[text()='com.thoughtworks.selenium']")).click();

		// switchTo().defaultContent() - It will switch back to default window from
		// frame
		driver.switchTo().defaultContent();

		// It will wait explicitly for specified mill seconds
		Thread.sleep(5000);

		// switchTo().frame(int) - It will switch to frame by index
		driver.switchTo().frame(1);

		// The below code will click link on frame
		driver.findElement(By.xpath("//a[text()='AbstractAnnotations']")).click();

		// switchTo().defaultContent() - It will switch back to default window from
		// frame
		driver.switchTo().defaultContent();

		// It will wait explicitly for specified mill seconds
		Thread.sleep(5000);

		// The below code will switch to frame by xpath
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@title='All Packages']")));

		// The below code will click link on frame
		driver.findElement(By.linkText("org.openqa.selenium")).click();

		// It will wait explicitly for specified mill seconds
		Thread.sleep(5000);

		// close() - It will close the Browser window
		driver.close();

	}

}
