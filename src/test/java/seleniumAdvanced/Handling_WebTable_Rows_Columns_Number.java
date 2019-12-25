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

public class Handling_WebTable_Rows_Columns_Number {

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
		int totalRows = allRows.size() - 1;
		System.out.println("Total rows " + allRows.size());

		// The below code will get the total cells count
		List<WebElement> allColumns = table.findElements(By.tagName("td"));
		int totalColumns = allColumns.size();
		System.out.println("Total cells " + totalColumns);

		// The below code will iterate through Table rows and columns, and print row
		// number and column number which have value "UK"
		for (int row = 0; row < totalRows; row++) {

			List<WebElement> row_columns = allRows.get(row).findElements(By.tagName("td"));

			int rowColumns = row_columns.size();

			for (int column = 0; column < rowColumns; column++) {

				String cellText = row_columns.get(column).getText();

				if (cellText.contains("UK")) {
					System.out.println(
							"Cell Value of row number " + row + " and column number " + column + " Is " + cellText);
				}

			}
		}

		// Thread.sleep() - It will explicitly wait for specified mill seconds
		Thread.sleep(3000);

		// close() - It will close the Browser window
		driver.close();

	}

}
