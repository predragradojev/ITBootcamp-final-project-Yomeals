package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}
	
	//Elements

	public WebElement getEmail() {
		return this.driver.findElement(By.name("username"));
	}

	public WebElement getPassword() {
		return this.driver.findElement(By.name("password"));

	}

	public WebElement getSubmit() {
		return this.driver.findElement(By.name("btn_submit"));
	}

	public WebElement getRememberMe() {
		return this.driver.findElement(By.name("remember_me"));
	}
	
	//Methods

	public void markRememberMe() {
		this.getRememberMe().click();
	}

	public void userLogin(String email, String password) throws InterruptedException {
		this.getEmail().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		Thread.sleep(1000);
		this.getPassword().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		Thread.sleep(1000);
		this.getEmail().sendKeys(email);
		Thread.sleep(1000);
		this.getPassword().sendKeys(password);
		Thread.sleep(1000);
		this.getSubmit().click();
	}

}
