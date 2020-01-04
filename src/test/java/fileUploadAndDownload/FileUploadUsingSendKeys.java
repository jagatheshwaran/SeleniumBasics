package fileUploadAndDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadUsingSendKeys {

	static WebDriver driver;

	public static void main(String ar[]) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		driver = new ChromeDriver();

		// manage().window().maximize() - To Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to Guru99 testing site
		driver.get("http://demo.guru99.com/test/upload/");

		WebElement upload = driver.findElement(By.xpath("//input[@name='uploadfile_0']"));

		upload.sendKeys("D:\\ECLIPSE_ENV\\Workspace\\SeleniumBasics-master\\TestResources\\WebTable.html");

		driver.findElement(By.id("terms")).click();

		driver.findElement(By.xpath("//button[@id='submitbutton']")).click();

		Thread.sleep(5000);

		driver.quit();

	}
}
