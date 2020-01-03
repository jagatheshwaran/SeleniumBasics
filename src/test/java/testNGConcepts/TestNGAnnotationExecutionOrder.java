/**
 * @author Jagatheshwaran
 * 
 */
package testNGConcepts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotationExecutionOrder {

	// The annotated method will be run before all tests in this suite have run.
	@BeforeSuite
	public static void beforeSuite() {
		System.out.println("Before Suite");
	}

	// The annotated method will be run after all tests in this suite have run.
	@AfterSuite
	public static void afterSuite() {
		System.out.println("After Suite");
	}

	// The annotated method will be run before the first test method in the current
	// class is invoked.
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
	}

	// The annotated method will be run after all the test methods in the current
	// class have been run.
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}

	// The annotated method will be run before any test method belonging to the
	// classes inside the <test> tag is run.
	@BeforeTest
	public static void beforeTest() {
		System.out.println("Before Test");
	}

	// The annotated method will be run after all the test methods belonging to the
	// classes inside the <test> tag have run.
	@AfterTest
	public static void afterTest() {
		System.out.println("After Test");
	}

	// The list of groups that this configuration method will run before. This
	// method is guaranteed to run shortly before the first test method that belongs
	// to any of these groups is invoked.
	@BeforeGroups
	public static void beforeGroup() {
		System.out.println("Before Group");
	}

	// The list of groups that this configuration method will run after. This method
	// is guaranteed to run shortly after the last test method that belongs to any
	// of these groups is invoked.
	@AfterGroups
	public static void afterGroup() {
		System.out.println("After Group");
	}

	// The annotated method will be run before each test method.
	@BeforeMethod
	public static void beforeMethod() {
		System.out.println("Before Method");
	}

	// The annotated method will be run after each test method.
	@AfterMethod
	public static void afterMethod() {
		System.out.println("After Method");
	}

	@Test
	public static void testMethod() {
		System.out.println("Test Method");
	}
}
