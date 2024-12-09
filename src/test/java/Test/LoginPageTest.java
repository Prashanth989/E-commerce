package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageFactory.LoginPage;
import Utils.ReadPropertiesFile;
import Utils.ReusableMethods;

public final class LoginPageTest extends BaseTest 
{

	LoginPage login;
	
	
	@Test(priority = 4)
	public void loginTest() throws IOException 
	{
		login = new LoginPage();
		
		String username = ReadPropertiesFile.getValve("userName");
		String pin = ReadPropertiesFile.getValve("userPin");
		
		String myAccountTitle = login.login(username, pin);

		
		ReusableMethods.log("----- Logging in with " + username + " " + pin  + " Title of the dashboard screen " + myAccountTitle);
		Assert.assertEquals(myAccountTitle, "My Account", "My Account title is not matched, Redirection to My Account Page is failed");
	}
}

