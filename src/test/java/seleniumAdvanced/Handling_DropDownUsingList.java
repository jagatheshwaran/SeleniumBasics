/**
 * @author Jagatheshwaran
 * 
 */
package seleniumAdvanced;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_DropDownUsingList {

	static WebDriver driver;

	public static void selectDropValue() throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		driver = new ChromeDriver();

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to below html web page
		driver.get("D:\\ECLIPSE_ENV\\Workspace\\SeleniumBasics\\src\\test\\resources\\TestFiles\\Dropdown.html");

		WebElement Dropdown = driver.findElement(By.xpath("//div[@class='select-selected']"));
		Dropdown.click();

		// Taking list of Options from DropDown and store it in List WebElement, Iterate
		// through options to select the value passed in code
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='select-items']/li"));
		System.out.println("Options : " + options.size());
		boolean flag = false;
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("Google Chrome")) {
				flag = true;
				option.click();
			}
		}
		if (flag == false) {
			System.out.println(flag + " Given element not found");
		}

		Thread.sleep(2000);

		// close() - It will close Browser window
		driver.close();

	}

	public static void select2ndLastElement() throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		driver = new ChromeDriver();

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to below html web page
		driver.get("D:\\ECLIPSE_ENV\\Workspace\\SeleniumBasics\\src\\test\\resources\\TestFiles\\Dropdown.html");

		WebElement Dropdown = driver.findElement(By.xpath("//div[@class='select-selected']"));
		Dropdown.click();

		// Taking list of Options from DropDown and store it in List WebElement
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='select-items']/li"));
		System.out.println("Options : " + options.size());

		Thread.sleep(2000);

		// The below code will select 2nd last option value from DropDown
		WebElement option = options.get(options.size() - 2);
		option.click();

		Thread.sleep(2000);

		// close() - It will close Browser window
		driver.close();

	}

	public static void main(String ar[]) throws InterruptedException {
		selectDropValue();
		select2ndLastElement();
	}
}
