/**
 * @author Jagatheshwaran
 * 
 */

package readDataFromPropertyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginToGCRApp {

	// Global variable declaration
	public static Properties repository = new Properties();
	public File file;
	public FileInputStream fileInputStream;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public WebElement element;

	/**
	 * This method will fetch the Test Data from the Property file
	 * 
	 * @param property
	 * 
	 * @author Jagatheshwaran
	 */
	public String getTestData(String property) throws InvocationTargetException {

		// The below code is used to create new File object with the given file path
		file = new File(
				System.getProperty("user.dir") + "//src//test//java//readDataFromPropertyFile//config.properties");
		try {

			// The FileInputStream instance is created by passing File Object
			fileInputStream = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			// The below code is used to load Data from FileInputStream to Properties() on
			// runtime
			repository.load(fileInputStream);

		} catch (IOException e) {
			e.printStackTrace();
		}

		// The below code is used to retrieve the data from properties() and trim the
		// spaces if any, then store it in String
		String DataFromPropFile = repository.getProperty(property).trim();

		return DataFromPropFile;

	}

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {

		// CustomerLogin class instance is created
		LoginToGCRApp loginToGCRApp = new LoginToGCRApp();

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// The below set of code is used to get the TestData from property file
		String url = loginToGCRApp.getTestData("url");
		String username = loginToGCRApp.getTestData("username");
		String password = loginToGCRApp.getTestData("password");

		// The below set of code is used to invoke the TestData from property file and
		// use it to login to GCR Testing site
		driver.get(url);
		driver.findElement(By.name("email_address")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("tdb5")).click();

		Thread.sleep(3000);

		// getCurrentUrl() - It is used to capture the current page URL
		String currentPageUrl = driver.getCurrentUrl();

		// The below code is used to validate the login to GCR Testing site is PASS or
		// FAIL with URL
		if (currentPageUrl.contains("http://www.gcrit.com/build3/index.php")) {

			System.out.println("Login Successful - Passed");
		} else {

			System.out.println("Login Unsuccessful - Failed");
		}

		// close() - It is used to close the current browser window
		driver.close();

	}
}
