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
		}

		catch (Exception e) {
			ReusableMethods.log("Title of the Page is not fetched, Exception seen in:" + e.getClass().getName() + " "
					+ "Exception message is:" + e.getMessage());
		}

		return title;

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
			ReusableMethods.log("Exception is:" + e.getMessage() + " " + "Element is:" + element);
			e.printStackTrace();
		}
	}

	public static List<String> fetchTextFromList(List<WebElement> elements) {

		ArrayList<String> addElementTitle = new ArrayList<String>();
		try {
			System.out.println("Total titles:" + elements.size());

			for (WebElement element : elements) {
				String currentElementText = element.getText();
				System.out.println("Title:" + currentElementText);

				if (currentElementText != null) {
					addElementTitle.add(currentElementText);
				}

				else {
					System.out.println("Element title is not fetched: " + element);
				}
			}

		} catch (Exception e) {
			// BasePage.log("Exception is:" + e.getMessage() + " " + "Element text is null:"
			// + element);
			e.printStackTrace();
		}

		return addElementTitle;

	}

	public static void selectWebElementFromList(List<WebElement> allElement, String elementNeedToSelect) {

		try {

			for (WebElement currentWebElement : allElement) {
				String currentWebElementString = currentWebElement.getText();
				if (currentWebElementString != null && currentWebElementString.equals(elementNeedToSelect)) {

					System.out.println("Element|" + currentWebElementString + " Is Selected");
					currentWebElement.click();
					break;
				}
			}
		}

		catch (Exception e) {
			ReusableMethods.log("Title of the element to be select is found null: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void waitAndSendKeys(WebElement element, String input) {

		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(Variables.explicitWait));
			wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(input);
		}

		catch (Exception e) {
			ReusableMethods.log("Not able to send the key's to the element: " + element.getText() + " "
					+ "Exeception got: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void waitAndClick(WebElement element) {

		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(Variables.explicitWait));
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		}

		catch (Exception e) {
			ReusableMethods.log("Wait & Click: Element locator: " + element + "Not able to click: Element text: " + element.getText() + " " + "Exeception got: "
					+ e.getMessage());
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
			ReusableMethods.log("Null check of the Element is failed: " + "following exceprion:" + e.getMessage());
		}

		return isEmpty;
	}

}
