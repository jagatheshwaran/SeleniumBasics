/**
 * @author Jagatheshwaran
 * 
 */
package testNGConcepts;

import org.testng.Assert;

//Importing the predefined class libraries

import org.testng.annotations.Test;

//The Class is created with name : Mutliple_Tests
public class MutlipleTests {
	// The below methods will run in alphabetical order
	@Test
	public void testA() {

		// Assert is used to check whether expected and actual results are correct
		Assert.assertEquals("Gmail", "Gmail");
	}

	@Test
	public void testC() {
		Assert.assertEquals("Google", "Google");
	}

	@Test
	public void testB() {
		Assert.assertEquals("Yahoo", "Yahoo");
	}

	@SuppressWarnings("unused")
	@Test(expectedExceptions = ArithmeticException.class)
	public void testMath() {
		int a = 5 / 0;

	}

}
