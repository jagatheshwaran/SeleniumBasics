package fileUploadAndDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownloadUsingWget {

	static WebDriver driver;

	public static void main(String ar[]) throws InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		driver = new ChromeDriver();

		// manage().window().maximize() - To Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to Guru99 testing site
		driver.get("http://demo.guru99.com/test/yahoo.html");

		WebElement downloadButton = driver.findElement(By.id("messenger-download"));

		String sourceLocation = downloadButton.getAttribute("href");

		String wget_command = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + sourceLocation;

		try {
			Process exec = Runtime.getRuntime().exec(wget_command);
			int exitVal = exec.waitFor();
			System.out.println("Exit value: " + exitVal + " " + "File Download complete");
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		driver.quit();

	}

}
