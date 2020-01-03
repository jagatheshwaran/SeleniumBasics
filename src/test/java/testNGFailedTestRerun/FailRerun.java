/**
 * @author Jagatheshwaran
 * 
 */
package testNGFailedTestRerun;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailRerun implements IRetryAnalyzer {

	// Declaring Variables
	private int retryCount = 0;
	private int maxRetryCount = 2;

	// The below method will retry the failed test case based on test case result
	// status
	public boolean retry(ITestResult result) {

		if (retryCount < maxRetryCount) {

			System.out.println("Retrying test " + result.getName() + " with status "
					+ getResultStatus(result.getStatus()) + " for the " + (retryCount + 1) + " time.");

			retryCount++;

			return true;
		}

		return false;

	}

	// The below method will get the result status of the test case executed
	public static String getResultStatus(int status) {

		String resultStatus = null;

		if (status == 1)
			resultStatus = "SUCCESS";
		if (status == 2)
			resultStatus = "FAILURE";
		if (status == 3)
			resultStatus = "SKIP";

		return resultStatus;

	}

}
