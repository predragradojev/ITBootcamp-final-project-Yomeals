package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage {

	public CartSummaryPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}

	//Elements
	
	public WebElement getClearAllBtn() {
		return driver.findElement(By.xpath("//a[contains(@class, 'btn btn--third')]"));
	}
	
	//Methods

	public void ClearAll() {
		js.executeScript("arguments[0].click();", this.getClearAllBtn());
	}

}