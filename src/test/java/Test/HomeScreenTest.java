package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.DriverFactory;
import PageFactory.HomePage;

public final class HomeScreenTest extends BaseTest {

	HomePage afterLogin;

	@Test(priority = 12)
	public void navigationTestToProductDetailsPage() {
		afterLogin = new HomePage();
		afterLogin.selectProductFromFeaturedCollection();
		String productTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals(productTitle, "iPhone",
				"Product name is not matched, Navigation test to Selected Product deatils Page is failed");
	}
}
