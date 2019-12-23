/**
 * @author Jagatheshwaran
 * 
 */
package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_TypesOfLocators {

	public static void main(String[] args) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - It will maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to Google Account login page
		driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		// It will explicitly wait for specified mill seconds
		Thread.sleep(3000);

		// Inspecting Element by id
		WebElement emailID = driver.findElement(By.id("identifierId"));

		// sendKeys() - It is used to enter text in Input box or Text area on the web
		// page
		emailID.sendKeys("testjaga007");

		// clear() - It is used to clear text in Input box or Text area on the web page
		emailID.clear();

		// Inspecting Element by name
		WebElement emailID1 = driver.findElement(By.name("identifier"));
		emailID1.sendKeys("testjaga007");
		emailID1.clear();

		// Inspecting Element by cssSeletor
		WebElement emailID2 = driver.findElement(By.cssSelector("#identifierId"));
		emailID2.sendKeys("testjaga007");
		emailID2.clear();

		// Inspecting Element by Xpath
		WebElement emailID3 = driver.findElement(By.xpath("//*[@id='identifierId']"));
		emailID3.sendKeys("testjaga007");
		emailID3.clear();

		// navigate().to() - It will redirect you to Google home page
		driver.navigate().to("https://www.google.co.in/");

		// Inspecting Element by linkText
		driver.findElement(By.linkText("Gmail")).click();

		// navigate().back() - It will redirect you to previous page
		driver.navigate().back();

		// Inspecting Element by partialLinkText
		driver.findElement(By.partialLinkText("mail")).click();

		// navigate().back() - It will redirect you to previous page
		driver.navigate().back();

		// Inspecting Element by className
		driver.findElement(By.className("gb_g")).click();

		// get() - It will navigate to the below html page
		driver.get("D:\\ECLIPSE_ENV\\Workspace\\SeleniumBasics\\src\\test\\resources\\TestFiles\\DisabledElement.html");

		// Inspecting Element by tagName
		driver.findElement(By.tagName("input")).sendKeys("India");

		// It will explicitly wait for specified mill seconds
		Thread.sleep(3000);

		// close() - It will close the Browser window
		driver.close();

	}

}
