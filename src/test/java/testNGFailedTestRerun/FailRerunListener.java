/**
 * @author Jagatheshwaran
 * 
 */
package testNGFailedTestRerun;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class FailRerunListener implements IAnnotationTransformer {

	// The below method will perform failure rerun based on
	// annotation/class/constructor/method
	@SuppressWarnings("rawtypes")
	public void transform(ITestAnnotation testannotation, Class testClass, Constructor testConstructor,
			Method testMethod) {

		// Retry Analyzer is set based on annotation
		IRetryAnalyzer retry = testannotation.getRetryAnalyzer();

		if (retry == null) {
			testannotation.setRetryAnalyzer(FailRerun.class);
		}

	}

}
