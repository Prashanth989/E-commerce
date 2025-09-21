package Test;

import org.testng.annotations.Test;

import PageFactory.HeaderCategories;
import PageFactory.LaunchPage;
import Utils.Variables;

import java.util.List;

import org.testng.Assert;

public final class LunchPageTest extends BaseTest {

	HeaderCategories categories;
	LaunchPage beforeLogin;

	@Test(priority = 1)
	public void launchScreenTitleTest() {
		beforeLogin = new LaunchPage();
		String launchTitle = beforeLogin.getLaunchTitle();
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
		List<String> currencies = beforeLogin.getCurrencies();
		Assert.assertNotNull(currencies, "Currencies are not Shown");
		beforeLogin.selectCurrency();
	}

	@Test(priority = 4)
	public void isTopItemsAreShown() {
		categories = new HeaderCategories();
		List<String> headerItems = categories.getHeaderItemsTexts();
		Assert.assertNotNull(headerItems, "Header Items were not Shown");
	}

	@Test(priority = 5)
	public void gadgetsAreShown() {
		List<String> gadgets = beforeLogin.getGadgetsTitles();
		Assert.assertNotNull(gadgets, "gadgets are not Shown");
	}

	@Test(priority = 8)
	public void launchScreenMyAccountDropdownOptionsTitleTest() {
		categories.selectHeaderItem("My Account");
		List<String> dropdownTitles = categories.getMyAccountDropdownElementsText();
		Assert.assertNotNull(dropdownTitles, "My Account dropdown titles are null");
	}

	@Test(priority = 9)
	public void loginScreenNavigationTest() {
		String link = categories.goToLogin("Login");
		boolean isNavigating = link.contains("/login");
		Assert.assertTrue(isNavigating, "Login page title is not matched, Redirection to login screen is failed");
	}
}
