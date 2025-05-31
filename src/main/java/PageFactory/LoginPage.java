package PageFactory;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BrowserFactory;
import Base.DriverFactory;
import Utils.ReusableMethods;

public final class LoginPage {
	@FindBy(id = "input-email")
	WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	WebElement pasword;

	@FindBy(xpath = "//a[@text()='Forgotten Password']")
	WebElement forgetPasword;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement login;

	public LoginPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public String login(String email, String pasword) {

		ReusableMethods.waitAndSendKeys(this.email, email);
		ReusableMethods.waitAndSendKeys(this.pasword, pasword);

		ReusableMethods.waitAndClick(this.login);
		return BrowserFactory.driver.getTitle();
	}

	
}