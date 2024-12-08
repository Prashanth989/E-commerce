package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageFactory.HomePage;

public final class HomeScreenTest extends BaseTest
{

	HomePage afterLogin;

	@Test(priority = 7)
	public void productDetailNavigationTest() 
	{
		afterLogin = new HomePage();
		String productName= afterLogin.selectProductFromFeaturedCollection();
		Assert.assertEquals(productName, "iPhone");
	}
}
