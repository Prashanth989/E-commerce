package PageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverFactory;
import Utils.ReusableMethods;

public final class LaunchPage {
	@FindBy(xpath = "//span[text() ='My Account']")
	WebElement myAccountDropdown;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li")
	List<WebElement> myAccountDropdownElements;

	public LaunchPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public String getLaunchScreenTitle() {
		String launchScreenTitle = ReusableMethods.getTitle();
		return launchScreenTitle;
	}

	public void selectMyAccountDropdownButton() {
		ReusableMethods.waitAndClick(myAccountDropdown);
	}

	public void goTo() {

		String elementToSelect = "Login";
		ReusableMethods.selectWebElementFromList(this.myAccountDropdownElements, elementToSelect);
	}

	public List<String> getMyAccountDropdownElementsText() {
		this.selectMyAccountDropdownButton();
		return ReusableMethods.fetchTextFromList(this.myAccountDropdownElements);

	}

}
