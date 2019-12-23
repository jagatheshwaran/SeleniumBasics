/**
 * @author Jagatheshwaran
 * 
 */
package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Handling_RegistrationForm {

	public static void main(String[] args) {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - It will maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to gcrit testing site
		driver.get("http://www.gcrit.com/build3/login.php");

		// The below code snippet will fill the new user registration form to create
		// account
		driver.findElement(By.xpath("//div[@class='contentText']//p[text()='I am a new customer.']")).isDisplayed();
		driver.findElement(By.xpath("//span[@class='ui-button-text'][text()='Continue']")).click();
		driver.findElement(By.xpath("(//input[@name='gender'])[1]")).click();
		driver.findElement(By.name("firstname")).sendKeys("jaga");
		driver.findElement(By.name("lastname")).sendKeys("waran");
		driver.findElement(By.name("dob")).sendKeys("08/30/1994");
		driver.findElement(By.name("email_address")).sendKeys("testjaga010@gmail.com");
		driver.findElement(By.name("street_address")).sendKeys("TamilNadu");
		driver.findElement(By.name("postcode")).sendKeys("600001");
		driver.findElement(By.name("city")).sendKeys("Chennai");
		driver.findElement(By.name("state")).sendKeys("TamilNadu");
		Select dropdown = new Select(driver.findElement(By.name("country")));
		dropdown.selectByVisibleText("India");
		driver.findElement(By.name("telephone")).sendKeys("9944551212");
		driver.findElement(By.name("password")).sendKeys("jaga1994");
		driver.findElement(By.name("confirmation")).sendKeys("jaga1994");
		driver.findElement(By.id("tdb4")).click();

		// After creation of new user account, the Success message is captured for
		// validation
		String ConformationMessage = driver.findElement(By.xpath(".//*[@id='bodyContent']/h1")).getText();

		// Verifying the captured success message with expected success message
		if (ConformationMessage.equals("Your Account Has Been Created!")) {
			System.out.println("Customer Registration Successful - Passed");

		} else {
			System.out.println("Customer Registration Unsuccessful - Failed");
		}

		// close() - It will close the Browser window
		driver.close();

	}

}
