/**
 * @author Jagatheshwaran
 * 
 */
package testNGConcepts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedClass {

	// The below method will invoke value for "name" param from XML File
	@Test
	@Parameters("name")
	public void user(String name) {
		System.out.println("The user name from testNG.xml is : " + name);
	}

}
