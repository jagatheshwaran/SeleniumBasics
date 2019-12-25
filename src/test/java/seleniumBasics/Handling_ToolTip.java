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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Handling_ToolTip {

	// Global variable declaration
	public static WebDriver driver;

	public static void main(String ar[]) throws InterruptedException {

		toolTipWithoutActions();
		toolTipWithActions();
	}

	// The below method will handle ToolTip functionality without using Actions
	// class
	public static void toolTipWithoutActions() throws InterruptedException {

		String baseURL = "https://selenium.dev/documentation/en/";

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		driver = new ChromeDriver();

		// manage().window().maximize() - It will maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to selenium web site document page
		driver.get(baseURL);

		// The below code will fetch the tool tip content of the web element with title
		// attribute
		WebElement toolTip = driver
				.findElement(By.xpath("(//li[contains(@data-nav-id,'/selenium_installation/')])[1]"));
		String toopTipText = toolTip.getAttribute("title");
		System.out.println("ToolTip Text : " + toopTipText);

		// It will explicitly wait for specified mill seconds
		Thread.sleep(2000);

		// close() - It will close the Browser window
		driver.close();
	}

	// The below method will handle ToolTip functionality using Actions class
	@SuppressWarnings("deprecation")
	public static void toolTipWithActions() throws InterruptedException {

		String baseURL = "https://jqueryui.com/tooltip/";

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		driver = new ChromeDriver();

		// manage().window().maximize() - It will maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to the jquery tool tip web page
		driver.get(baseURL);

		// WebDriverWait() - It will explicitly wait for the specified seconds
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Switching into Frame
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
		WebElement input = driver.findElement(By.cssSelector("#age"));

		// Actions class instance is created
		Actions action = new Actions(driver);

		// The below code will mouse hover the web element input
		action.moveToElement(input).build().perform();
		WebElement toolTip = driver.findElement(By.cssSelector(".ui-tooltip-content"));

		// getText() - It will fetch the text content of the tooltip web element
		String toopTipText = toolTip.getText();
		System.out.println("ToolTip Text : " + toopTipText);

		// It will explicitly wait for specified mill seconds
		Thread.sleep(2000);

		// close() - It will close the Browser window
		driver.close();
	}
}
