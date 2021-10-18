package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage {

	public NotificationSystemPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}

	//Elements
	
	public WebElement getElementNotification() {
		return driver.findElement(By.xpath("//*[contains(@class, 'system_message')]"));
	}

	public String getNotificationText() {
		return this.getElementNotification().getText();
	}
    
	//Methods
	
	public void invisibleNotification() {
		wait.until(ExpectedConditions.attributeContains(getElementNotification(), "style", "none"));
	}
}
