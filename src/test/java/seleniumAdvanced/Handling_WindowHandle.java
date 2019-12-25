/**
 * @author Jagatheshwaran
 * 
 */
package seleniumAdvanced;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_WindowHandle {

	public static void main(String[] args) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to below web page
		driver.get(
				"D:\\ECLIPSE_ENV\\Workspace\\SeleniumBasics\\src\\test\\resources\\TestFiles\\windowHandle\\Login.html");

		Thread.sleep(2000);

		driver.findElement(By.linkText("Sign Up")).click();

		// getWindowHandle() - It is used to get the parent window unique alphanumeric
		// id
		String parent = driver.getWindowHandle();

		// getWindowHandle() - It is used to get the all available windows unique
		// alphanumeric ids
		Set<String> handles = driver.getWindowHandles();

		// size() - It is used to get the number of windows
		int BrowserCount = handles.size();
		System.out.println(BrowserCount);

		// The below set of codes are used to switch control from parent to child window
		for (String s1 : handles) {
			if (!s1.equals(parent)) {
				driver.switchTo().window(s1);
				System.out.println(driver.getCurrentUrl());
				Thread.sleep(2000);
				driver.close();
			}
		}
		// The below code is used to switch control from child window to parent window
		driver.switchTo().window(parent);
		System.out.println(driver.getCurrentUrl());

		Thread.sleep(2000);

		// close() - close the Browser window
		driver.close();

	}

}
