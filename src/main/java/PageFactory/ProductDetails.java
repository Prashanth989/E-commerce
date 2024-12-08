package PageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;
import Utils.ReusableMethods;

public class ProductDetails
{

	@FindBy(xpath = "//ul[@class='thumbnails']//li//img")
	List<WebElement> productImageLinks;


	public ProductDetails()
	{
		PageFactory.initElements(DriverManager.driver, this);
	}


	public boolean productLinkSourceValidation()
	{
		boolean result = ReusableMethods.checkProductLinkSourceIsNotEmpty(productImageLinks, "src");
	    return result;
	}
		
	public int getProductLinkStatusCode()
	{
		int statusCode= ReusableMethods.checkStatusCodeOfLink(productImageLinks, "src");
		return statusCode;
	}

}
