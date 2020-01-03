/**
 * @author Jagatheshwaran
 * 
 */
package testNGConcepts;

//Importing the predefined class libraries
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

//The Class is created with name : BeforeGroups_Test_AfterGroups
public class BeforeGroups_AfterGroups {

	@BeforeGroups
	public void login() {
		System.out.println("Login to Ecommerce Site Successful");
	}

	@Test(groups = { "sanity","regression" }, priority = 1)
	public void searchProduct() {
		System.out.println("Browse and Search of Product Successful");
	}

	@Test(groups = { "sanity" }, priority = 2)
	public void addProduct() {
		System.out.println("Add Product to Cart Successful");
	}

	@Test(groups = { "regression" }, priority = 1)
	public void addAddress() {
		System.out.println("Add Shipping Details Successful");
	}

	@Test(groups = { "regression" }, priority = 2)
	public void payMoney() {
		System.out.println("Add Payment Method Successful");
	}

	@Test(dependsOnGroups  = { "sanity.*" },priority = 3)
	public void placeOrder() {
		System.out.println("Place Order Successful");
	}

	@AfterGroups
	public void logout() {
		System.out.println("Logout of Ecommerce Site Successful");
	}
}
