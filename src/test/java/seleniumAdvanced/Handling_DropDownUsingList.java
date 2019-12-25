/**
 * @author Jagatheshwaran
 * 
 */
package seleniumAdvanced;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_DropDownUsingList {

	static WebDriver driver;

	public static void select2ndLastElement() throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		driver = new ChromeDriver();

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to below html web page
		driver.get("D:\\ECLIPSE_ENV\\Workspace\\SeleniumBasics\\src\\test\\resources\\TestFiles\\Dropdown.html");

		WebElement Dropdown = driver.findElement(By.xpath("//input[@name='browser']"));
		Dropdown.click();

		// Taking list of Options from DropDown
		List<WebElement> options = driver.findElements(By.xpath("//datalist[@id='browsers']//option"));
		System.out.println("DropDown option list size : " + options.size());
		Thread.sleep(2000);

		// It will select 2nd last option value in DropDown
		WebElement option = options.get(options.size() - 2);
		option.click();
		// Dropdown.click();
		Thread.sleep(2000);
		driver.close();

	}

	public static void main(String ar[]) throws IOException, InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		driver = new ChromeDriver();

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to below html web page
		driver.get("D:\\ECLIPSE_ENV\\Workspace\\SeleniumBasics\\src\\test\\resources\\TestFiles\\Dropdown.html");

		WebElement Dropdown = driver.findElement(By.xpath("//input[@name='browser']"));
		Dropdown.click();

		Thread.sleep(2000);

		// Taking list of Options from DropDown and selecting Option what we passed in
		// code
		List<WebElement> options = driver.findElements(By.xpath("//datalist[@id='browsers']/option"));
		System.out.println("Options : " + options.size());
		boolean flag = false;
		for (WebElement option : options) {
			System.out.println(option.getAttribute("value"));
			if (option.getAttribute("value").equalsIgnoreCase("Chrome")) {
				flag = true;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click", option);
				Thread.sleep(5000);
				// Dropdown.click();
			}
		}
		if (flag == false) {
			System.out.println(flag + " Given element not found");
		}
		Thread.sleep(2000);

		// It will close Browser window
		driver.close();

	}
}
