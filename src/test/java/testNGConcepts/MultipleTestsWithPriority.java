/**
 * @author Jagatheshwaran
 * 
 */
package testNGConcepts;

import org.testng.Assert;

//Importing the predefined class libraries

import org.testng.annotations.Test;

//The Class is created with name : Multiple_Tests_Priority
public class MultipleTestsWithPriority 
{

	// Priority is used to set the preferences to the methods to run 
	// If priority is not set for the method then methods will run in alphabetical order
	
	@Test (priority = 1)
	public void testAA(){
	Assert.assertEquals("Gmail", "Gmail");
	}
	@Test (priority = 5)
	public void testBB(){
	Assert.assertEquals("Google", "Google");
	}
	@Test (priority = 10)
	public void testCC(){
	Assert.assertEquals("Yahoo", "Yahoo");
	}
	
	// The below method's priority is 3 but its enabled to false so this method will not run
	@Test (priority = 3,enabled = false)
	public void testA()
	{
	Assert.assertEquals("Gmail", "Gmail");
	}
	@Test (priority = 1)
	public void testB(){
	Assert.assertEquals("Google", "Google");
	}
	@Test (priority = 2)
	public void testC(){
	Assert.assertEquals("Yahoo", "Yahoo");
	}
}
