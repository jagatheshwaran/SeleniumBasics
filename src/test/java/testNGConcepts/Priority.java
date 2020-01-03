/**
 * @author Jagatheshwaran
 * 
 */
package testNGConcepts;

//Importing the predefined class libraries
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//The Class is created with name : Priority
public class Priority 
{
	// The global variable is declared
	public WebDriver driver;
	
	@Test (priority=1)
	public void launchBrowser()
	{

	// Provide the path of driver location
	System.setProperty("webdriver.firefox.marionette", "./BrowserDrivers/geckodriver.exe");
    
	// Driver instance is created
	driver = new FirefoxDriver();   
	}

	@Test (priority=2)
	public void verifyPageTitle1()
	{
	
	// Launching the browser with the below url
	driver.get("https://www.gmail.com");
	Assert.assertEquals("Gmail", driver.getTitle());
	}

	@Test(priority=3)
	public void verifyPageTitle2()
	{
	
	// Launching the browser with the below url
	driver.get("https://in.yahoo.com/");
	Assert.assertEquals("Yahoo", driver.getTitle());
	}
	
	@Test (priority=4)
	public void closeBrowser()
	{
	
	// The below method will close the browser window
	driver.close();
	}
	
}
