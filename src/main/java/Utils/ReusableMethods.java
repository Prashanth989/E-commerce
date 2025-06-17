package Utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.DriverFactory;

public class ReusableMethods {
	public static String getTitle() {
		String title = null;
		try {
			title = DriverFactory.getDriver().getTitle();
			if (title == null || title.isEmpty()) {
				throw new NullPointerException("Title of the Page is null or empty, Please check");
			}
		}

		catch (Exception e) {
			System.out.println("Title of the page is not fetched, Exception seen is: " + e.toString());
			e.printStackTrace();
			ReusableMethods.log("Title of the Page is not fetched, Error found in run time, Exception seen in:" + " "
					+ "Exception message is:" + e.toString());
		}

		return title;

	}

	public static String getText(WebElement element) {
		String text = null;

		try {
			text = element.getText();
			System.out.println("Text of the element is: " + text);
		}

		catch (Exception e) {
			System.out.println("Text of the element is failed to fetech for the element: " + element + ":" + "Exception seen is: " + e.toString());
			e.printStackTrace();
		}

		return text;
	}

	public static void log(String toPrint) {
		Logger log = Logger.getLogger(Variables.locProject + "/src/main/resources/log4j.properties");
		log.info(toPrint);
	}

	public static void doMouseHover(WebElement element) {
		try {
			Actions select = new Actions(DriverFactory.getDriver());
			select.moveToElement(element).build().perform();
		}

		catch (Exception e) {
			System.out.println("Failed to perform mouse hover on the element: " + element + ":" + "Exception seen is: " + e.toString());
			ReusableMethods.log("Exception got on mouse hover: " + e.toString() + " " + "Element is:" + element);
			e.printStackTrace();
		}
	}

	public static List<String> fetchTextFromList(List<WebElement> elements) {

		ArrayList<String> addElementTitle = new ArrayList<String>();
		try {
			if(elements.size() == 0){
				throw new Exception("List of elements size is returned is 0, failed to fetch the text of elements, Please check");
			}
			else{
				for (WebElement element : elements) {
					String currentElementText = element.getText();
					System.out.println("Fetching of the text started \n Text returned: " + currentElementText);

					if (currentElementText != null) {
						addElementTitle.add(currentElementText);
					}

					else if(currentElementText == null)  {
						throw new NullPointerException("Text of the elements are null, Please check");
					}
				}
			}

		} 

		catch (Exception e) {
			System.out.println("Exception got when fetching the text of list of elements: " + elements);
			e.printStackTrace();
		}

		return addElementTitle;

	}

	public static void selectElementFromList(List<WebElement> allElement, String elementNeedToSelect) {

		try {
			if(allElement.size() == 0){
				throw new Exception("List of elements size is returned is 0, failed to select the element from the list, Please check");
			}

			else{
				for (WebElement currentWebElement : allElement) {
					String currentWebElementString = currentWebElement.getText();
					if (currentWebElementString != null && currentWebElementString.equals(elementNeedToSelect)) {

						System.out.println("Item: " + currentWebElementString + " Is Selected");
						ReusableMethods.waitAndClick(currentWebElement);
						break;
					}

					else if(currentWebElementString == null){
						throw new NullPointerException("Text of the element is null, failed to compare the text & selecting the element, Please check");
					}
				}
			}
		}

		catch (Exception e) {
			System.out.println("Exception got when selecting the element from the list: " + e.toString());
			ReusableMethods.log("Not able to Select the element, due to the exception " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void waitAndSendKeys(WebElement element, String input) {

		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),
					Duration.ofSeconds(Variables.explicitWait));
			wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(input);
		}

		catch (Exception e) {
			System.out.println("Exception got when waiting & sending the keys: " + e.toString());
			ReusableMethods.log("Not able to send the key's to the element: " + element.getText() + " "
					+ "Exeception got: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void waitAndClick(WebElement element) {

		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),
					Duration.ofSeconds(Variables.explicitWait));
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		}

		catch (Exception e) {
			System.out.println("Exception got when waiting & selecting the element: " + e.toString());
			ReusableMethods.log("Wait & Click: Element locator: " + element + "Not able to click: Element text: "
					+ element.getText() + " " + "Exeception got: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static int checkStatusCodeOfLink(List<WebElement> elements, String attributeValve) {
		int responseCode = 0;
		String sourceOfLink = null;
		try {

			for (WebElement product : elements) {
				sourceOfLink = product.getAttribute(attributeValve);

				URL url = new URL(sourceOfLink);

				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();

				responseCode = connection.getResponseCode();

				if (responseCode == HttpURLConnection.HTTP_OK) {
					System.out.println("Image URL is valid (Staus Code Is: " + responseCode + ") for the Product link:"
							+ sourceOfLink);
				} else {
					System.out.println("Image URL is broken (status code: " + responseCode + "): " + sourceOfLink);
				}
				connection.disconnect();
			}

		}

		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error accessing image URL: " + sourceOfLink + " - " + e.getMessage());
		}

		return responseCode;

	}

	public static boolean checkProductLinkSourceIsNotEmpty(List<WebElement> elements, String attributeValve) {
		boolean isEmpty = false;
		try {
			ReusableMethods.log("Total no of links found: " + elements.size());
			for (WebElement product : elements) {
				String productSource = product.getAttribute(attributeValve);
				ReusableMethods.log("Link: " + productSource);

				isEmpty = productSource.isEmpty();
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			ReusableMethods.log("Null check of the Element is failed: " + "following exceprion:" + e.getMessage());
		}

		return isEmpty;
	}

}
