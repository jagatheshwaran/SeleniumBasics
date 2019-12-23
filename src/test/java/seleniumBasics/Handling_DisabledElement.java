/**
 * @author Jagatheshwaran
 * 
 */
package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_DisabledElement {

	public static void main(String ar[]) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - It will maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will navigate to the below html page
		driver.get("D:\\ECLIPSE_ENV\\Workspace\\SeleniumBasics\\src\\test\\resources\\TestFiles\\DisabledElement.html");

		// It will explicitly wait for specified mill seconds
		Thread.sleep(3000);

		WebElement textField = driver.findElement(By.xpath(".//*[@id='myText']"));
		textField.sendKeys("Selenium_Java");
		driver.findElement(By.xpath("//button")).click();

		// It will explicitly wait for specified mill seconds
		Thread.sleep(5000);

		// getAttribute("value") - It will fetch the text value of VALUE attribute , irrespective of element is disabled or enabled
		String textval = textField.getAttribute("value");
		System.out.println("Value From Disabled Element : " + textval);

		// arguments[0].removeAttribute('disabled'); - JavaScript Function, It will
		// enable the disabled element in current session
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].removeAttribute('disabled');", textField);

		// It will explicitly wait for specified mill seconds
		Thread.sleep(2000);

		// Retrieving text value from Enabled element
		String text = textField.getAttribute("value");
		System.out.println("Value From Enabled Element : " + text);

		// close() - It will close Browser window
		driver.close();
	}

}
