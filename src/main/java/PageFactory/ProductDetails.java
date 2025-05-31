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

}
