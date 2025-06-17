package Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

	public void onStart(ITestContext context) {
		ExtentReporter.intializeTheExtentReport();

	}

	public void onFinish(ITestContext context) {
		ExtentReporter.flushExtent();
		System.out.println("Execution of the test cases from: " + context.getName() +" " + "is finished on: " + context.getStartDate() + "\nTotal test case Passed: "
				+ context.getPassedTests() + " " + "on the thread:" + Thread.currentThread().getId());
		ReusableMethods
		.log("Execution of the test case: " + context.getName() +" " + "is finished on: " + context.getStartDate() + "\nTotal test case Passed: "
				+ context.getPassedTests() + " " + "on the thread:" + Thread.currentThread().getId());

		System.out.println("Execution of the test case: " + context.getName() +" " + "is finished on: " + context.getStartDate() + "\nTotal test case failed: "
				+ context.getFailedTests() + " " + "on the thread:" + Thread.currentThread().getId());
		ReusableMethods.log("Execution of the test case: " + context.getName() +" " + "is finished on: " + context.getStartDate() + "\nTotal test case failed: "
				+ context.getFailedTests() + " " + "on the thread:" + Thread.currentThread().getId());

		System.out.println("Execution of the test case: " + context.getName() +" " + "is finished on: " + context.getStartDate() + "\nTotal test case Skipped: "
				+ context.getSkippedTests() + " " + "on the thread:" + Thread.currentThread().getId());
		ReusableMethods.log("Execution of the test case: " + context.getName() +" " + "is finished on: " + context.getStartDate() + "\nTotal test case Skipped: "
				+ context.getSkippedTests() + " " + "on the thread:" + Thread.currentThread().getId());
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Execution of the test case: " + result.getName() + " " + "is started" + " " + "on the thread: " + Thread.currentThread().getId());
		ReusableMethods.log("Execution of the test case: " + result.getName() + " " + "is started" + " " + "on the thread: " + Thread.currentThread().getId());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Execution of the test case: " + result.getName() + " " + "is success" + " " + "on the thread: " + Thread.currentThread().getId());
		ExtentReporter.logPassedTestOnExtentReport(result.getName());
		ReusableMethods.log("Execution of the test case: " + result.getName() + " " + "is success" + " " + "on the thread: " + Thread.currentThread().getId());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Execution of the test case: " + result.getName() + " " + "is failed" + " " + "on the thread: " + Thread.currentThread().getId());
		ExtentReporter.logfailedTestOnExtentReport(result.getName());
		ReusableMethods.log("Execution of the test case: " + result.getName() + " " + "is failed" + " " + "on the thread: " + Thread.currentThread().getId());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Execution of the test case: " + result.getName() + " " + "is skipped" + " " + "on the thread: " + Thread.currentThread().getId());
		ExtentReporter.logSkippedTestOnExtentReport(result.getName());
		ReusableMethods.log("Execution of the test case: " + result.getName() + " " + "is skipped" + " " + "on the thread: " + Thread.currentThread().getId());
	}

	/*
	 * public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	 * BasePage.log(result.getMethod()); }
	 * 
	 */
}
