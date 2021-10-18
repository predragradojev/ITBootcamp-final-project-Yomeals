package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);

	}
	
	//Elements

	public WebElement getLocation() {
		return driver.findElement(By.xpath("//*[@class='location-selector']")	);

	}

	public WebElement getCloseLocationBtn() {
		return driver.findElement(By.xpath("//*[@class='close-btn close-btn-white']"));
	}

	public WebElement getKeyword() {
		return driver.findElement(By.xpath("//input[@id='locality_keyword']"));
	}

	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}

	public WebElement getLocationInput() {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}

	public WebElement getSubmit() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}

	public void openPopupLocation() {
		this.getLocation().click();
	}
	
	//Methods

	public void setLocation(String locationName) throws InterruptedException {
		this.getKeyword().click();
		Thread.sleep(1000);
		this.getLocationItem(locationName).click();
		js.executeScript("arguments[0].click()", this.getSubmit());

	}

	public void closePopupLocation() {
		js.executeScript("arguments[0].click();", this.getCloseLocationBtn());
	}

}
