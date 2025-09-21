package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageFactory.WhishListPage;

public class WishListPageTest extends BaseTest {
	WhishListPage wishlist;

	@Test(priority = 17)
	public void verifySelectedProductIsAddedIntoTheWishlist() {
		wishlist = new WhishListPage();
		String wishListProductTitle = wishlist.getWishListProductTitle();
		Assert.assertEquals(wishListProductTitle, "iPhone", "Wrong Product Is Shown In the Wish list");
	}

	@Test(priority = 18)
	public void verifySelectedProductIsRemovedFromTheWishlist() {
		wishlist.removeProductFromWishList();
		String removedFromWishListSuccessMessageText = wishlist.getRemovedFromWishListSuccessMessage();
		Assert.assertEquals(removedFromWishListSuccessMessageText, "Your wish list is empty.",
				"Product is not removed from the Wish list");
	}
}
