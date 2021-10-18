package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}

	//Elements
	
	public WebElement getFirstName() {
		return driver.findElement(By.name("user_first_name"));
	}

	public WebElement getLastName() {
		return driver.findElement(By.name("user_last_name"));
	}

	public WebElement getEmail() {
		return driver.findElement(By.name("user_email"));
	}

	public WebElement getAddress() {
		return driver.findElement(By.name("user_address"));
	}

	public WebElement getPhone() {
		return driver.findElement(By.name("user_phone"));
	}

	public WebElement getZipCode() {
		return driver.findElement(By.name("user_zip"));
	}

	public WebElement getUploadBtn() {
		return driver.findElement(By.xpath("//a[@title='Uplaod']"));
	}

	public WebElement getRemoveBtn() {
		return driver.findElement(By.xpath("//a[@title='Remove']"));
	}

	public WebElement getSaveBtn() {
		return driver.findElement(By.xpath("//input[@name='btn_submit']"));
	}
	
	//Methods

	public void getCountry(String country) throws InterruptedException {
		WebElement countryElement = driver.findElement(By.id("user_country_id"));
		Select countrySelect = new Select(countryElement);
		countrySelect.selectByVisibleText(country);
		Thread.sleep(1500);
	}

	public void getState(String state) throws InterruptedException {
		WebElement stateElement = driver.findElement(By.id("user_state_id"));
		Select stateSelect = new Select(stateElement);
		stateSelect.selectByVisibleText(state);
		Thread.sleep(1500);
	}

	public void getCity(String city) throws InterruptedException {
		WebElement cityElement = driver.findElement(By.id("user_city"));
		Select citySelect = new Select(cityElement);
		citySelect.selectByVisibleText(city);
		Thread.sleep(1500);
	}

	public void uploadImage(String image) throws InterruptedException, AWTException {
		js.executeScript("arguments[0].click();", this.getUploadBtn());
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(3000);
		WebElement input = driver.findElement(By.xpath("//*[@id='form-upload']/input"));
		input.sendKeys(image);
	}

	public void removeImage() {
		js.executeScript("arguments[0].click();", this.getRemoveBtn());
	}

	public void updateProfileInformations(String firstName, String lastName, String email, String address, String phone,
			String zipCode) {
		this.getFirstName().clear();
		this.getLastName().clear();
		this.getAddress().clear();
		this.getPhone().clear();
		this.getZipCode().clear();

		this.getFirstName().sendKeys(firstName);
		this.getLastName().sendKeys(lastName);
		this.getAddress().sendKeys(address);
		this.getPhone().sendKeys(phone);
		this.getZipCode().sendKeys(zipCode);
	}
	
	public void saveBtn() {
		this.getSaveBtn().click();
	}

}
