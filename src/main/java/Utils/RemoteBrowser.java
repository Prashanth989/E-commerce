package Utils;

import org.openqa.selenium.remote.RemoteWebDriver;

import Base.BrowserFactory;

public class RemoteBrowser {
	public static RemoteWebDriver remoteWebdriver;


	public static String getBrowserName() {
		remoteWebdriver = (RemoteWebDriver)BrowserFactory.driver;
		String browserName = remoteWebdriver.getCapabilities().getBrowserName();
		ReusableMethods.log("Name of the browser: " + browserName);
		return browserName;
	}

	public static String getBrowserVersion() {
		String browserVersion = remoteWebdriver.getCapabilities().getBrowserVersion();
		ReusableMethods.log("Browse Version: " + browserVersion);
		return browserVersion;
	}
}
