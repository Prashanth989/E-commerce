package PageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Base.DriverFactory;
import Utils.ReusableMethods;

public final class MyAccountPage {
	@FindBy(xpath = "//div[@id='content']//h2")
	List<WebElement> myAccountSub;

	@FindBy(xpath = "//div[@id='account-account']//a")
	List<WebElement> myAccountSectionLinks;

	@FindBy(xpath = "//img[@title='naveenopencart']")
	WebElement logo;

	public MyAccountPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public List<String> getMyAccountSectionLinksText() {
		return ReusableMethods.fetchTextFromList(myAccountSectionLinks);
	}

	public void navigateToHomeScreenOnSelectingLogo() {
		ReusableMethods.waitAndClick(logo);
		
	}
}
