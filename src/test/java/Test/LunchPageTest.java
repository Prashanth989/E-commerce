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
		
		String launchTitle = beforeLogin.getTitle();
		Assert.assertEquals(launchTitle, Variables.lunchTitle);
	}


	@Test(priority = 2)
	public void launchScreenMyAccountDropdownOptionsTitleTest() 
	{

		List<String> dropdownTitles = beforeLogin.getMyAccountDropdownElementsText();
		Assert.assertNotNull(dropdownTitles, "My Account button text is null");
	}


	@Test(priority = 3)
	public void loginScreenNavigationTest() 
	{

		beforeLogin.selectElementFromMyAccountDropdown();

		String loginScreenTitle = ReusableMethods.getTitle();
		ReusableMethods.log("----- Selected login button from launch screen, title found in the login screen " + loginScreenTitle + " ----- ");
		Assert.assertEquals(loginScreenTitle, Variables.loginScreenTitle);

	}
}
