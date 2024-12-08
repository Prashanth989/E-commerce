package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageFactory.ProductDetails;

public final class ProductDetailsTest extends BaseTest
{

	ProductDetails details;

	@Test(priority = 8)
	public void productImageLinksStatusCodeTest() throws IOException 
	{


		details = new ProductDetails();

		boolean getValve = details.productLinkSourceValidation();
		Assert.assertFalse(getValve);


		int getStatus = details.getProductLinkStatusCode();
		Assert.assertEquals(getStatus, 200);
	}
}
