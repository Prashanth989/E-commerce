package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.DriverFactory;
import PageFactory.HeaderCategories;
import PageFactory.LoginPage;
import Utils.ReadPropertiesFile;
import Utils.ReusableMethods;

public final class LoginPageTest extends BaseTest {

	HeaderCategories categories;
	LoginPage login;
	
	
	@Test(priority = 9)
	public void loginTest() throws IOException, InterruptedException {
		login = new LoginPage();

		String username = ReadPropertiesFile.getValve("userName");
		String pin = ReadPropertiesFile.getValve("userPin");

		login.login(username, pin);

		String loginTitle = DriverFactory.getDriver().getTitle();
		
		ReusableMethods.log(
				"----- Logging in with " + username + " " + pin + " Title of the dashboard screen " + loginTitle);
		Assert.assertEquals(loginTitle, "My Account",
				"My Account title is not matched, Redirection to My Account Page is failed");
	}
}
