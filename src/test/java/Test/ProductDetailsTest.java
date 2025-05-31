package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import PageFactory.ProductDetails;

public final class ProductDetailsTest extends BaseTest {

	ProductDetails details;

	@Test(priority = 8)
	public void productImageLinksStatusCodeTest() throws IOException {
		details = new ProductDetails();
		boolean appResult = details.isProductLinkSourceEmpty();
		Assert.assertFalse(appResult, "Product link source Valve is empty");
		int linkStatus = details.getProductLinkStatusCode();
		Assert.assertEquals(linkStatus, 200, "Status Code of the Product is not 200");
	}
	
	
	
}
