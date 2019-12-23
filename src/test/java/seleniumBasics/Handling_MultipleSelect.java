/**
 * @author Jagatheshwaran
 * 
 */
package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Handling_MultipleSelect {

	public static void main(String[] args) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - It will maximize Browser Window
		driver.manage().window().maximize();

		// Launching Browser with the below url
		driver.get("https://www.toolsqa.com/automation-practice-form/");

		Select select = new Select(driver.findElement(By.name("selenium_commands")));

		// isMultiple() - It will check whether the DropDown has multiple select option
		boolean selectMulti = select.isMultiple();
		System.out.println("Multiple Select Option : " + selectMulti);

		// selectByIndex() - It will select options from DropDown by Index
		select.selectByIndex(0);
		select.selectByIndex(1);

		// It will explicitly wait for specified mill seconds
		Thread.sleep(2000);

		// deselectAll() - It will deselect all selected Options from DropDown by Index
		select.deselectAll();

		// selectByIndex() - It will select option from DropDown by Index
		select.selectByIndex(0);

		// It will explicitly wait for specified mill seconds
		Thread.sleep(2000);

		// deselectByIndex() - It will deselect option from DropDown by Index
		select.deselectByIndex(0);

		// selectByVisibleText() - It will select option from DropDown by Visible text
		select.selectByVisibleText("Navigation Commands");

		// It will explicitly wait for specified mill seconds
		Thread.sleep(2000);

		// deselectByVisibleText() - It will deselect option from DropDown by Visible
		// text
		select.deselectByVisibleText("Navigation Commands");

		// close() - It will close the Browser window
		driver.close();
	}
}