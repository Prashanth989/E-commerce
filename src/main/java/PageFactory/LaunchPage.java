package PageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverFactory;
import Utils.ReusableMethods;

public final class LaunchPage {

	@FindBy(xpath = "//button[@class='btn btn-link dropdown-toggle']")
	WebElement currencyDropdown;

	@FindBy(xpath = "//div[@class='btn-group open']//li")
	List<WebElement> currencies;

	@FindBy(xpath = "//div[@id='top-links']//span[@class='hidden-xs hidden-sm hidden-md']")
	List<WebElement> headerItems;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li")
	List<WebElement> myAccountDropdownElements;

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li")
	List<WebElement> gadgets;

	public LaunchPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public boolean isCurrencyDropdownDisplaying() {
		return this.currencyDropdown.isDisplayed();
	}

	public List<String> getCurrencies() {
		List<String> currencies = ReusableMethods.fetchTextFromList(this.currencies);
		return currencies;
	}

	public void selectCurrency() {
		ReusableMethods.waitAndClick(currencyDropdown);
	}

	public List<String> getGadgetsTitles() {
		List<String> gadgets = ReusableMethods.fetchTextFromList(this.gadgets);
		return gadgets;
	}

	public void selectItemFromHeader(String headerItem) {

		ReusableMethods.selectWebElementFromList(headerItems, headerItem);
	}

	public void goTo(String dropdownElement) {

		ReusableMethods.selectWebElementFromList(this.myAccountDropdownElements, dropdownElement);
	}

	public List<String> getHeaderItemsTexts() {
		List<String> headerItems = ReusableMethods.fetchTextFromList(this.headerItems);
		return headerItems;
	}

	public List<String> getMyAccountDropdownElementsText() {

		return ReusableMethods.fetchTextFromList(this.myAccountDropdownElements);

	}

}
