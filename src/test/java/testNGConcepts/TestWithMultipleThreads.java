/**
 * @author Jagatheshwaran
 * 
 */
package testNGConcepts;

//Importing the predefined class libraries
import org.testng.annotations.Test;

//The Class is created with name : Test_With_Threads
public class TestWithMultipleThreads {
	
	@Test
	public void addProduct() {
		long id = Thread.currentThread().getId();
		System.out.println("Add Product Test Case is Successful - Current Thread id is: " + id);
	}

	@Test
	public void addShipDetail() {
		long id = Thread.currentThread().getId();
		System.out.println("Add Ship Detail Test Case is Successful - Current Thread id is: " + id);
	}

	@Test
	public void payMoney() {
		long id = Thread.currentThread().getId();
		System.out.println("Pay Money Test Case is Successful - Current Thread id is: " + id);
	}
}
