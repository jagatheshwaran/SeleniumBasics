/**
 * @author Jagatheshwaran
 * 
 */
package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Handling_RadioButtonDropDown {

	public static void main(String[] args) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - It will maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to GCR testing site new user registration web page
		driver.get("http://www.gcrit.com/build3/create_account.php");

		// The below code will click Male radio button on the registration web page
		WebElement maleRadioButton = driver.findElement(By.xpath("(//input[@name='gender'])[1]"));
		System.out.println("Male RadioButton : " + maleRadioButton.isEnabled());
		maleRadioButton.click();
		System.out.println("Male RadioButton : " + maleRadioButton.isSelected());

		// The Select class will be used to handle the drop down

		// The drop down values will be selected by index, visibleText, and value

		// The below code will create instance for Select class with web element
		Select dropdown = new Select(driver.findElement(By.name("country")));

		// selectByIndex(int) - It will select the option from drop down by Index
		dropdown.selectByIndex(5);

		// It will explicitly wait for specified mill seconds
		Thread.sleep(2000);

		// selectByVisibleText(string) - It will select the option from drop down by
		// visible text
		dropdown.selectByVisibleText("India");

		// It will explicitly wait for specified mill seconds
		Thread.sleep(2000);

		// selectByValue(string) - It will select the option from drop down by
		// value
		dropdown.selectByValue("2");

		// It will explicitly wait for specified mill seconds
		Thread.sleep(2000);

		// close() - It will close the Browser window
		driver.close();

	}
}