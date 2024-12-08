package PageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;
import Utils.ReusableMethods;



public final class HomePage
{

	@FindBy(xpath = "//div[@class='product-thumb transition']//h4//a")
	List<WebElement> featuredCollection;

	public HomePage()
	{
		PageFactory.initElements(DriverManager.driver, this);
	}



	public String selectProductFromFeaturedCollection()
	{
		String productToBeSelect = "iPhone";
		ReusableMethods.selectWebElementFromList(featuredCollection, productToBeSelect);
		return ReusableMethods.getTitle();
	}
}
