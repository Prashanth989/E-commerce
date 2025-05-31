package Base;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	public static DriverFactory instance = new DriverFactory();

	public static ThreadLocal<WebDriver> thread = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {

		return thread.get();
	}

	public static DriverFactory getInstance() {
		return instance;
	}

	public void setDriver(WebDriver driver) {
		thread.set(driver);
	}

}
