package Test;

import org.testng.annotations.Test;

import PageFactory.LaunchPage;
import Utils.ReusableMethods;
import Utils.Variables;

import java.util.List;

import org.testng.Assert;

public final class LunchPageTest extends BaseTest {

	LaunchPage beforeLogin;

	@Test(priority = 1)
	public void launchScreenTitleTest() {
		beforeLogin = new LaunchPage();
		String launchTitle = beforeLogin.getLaunchScreenTitle();
		Assert.assertEquals(launchTitle, Variables.lunchTitle,
				"Launch Page title is not matched, Url failed to land on the launch page");
	}

	@Test(priority = 2)
	public void isCurrencyDropdownShown() {
		boolean isExist = beforeLogin.isCurrencyDropdownDisplaying();
		Assert.assertTrue(isExist, "Currency dropdown is not shown in the launch Page");
	}

	@Test(priority = 3)
	public void isCurrenciesAreShown() {
		beforeLogin.selectCurrency();

		List<String> currencies = beforeLogin.getCurrencies();
		Assert.assertNotNull(currencies, "Currencies are not Shown");

		beforeLogin.selectCurrency();
	}

	@Test(priority = 4)
	public void isTopItemsAreShown() {
		List<String> headerItems = beforeLogin.getHeaderItemsTexts();
		Assert.assertNotNull(headerItems, "Currencies are not Shown");
	}

	@Test(priority = 5)
	public void gadgetsAreShown() {
		List<String> gadgets = beforeLogin.getGadgetsTitles();
		Assert.assertNotNull(gadgets, "gadgets are not Shown");
	}

	@Test(priority = 6)
	public void launchScreenMyAccountDropdownOptionsTitleTest() {
		beforeLogin.selectItemFromHeader("My Account");
		List<String> dropdownTitles = beforeLogin.getMyAccountDropdownElementsText();
		Assert.assertNotNull(dropdownTitles, "My Account dropdown titles are null");
	}

	@Test(priority = 7)
	public void loginScreenNavigationTest() {
		beforeLogin.goTo("Login");
		String loginScreenTitle = ReusableMethods.getTitle();
		Assert.assertEquals(loginScreenTitle, Variables.loginScreenTitle,
				"Login page title is not matched, Redirection to login screen is failed");

	}
}
