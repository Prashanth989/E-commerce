package Test;

import org.testng.annotations.Test;

import PageFactory.LaunchPage;
import Utils.ReusableMethods;
import Utils.Variables;

import java.util.List;

import org.testng.Assert;

public final class LunchPageTest extends BaseTest 
{

	LaunchPage beforeLogin;


	@Test(priority = 1)
	public void launchScreenTitleTest() 
	{
		beforeLogin = new LaunchPage();
		
		String launchTitle = beforeLogin.getLaunchScreenTitle();
		Assert.assertEquals(launchTitle, Variables.lunchTitle, "Launch Page title is not matched, Url failed to land on the launch page");
	}


	@Test(priority = 2)
	public void launchScreenMyAccountDropdownOptionsTitleTest() 
	{

		List<String> dropdownTitles = beforeLogin.getMyAccountDropdownElementsText();
		Assert.assertNotNull(dropdownTitles, "My Account dropdown titles are null");
	}


	@Test(priority = 3)
	public void loginScreenNavigationTest() 
	{

		beforeLogin.selectElementFromMyAccountDropdown();

		String loginScreenTitle = ReusableMethods.getTitle();
		Assert.assertEquals(loginScreenTitle, Variables.loginScreenTitle, "Login page title is not matched, Redirection to login screen is failed");

	}
}
