package handleCookies;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageCookie {

	public static void addCookie() {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - To Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to Flipkart website
		driver.get("https://www.flipkart.com/");

		// we should pass name and value for cookie as parameters
		// In this example we are passing, name=test and value=test12345
		Cookie newCookie = new Cookie("test", "test12345");

		// addCookie() - It is used to add new cookie
		driver.manage().addCookie(newCookie);

		// getCookieNamed() - It is used to get the cookie by name
		Cookie cookie = driver.manage().getCookieNamed("test");

		System.out.println("Newly added cookie : " + cookie);

		// close() - It is used to close the current browser window
		driver.close();

	}

	public static void deleteCookieByName() {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - To Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to Flipkart website
		driver.get("https://www.flipkart.com/");

		// deleteCookieNamed() - It is used to delete the cookie by cookie name
		driver.manage().deleteCookieNamed("test");

		// getCookies() - It is used to get the set of cookies available for the current
		// domain
		Set<Cookie> cookiesSet = driver.manage().getCookies();

		for (Cookie cookie : cookiesSet) {

			System.out.println(cookie);
		}

		// close() - It is used to close the current browser window
		driver.close();

	}

	public static void deleteAllCookie() {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - To Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to Flipkart website
		driver.get("https://www.flipkart.com/");

		// deleteAllCookies() - It is used to delete all the cookies
		driver.manage().deleteAllCookies();

		// getCookies() - It is used to get the set of cookies available for the current
		// domain
		Set<Cookie> cookiesSet = driver.manage().getCookies();

		if (cookiesSet.isEmpty()) {
			System.out.println("There is no cookies available for current domain");
		}

		// close() - It is used to close the current browser window
		driver.close();

	}

	public static void main(String ar[]) throws IOException, InterruptedException {

		addCookie();
		deleteCookieByName();
		deleteAllCookie();
	}
}
