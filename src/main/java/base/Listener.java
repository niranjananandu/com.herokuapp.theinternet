package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
	Logger log;
	String testName;
	String methodName;

	@Override
	public void onStart(ITestContext context) {
		this.testName = context.getCurrentXmlTest().getName();
		this.log = LogManager.getLogger(testName);
		log.info("******Starting tests : " + testName + "******");
	}

	@Override
	public void onTestStart(ITestResult result) {
		this.methodName = result.getMethod().getMethodName();
		log.info("Starting test case: " + methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("Test PASSED: " + methodName);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info("Test FAILED: " + methodName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.info("Test SKIPPED: " + methodName);
	}

	@Override
	public void onFinish(ITestContext context) {
		log.info("******Finished tests : " + testName + "******");
	}

}
