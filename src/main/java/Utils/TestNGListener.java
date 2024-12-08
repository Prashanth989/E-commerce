package Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;





public class TestNGListener implements ITestListener
{

	public void onStart(ITestContext context)
	{	
		ExtentReporter.intializeTheExtentReport();
		
	}

	public void onFinish(ITestContext context)
	{ 
		ExtentReporter.flushExtent();
		ReusableMethods.log(" Execution is finished " + context.getName() + context.getStartDate() + "Total no of test case Passed: " + context.getPassedTests());
		ReusableMethods.log(" Execution is finished " + context.getName() + context.getStartDate() + "Total no of test case failed: " + context.getFailedTests());
		ReusableMethods.log(" Execution is finished " + context.getName() + context.getStartDate() + "Total no of test case Skipped: " + context.getSkippedTests());
	}

	public void onTestStart(ITestResult result)
	{
		ReusableMethods.log(" Execution of the test case is Started: " + "Test case is: " + result.getMethod());
	}

	public void onTestSuccess(ITestResult result)
	{
		ExtentReporter.logPassedTestOnExtentReport(result.getName());
		ReusableMethods.log(" Execution of the test case is Success " + "Test case is: " + result.getMethod());
	}

	public void onTestFailure(ITestResult result)
	{
		ExtentReporter.logfailedTestOnExtentReport(result.getName());
		ReusableMethods.log(" Execution of the test case is failed " + "Test case is: " + result.getMethod());
	}

	public void onTestSkipped(ITestResult result)
	{

		ExtentReporter.logSkippedTestOnExtentReport(result.getName());
		ReusableMethods.log(" Execution of the test case is Skipped " + "Test case is: " + result.getMethod() );
	}

	/*
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		BasePage.log(result.getMethod());
	}

	 */
}
