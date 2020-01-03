/**
 * @author Jagatheshwaran
 * 
 */
package testNGConcepts;

// Importing the predefined class libraries
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// The Class is created with name : BeforeTest_Test_AfterTest
public class BeforeTest_AfterTest {
	
	// BeforeTest - The annotated method will be run before any Test methods belonging to classes is run
	@BeforeTest
	public void login() {
		System.out.println("Login to Ecommerce Site Successful");
	}

	@Test(priority = 1)
	public void searchProduct() {
		System.out.println("Browse and Search of Product Successful");
	}

	@Test(priority = 2)
	public void addProduct() {
		System.out.println("Add Product to Cart Successful");
	}

	@Test(priority = 3)
	public void addAddress() {
		System.out.println("Add Shipping Details Successful");
	}

	@Test(priority = 4)
	public void payMoney() {
		System.out.println("Add Payment Method Successful");
	}

	@Test(priority = 5)
	public void placeOrder() {
		System.out.println("Place Order Successful");
	}

	// AfterTest - The annotated method will be run after all the Test methods belonging to the classes have run
	@AfterTest
	public void logout() {
		System.out.println("Logout of Ecommerce Site Successful");
	}

}
