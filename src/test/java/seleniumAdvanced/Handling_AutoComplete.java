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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Handling_AutoComplete {

	// Global variables declaration
	public WebDriver driver;
	public WebDriverWait wait;

	public String URL = "http://jqueryui.com/autocomplete/";
	private By frameLocator = By.className("demo-frame");
	private By tagsInput = By.id("tags");

	@SuppressWarnings("deprecation")

	public void Setup() {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		driver = new ChromeDriver();

		// manage().window().maximize() - To Maximize Browser Window
		driver.manage().window().maximize();

		// WebDriverWait instance is created
		wait = new WebDriverWait(driver, 10);
	}

	public void rightClickTest() {

		// Navigate to the below URL
		driver.navigate().to(URL);

		WebElement frameElement = driver.findElement(frameLocator);

		// Switching to Frame by xpath
		driver.switchTo().frame(frameElement);

		wait.until(ExpectedConditions.presenceOfElementLocated(tagsInput));
		WebElement textBoxElement = driver.findElement(tagsInput);
		textBoxElement.sendKeys("a");
		selectOptionWithText("Java");

	}

	public void Shutdown() {

		// close() - It will close the current Browser window
		driver.close();
	}

	// The below method will select the option from DropDown for match the text
	// entered in text field
	public void selectOptionWithText(String textToSelect) {
		try {
			WebElement autocompleteOptions = driver.findElement(By.id("ui-id-1"));

			// ExpectedConditions.visibilityOf(webElement) - It will used to wait for the
			// visibility of the web element
			wait.until(ExpectedConditions.visibilityOf(autocompleteOptions));

			// List<WebElement> - It will store list of Options from DropDown
			List<WebElement> optionsToSelect = autocompleteOptions.findElements(By.tagName("li"));

			// Selecting value from Auto Complete list options in check with text sent to
			// select

			// The below for loop will iterate through each element in list of web elements
			for (WebElement option : optionsToSelect) {

				// The below if condition will check the text passed with option text and if its
				// match, then select the option from auto complete dropdown options
				if (option.getText().equals(textToSelect)) {
					System.out.println("Trying to select: " + textToSelect);
					option.click();
					Thread.sleep(3000);
					System.out.println(textToSelect + " : value from autocomplete options selected");
					break;
				}
			}

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public static void main(String ar[]) {

		Handling_AutoComplete autoComplete = new Handling_AutoComplete();
		autoComplete.Setup();
		autoComplete.rightClickTest();
		autoComplete.Shutdown();

	}
}