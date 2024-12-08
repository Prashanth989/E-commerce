package Base;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Utils.ReadPropertiesFile;
import Utils.RemoteBrowser;
import Utils.ReusableMethods;
import Utils.Variables;

public class DriverManager
{
	public static WebDriver driver;

	static String remoteBrowserName;
	static String remoteBrowserVersion;

	static String browserToLaunch;


	public static WebDriver getDriver() 
	{

		return driver;
	}

	public static void initializeDriver() throws IOException
	{
		try
		{
			browserToLaunch = ReadPropertiesFile.getValve("browserName");
			if (browserToLaunch.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();

				remoteBrowserName = RemoteBrowser.getBrowserName();
				ReusableMethods.log("Name of the browser initialized: " + remoteBrowserName);

				remoteBrowserVersion = RemoteBrowser.getBrowserVersion();
				ReusableMethods.log("Version of the browser:" + remoteBrowserVersion);
			}

			else if (browserToLaunch.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();

				remoteBrowserName = RemoteBrowser.getBrowserName();
				ReusableMethods.log("Name of the browser initialized: " + remoteBrowserName);

				remoteBrowserVersion = RemoteBrowser.getBrowserVersion();
				ReusableMethods.log("Version of the browser:" + remoteBrowserVersion);
			}

			else if (browserToLaunch.equalsIgnoreCase("Internet Explorer"))
			{
				driver = new InternetExplorerDriver();

				remoteBrowserName = RemoteBrowser.getBrowserName();
				ReusableMethods.log("Name of the browser initialized: " + remoteBrowserName);

				remoteBrowserVersion = RemoteBrowser.getBrowserVersion();
				ReusableMethods.log("Version of the browser:" + remoteBrowserVersion);
			}

		}

		catch(Exception e)
		{
			ReusableMethods.log("Web browser is not initialized due to the Exception: " + e.getMessage());
		}



		driver.manage().window().maximize();
		driver.get(ReadPropertiesFile.getValve("applicationUrl"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Variables.pageLoadTimeOut));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Variables.impliicitWait));
	}

	public static void quitDriver()
	{

		driver.quit();
	}

}
