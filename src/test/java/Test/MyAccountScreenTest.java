package Test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.DriverFactory;
import PageFactory.MyAccountPage;

public final class MyAccountScreenTest extends BaseTest {

	MyAccountPage myAccount;

	@Test(priority = 11)
	public void myAccountSectionLinksTitleTest() {
		myAccount = new MyAccountPage();
		List<String> myAccountSectionLinksTitle = myAccount.getMyAccountSectionLinksText();
		Assert.assertNotNull(myAccountSectionLinksTitle, "My Account section titles are null");
	}

	@Test(priority = 12)
	public void profileScreenToHomeScreenNavigationTest()  {
		myAccount.navigateToHomeScreenOnSelectingLogo();
		boolean isNavigating = DriverFactory.getDriver().getCurrentUrl().contains("/home");
		Assert.assertTrue(isNavigating, "Profile screen to home screen redirection is failed");
	}
}