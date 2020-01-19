package readDataFromDB;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginToApplication extends ConnectToDataBase {

	ConnectToDataBase connectToDataBase = new ConnectToDataBase();

	public String query = "select * from customer.userlogindetail;";

	public void loginToAP() throws ClassNotFoundException, SQLException, InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - To Maximize Browser Window
		driver.manage().window().maximize();

		// HashMap is created to store the values from Database
		HashMap<Integer, String> dataMap = new HashMap<Integer, String>();

		// ResultSet - It is used to get the data from DataBase by executing the query
		ResultSet dataFromDB = connectToDataBase.getData(query);
		int i = 1;
		while (dataFromDB.next()) {
			for (; i <= 2; i++) {
				dataMap.put(i, dataFromDB.getString(i));
			}
			i = i + 1;
		}

		// The below set of codes will login to Automation Practice web site
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(dataMap.get(1));
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(dataMap.get(2));
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='account']")).isDisplayed();

		// close() - It is used to close the current browser window
		driver.close();
	}

	public static void main(String ar[])
			throws IOException, InterruptedException, ClassNotFoundException, SQLException {

		LoginToApplication loginToApplication = new LoginToApplication();
		loginToApplication.loginToAP();

	}

}
