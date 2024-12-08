package Test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Base.DriverManager;

public class BaseTest 
{

	@BeforeTest
	public static void lunchTheBrowser() throws IOException 
	{

		DriverManager.initializeDriver();
	}

	@AfterTest
	public static void quitBrowser()
	{
		DriverManager.quitDriver();
	}

}
