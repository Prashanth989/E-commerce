package Test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Base.BrowserFactory;


public class BaseTest {

	@Parameters({"Browser"})
	@BeforeTest
	public void launchBrowser(String browserToLaunch) throws IOException {
		BrowserFactory.initialiseBrowser(browserToLaunch);
	}

	@AfterTest
	public void tearDown() {
		BrowserFactory.quitBrowser();
	}
}
