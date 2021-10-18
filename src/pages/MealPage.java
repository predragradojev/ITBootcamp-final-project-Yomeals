package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}

	public WebElement getQty() {
		return driver.findElement(By.name("product_qty"));
	}

	public WebElement getFavouriteBtn() {
		return driver.findElement(By.xpath("//a[contains(@class, 'favourite')]"));
	}

	public WebElement getAddToCart() {
		return driver.findElement(By.xpath("//a[contains(@class, 'js-proceedtoAddInCart')]"));
	}

	public void addToCart(String quantity) throws InterruptedException {
		this.getQty().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		Thread.sleep(2000);
		this.getQty().sendKeys(quantity);
		js.executeScript("arguments[0].click();", this.getAddToCart());
	}

	public void addToFavourite() {
		js.executeScript("arguments[0].click();", this.getFavouriteBtn());
	}

}
