package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports extent;
	public static ExtentTest test;

	public static void intializeTheExtentReport() {
		ExtentSparkReporter Spark = new ExtentSparkReporter(
				Variables.locProject + "/Extentreport/E-commerce_Report.html");

		Spark.config().setDocumentTitle(Variables.extentReportTitle);

		Spark.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(Spark);

		extent.setSystemInfo("Application Url", "https://naveenautomationlabs.com");
		extent.setSystemInfo("Reporter", "Selenium");
		extent.setSystemInfo("Application Name", Variables.applicationName);

	}

	public static void logSkippedTestOnExtentReport(String nameOfTheTest) {
		test = extent.createTest(nameOfTheTest);
		test.log(Status.SKIP, "Test case: " + nameOfTheTest + " is Skipped");
	}

	public static void logPassedTestOnExtentReport(String nameOfTheTest) {
		test = extent.createTest(nameOfTheTest);
		test.log(Status.PASS, "Test case: " + nameOfTheTest + " is Passed");
	}

	public static void logfailedTestOnExtentReport(String nameOfTheTest) {
		test = extent.createTest(nameOfTheTest);
		test.log(Status.FAIL, "Test case: " + nameOfTheTest + " is failed");
	}

	public static void flushExtent() {
		extent.flush();
	}
}
