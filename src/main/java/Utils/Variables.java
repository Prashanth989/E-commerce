package Utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Variables {

	public static String lunchTitle = "Your Store";
	public static String loginScreenTitle = "Account Login";
	public static int impliicitWait = 5;

	public static int explicitWait = 15;
	public static int threadSleep = 5;
	public static int pageLoadTimeOut = 9;

	public static String extentReportTitle = "Automation report";
	public static String applicationName = "Naveen Automation Open Cart";
	public static String locProject = System.getProperty("user.dir");
	
	
	public static ArrayList<String> currencies = new  ArrayList<String>(Arrays.asList("['€ Euro', '£ Pound Sterling', '$ US Dollar']"));
}
