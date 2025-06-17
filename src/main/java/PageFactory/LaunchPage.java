package PageFactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.DriverFactory;
import Utils.ReusableMethods;

public final class LaunchPage {

	@FindBy(xpath = "//button[@class='btn btn-link dropdown-toggle']")
	WebElement currencyDropdown;

	@FindBy(xpath = "//div[@class='btn-group open']//li")
	List<WebElement> currencies;

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li")
	List<WebElement> gadgets;
	
	@FindBy(id = "carousel0")
	WebElement sliderWidget;
	
	@FindBy(css = ".swiper-button-next")
	WebElement sliderNext;

	public LaunchPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public String getLaunchTitle() {
		String launchTitle = ReusableMethods.getTitle();
		return launchTitle;
	}

	public boolean isCurrencyDropdownDisplaying() {
		return this.currencyDropdown.isDisplayed();
	}

	public List<String> getCurrencies() {
		selectCurrency();
		List<String> currencies = ReusableMethods.fetchTextFromList(this.currencies);
		return currencies;
	}

	public void selectCurrency() {
		ReusableMethods.waitAndClick(currencyDropdown);
	}

	public List<String> getGadgetsTitles() {
		List<String> gadgets = ReusableMethods.fetchTextFromList(this.gadgets);
		return gadgets;
	}

	public boolean isSliderImageLoading() throws InterruptedException
	{
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", sliderWidget);
		ReusableMethods.waitAndClick(sliderNext);
		
		Thread.sleep(1000);
		
		 WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
         WebElement activeSlide = wait.until(
             ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".swiper-slide.swiper-slide-active img"))
         );
		
          String attribute = activeSlide.getAttribute("src");
          System.out.println("Image source of the Slider Widget which is active: " +attribute);
         
          
          JavascriptExecutor js = (JavascriptExecutor)DriverFactory.getDriver();
          Boolean imageLoaded = (Boolean) js.executeScript(
              "return arguments[0].complete && " +
              "typeof arguments[0].naturalWidth != 'undefined' && " +
              "arguments[0].naturalWidth > 0;", activeSlide);
          
          System.out.println("Slider image is loading: " + imageLoaded);
          return imageLoaded;
	}
}
