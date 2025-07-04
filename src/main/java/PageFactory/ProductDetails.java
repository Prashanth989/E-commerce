package PageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverFactory;
import Utils.ReusableMethods;

public class ProductDetails {

	@FindBy(xpath = "//ul[@class='thumbnails']//li//img")
	List<WebElement> productImageLinks;
	
	@FindBy(xpath = "//button[@class='btn btn-default' and @data-original-title='Add to Wish List']")
	WebElement wishlist;

	@FindBy(xpath = "//a[@id='wishlist-total']")
	WebElement wishListModule;
	
	@FindBy(xpath = "//i[@class='fa fa-check-circle']")
	WebElement wishlistSuccessMessage;
	
	public ProductDetails() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public boolean isProductLinkSourceEmpty() {
		boolean result = ReusableMethods.checkProductLinkSourceIsNotEmpty(productImageLinks, "src");
		return result;
	}

	public int getProductLinkStatusCode() {
		int statusCode = ReusableMethods.checkStatusCodeOfLink(productImageLinks, "src");
		return statusCode;
	}

	public boolean addToWishList()
	{
		ReusableMethods.waitAndClick(wishlist);
		return this.wishlistSuccessMessage.isDisplayed();
	}
	
	public String goToWishListPageFromProductDetails()
	{
		ReusableMethods.waitAndClick(wishListModule);
		WhishListPage wishlist = new WhishListPage();
		String wishListTitle = wishlist.getWishListTitle();
		return wishListTitle;
		
	}
}
