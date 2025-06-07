package PageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverFactory;
import Utils.ReusableMethods;

public class HeaderCategories {
	@FindBy(xpath = "//div[@id='top-links']//span[@class='hidden-xs hidden-sm hidden-md']")
	List<WebElement> headerItems;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li")
	List<WebElement> myAccountDropdownElements;

	public HeaderCategories() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public void selectMyAccountDropdownItem(String dropdownElement) {

		ReusableMethods.selectWebElementFromList(this.myAccountDropdownElements, dropdownElement);
	}

	public List<String> getMyAccountDropdownElementsText() {

		return ReusableMethods.fetchTextFromList(this.myAccountDropdownElements);

	}

	public LoginPage goToLogin(String dropdownText) {
		selectMyAccountDropdownItem(dropdownText);
		LoginPage login = new LoginPage();
		return login;
	}

	public void selectHeaderItem(String headerItem) {

		ReusableMethods.selectWebElementFromList(this.headerItems, headerItem);
	}

	public ShoppingCartPage goToShoppingCart(String item) {
		selectHeaderItem("Shopping Cart");

		ShoppingCartPage shoppingCart = new ShoppingCartPage();
		return shoppingCart;
	}

	public CheckOutPage goToCheckOut(String item) {
		selectHeaderItem("Shopping Cart");

		CheckOutPage checkOut = new CheckOutPage();
		return checkOut;
	}

	public WhishListPage goToWhishlist(String item) {
		selectHeaderItem("Shopping Cart");

		WhishListPage wishList = new WhishListPage();
		return wishList;
	}

	public List<String> getHeaderItemsTexts() {
		List<String> headerItems = ReusableMethods.fetchTextFromList(this.headerItems);
		return headerItems;
	}

}
