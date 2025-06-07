package Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utils.ReadPropertiesFile;
import Utils.RemoteBrowser;
import Utils.ReusableMethods;
import Utils.Variables;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver driver;
	static String remoteBrowserName;
	static String remoteBrowserVersion;

	public static void initialiseBrowser(String browserToLaunch) throws IOException {
		try {

			System.out.println(Thread.currentThread().getId() + ":" + BrowserFactory.driver);
			if (DriverFactory.getDriver()==null) {
				switch (browserToLaunch) {
				case "Chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					remoteBrowserName = RemoteBrowser.getBrowserName();
					remoteBrowserVersion = RemoteBrowser.getBrowserVersion();
					break;

				case "Firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					remoteBrowserName = RemoteBrowser.getBrowserName();
					remoteBrowserVersion = RemoteBrowser.getBrowserVersion();
					break;

				case "Internet Explorer":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					remoteBrowserName = RemoteBrowser.getBrowserName();
					remoteBrowserVersion = RemoteBrowser.getBrowserVersion();
					break;

				default:
					System.out.println("No browser Parameter is Supplied to initialise the browser");
				}

			}
		}

		catch (Exception e) {
			ReusableMethods.log("Browser is not initialised, due to the Exception: " + e.getMessage());
		}
		DriverFactory.setDriver(driver);
		DriverFactory.getDriver().manage().window().maximize();
		System.out.println("Driver: Thread: " + DriverFactory.getDriver() + " : " + Thread.currentThread().getId() +" Is Running");
		DriverFactory.getDriver().get(ReadPropertiesFile.getValve("applicationUrl"));
		DriverFactory.getDriver().manage().timeouts()
		.pageLoadTimeout(Duration.ofSeconds(Variables.pageLoadTimeOut));
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Variables.impliicitWait));
	}


	public static void quitBrowser() {
		if (DriverFactory.getDriver()!=null) {
			System.out.println("Driver: Thread: " + DriverFactory.getDriver() + " : " + Thread.currentThread().getId() +" Is Closing");

			DriverFactory.remove();
		}
	}

}
