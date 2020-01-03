/**
 * @author Jagatheshwaran
 * 
 */
package testNGConcepts;

//Importing the predefined class libraries
import org.testng.annotations.Test;

//The Class is created with name : DependsOnMethods
public class DependsOnMethods {
	
	@Test
	public void login() {
		System.out.println("Login to Ecommerce Site Successful");
	}

	// dependsOnMethods - It is used to run the search method after the login method
	// search method will depends on the login method and run 
	@Test(dependsOnMethods = { "login" })
	public void search() {
		System.out.println("Browse and Search Product Successful");
	}

	// dependsOnMethods - It is used to run the logout method after the search method
	// logout method will depends on the search method and run
	@Test(dependsOnMethods = { "search" })
	public void logout() {
		System.out.println("Logout of Ecommerce Site Successful");
	}

}
