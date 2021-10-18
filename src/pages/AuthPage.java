package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}
	
	//Elements

	public WebElement getUserDropDown() {
		return driver.findElement(By.xpath("//*[@id='header']//*[@class='filled ']/a"));
	}

	public WebElement getLogout() {
		return driver.findElement(By.xpath("//*[@id='header']//*[@class='my-account-dropdown']/ul/li[2]"));
	}

	public WebElement getMyAcc() {
		return driver.findElement(By.xpath("//a[@href='/member']"));
	}

	//Methods
	
	public void LogoutUser() throws InterruptedException {
        Thread.sleep(2000);
		this.getUserDropDown().click();
		Thread.sleep(2000);
		this.getLogout().click();
		
	}

}	
