package GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersImplementation {

	// @Override
	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {
		// capture the method name
		String methodName = result.getMethod().getMethodName();

		// capture the current date
		String CurrentDate = new JavaUtility().getSystemDateWithFormat();

		// concatinate for screenshot name
		String screenShotName = methodName + "_" + CurrentDate;

		try {
			new WebdriverUtility().takeScreenshot(BaseClass.sdriver, screenShotName);
		} catch (Throwable e) {

			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}
}
