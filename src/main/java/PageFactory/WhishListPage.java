package PageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverFactory;
import Utils.ReusableMethods;

public class WhishListPage
{
	@FindBy(xpath = "//td[@class = 'text-center']/a/img")
	List<WebElement> WishListProducts;

	@FindBy(xpath = "//a[@class='btn btn-danger']")
	WebElement removeFromWhishList;

	@FindBy(xpath = "//div[@id='content']/p")
	WebElement removedFromWishListSuccessMessage;


	public WhishListPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public String getWishListTitle()
	{
		String wishListTitle = ReusableMethods.getTitle();
		return wishListTitle;
	}

	public String getWishListProductTitle()
	{
		String wishListProductAttributeValve = "";
		for(WebElement wishListProduct: WishListProducts)
		{
			wishListProductAttributeValve = wishListProduct.getAttribute("title");
			System.out.println(wishListProductAttributeValve);
		}

		return wishListProductAttributeValve;
	}





	public void removeProductFromWishList()
	{
		ReusableMethods.waitAndClick(removeFromWhishList);
	}


	public String getRemovedFromWishListSuccessMessage()
	{
		String removedFromWishListSuccessMessageText = ReusableMethods.getText(removedFromWishListSuccessMessage);
		return removedFromWishListSuccessMessageText;
	}
}
