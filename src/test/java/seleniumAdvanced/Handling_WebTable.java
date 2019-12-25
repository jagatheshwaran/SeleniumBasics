/**
 * @author Jagatheshwaran
 * 
 */
package seleniumAdvanced;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_WebTable {

	static WebDriver driver;

	public static void main(String ar[]) throws IOException, InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - Maximize Browser Window
		driver.manage().window().maximize();

		// get() - It will take you to below html web page
		driver.get("D:\\ECLIPSE_ENV\\Workspace\\SeleniumBasics\\src\\test\\resources\\TestFiles\\WebTable.html");

		WebElement table = driver.findElement(By.xpath("//table"));

		// The below code will get the total rows count
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		System.out.println("Total rows " + allRows.size());

		// The below code will get the total cells count
		List<WebElement> allColumns = table.findElements(By.tagName("td"));
		System.out.println("Total cells " + allColumns.size());

		// The below code will iterate through Table rows and columns, and print row
		// value which match "UK"
		for (WebElement row : allRows) {

			List<WebElement> cells = row.findElements(By.tagName("td"));

			for (WebElement cell : cells) {

				if (cell.getText().equals("UK")) {

					System.out.println(row.getText());

				}
			}
		}

		// Thread.sleep() - It will explicitly wait for specified mill seconds
		Thread.sleep(3000);

		// close() - It will close the Browser window
		driver.close();

	}

}
