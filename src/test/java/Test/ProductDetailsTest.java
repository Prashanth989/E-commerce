package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import PageFactory.ProductDetails;
import Utils.Variables;


public final class ProductDetailsTest extends BaseTest {

	ProductDetails details;

	@Test(priority = 12)
	public void productImageLinksStatusCodeTest() throws IOException {
		details = new ProductDetails();
		boolean appResult = details.isProductLinkSourceEmpty();
		Assert.assertFalse(appResult, "Product link source Valve is empty");
		int linkStatus = details.getProductLinkStatusCode();
		Assert.assertEquals(linkStatus, 200, "Status Code of the Product is not 200");
	}

	@Test(priority = 13)
	public void checkProductIsAddedToWishList()
	{
		boolean isAddedToWishList = details.addToWishList();
		Assert.assertTrue(isAddedToWishList, "Selected Product Is Not Added in the Wish list");

	}

	@Test(priority = 14)
	public void navigationTestToWishList()
	{
		String wishListTitle = details.goToWishListPageFromProductDetails();
		Assert.assertEquals(wishListTitle, Variables.wishListTitle, "Wish list title is not matching");
	}
}
