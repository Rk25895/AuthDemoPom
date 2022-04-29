package GenericUtility;

import org.testng.ITestResult;

public class RetryAnalyserImpl {

	int count = 0;
	int retrycount = 5;

	public boolean retry(ITestResult result) {

		while (count <= retrycount) {
			count++;
			return true;
		}
		return false;
	}

}
