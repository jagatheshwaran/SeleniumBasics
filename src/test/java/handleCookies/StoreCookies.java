package handleCookies;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StoreCookies {

	public static void main(String ar[]) throws IOException, InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - To Maximize Browser Window
		driver.manage().window().maximize();

		// The below set of codes will take you to Amazon sign in page - Enter your
		// login details and check keep me sign in option
		driver.get(
				"https://www.amazon.in/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_custrec_signin&switch_account=");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("9876543210");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();

		Thread.sleep(5000);

		// The below set of codes will store the cookie information into the file
		File file = new File("cookie.info");
		try {
			if (file.exists()) {
				file.delete();
			} else {
				file.createNewFile();
			}
			String cookieInfo = null;
			FileWriter fileWrite = new FileWriter(file);
			BufferedWriter bufferedWrite = new BufferedWriter(fileWrite);
			for (Cookie cookie : driver.manage().getCookies()) {
				cookieInfo = cookie.getName() + ";" + cookie.getValue() + ";" + cookie.getDomain() + ";"
						+ cookie.getPath() + ";" + cookie.getExpiry() + ";" + cookie.isSecure();
				bufferedWrite.write(cookieInfo);
				bufferedWrite.newLine();
			}
			System.out.println("cookie information : " + cookieInfo);
			bufferedWrite.flush();
			bufferedWrite.close();
			fileWrite.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// close() - It is used to close the current browser window
		driver.close();
	}
}
