package Test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageFactory.MyAccountPage;

public final class MyAccountScreenTest extends BaseTest
{


	MyAccountPage myAccount;


	@Test(priority = 5)
	public void myAccountSectionLinksTitleTest() 
	{

		myAccount= new MyAccountPage();
		List<String> myAccountSectionLinksTitle = myAccount.getMyAccountSectionLinksText();
		
		Assert.assertNotNull(myAccountSectionLinksTitle);

	}


	@Test(priority = 6)
	public void profileScreenToHomeScreenNavigationTest() 
	{

		boolean isNavigating= myAccount.navigateToHomeScreenOnSelectingLogo();
		
		Assert.assertTrue(isNavigating);

	}

}