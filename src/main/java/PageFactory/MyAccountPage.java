package PageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;
import Utils.ReusableMethods;



public final class MyAccountPage
{
	@FindBy(xpath = "//div[@id='content']//h2")
	List<WebElement> myAccountSub;

	@FindBy(xpath = "//div[@id='account-account']//a")
	List<WebElement> myAccountSectionLinks;
	
	@FindBy(xpath = "//div[@id='logo']")
	WebElement logo;

	public MyAccountPage()
	{
		PageFactory.initElements(DriverManager.driver, this);
	}

	
	public List<String> getMyAccountSectionLinksText()
	{
		return ReusableMethods.fetchTextFromList(myAccountSectionLinks);
	}
	
	public boolean navigateToHomeScreenOnSelectingLogo()
	{
		ReusableMethods.waitAndClick(logo);
		return DriverManager.driver.getCurrentUrl().contains("/home");
	}
	
}
