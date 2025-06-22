package Base;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Utils.ReadPropertiesFile;
import Utils.RemoteBrowser;
import Utils.Variables;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class BrowserFactory {

	public static WebDriver driver;

	public static void initialiseBrowser(String browserToLaunch) throws IOException {
		try {

			System.out.println("Thread: " + Thread.currentThread().getId() +" " + "Valve of the thread: " + BrowserFactory.driver);
			if (DriverFactory.getDriver() == null) {
				switch (browserToLaunch) {
				case "Chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;

				case "Firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;

				case "Internet Explorer":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;

				default:

					throw new Exception("Invalid browser parameter is given from the testng.xml - parameterisation section");
				}

			}
		}

		catch (Exception e) {
			System.out.println("Invalid browser parameter is given from the testng.xml - parameterisation section\nException got in the class: " + e.getStackTrace()[0].getClassName());
			e.printStackTrace();
		}

		String remoteBrowserName = RemoteBrowser.getBrowserName();
		System.out.println("Name of the browser: " + remoteBrowserName);
		String remoteBrowserVersion = RemoteBrowser.getBrowserVersion();
		System.out.println("Version of the browser: " + remoteBrowserVersion);

		DriverFactory.setDriver(driver);
		DriverFactory.getDriver().manage().window().maximize();
		System.out.println("Thread: " + Thread.currentThread().getId() +" Is Running in " + DriverFactory.getDriver());
		System.out.println("---------- Application Url: " + ReadPropertiesFile.getValve("applicationUrl") + " Is launching ----------");
		DriverFactory.getDriver().get(ReadPropertiesFile.getValve("applicationUrl"));
		DriverFactory.getDriver().manage().timeouts()
		.pageLoadTimeout(Duration.ofSeconds(Variables.pageLoadTimeOut));
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Variables.impliicitWait));
	}


	public static void quitBrowser() {
		try {
			if (DriverFactory.getDriver()!=null) {
				System.out.println("Driver: Thread: " + DriverFactory.getDriver() + " : " + Thread.currentThread().getId() +" Is Closing");

				DriverFactory.remove();
			}
		}

		catch(Exception e)
		{
			System.out.println(Thread.currentThread().getId() + " " + "is not closed\nException got in the class: " + e.getStackTrace()[0].getClassName());
			e.printStackTrace();
		}
	}

}
