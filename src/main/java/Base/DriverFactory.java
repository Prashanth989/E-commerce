package Base;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	public static ThreadLocal<WebDriver> thread = new ThreadLocal<>();

	public static WebDriver getDriver() {

		return thread.get();
	}

	public static void setDriver(WebDriver driver) {
		thread.set(driver);
	}

	public static void remove() {
		thread.get().quit();
		thread.remove();
	}

}
