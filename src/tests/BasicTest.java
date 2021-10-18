package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

public abstract class BasicTest {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	protected ProfilePage profilePage;
	protected LocationPopupPage locationPopupPage;
	protected LoginPage loginPage;
	protected NotificationSystemPage notificationSystemPage;
	protected AuthPage authPage;
	protected MealPage mealPage;
	protected CartSummaryPage cartSummaryPage;
	String baseURL = "http://demo.yo-meals.com";
	String password = "12345678a";
	String email = "customer@dummyid.com";
	

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		locationPopupPage=new LocationPopupPage(driver, wait, js);
		loginPage=new LoginPage(driver, wait, js);
		profilePage=new ProfilePage(driver, wait, js);
		notificationSystemPage=new NotificationSystemPage(driver, wait, js);
		authPage=new AuthPage(driver, wait, js);
		mealPage=new MealPage(driver, wait, js);
		cartSummaryPage=new CartSummaryPage(driver, wait, js);
	}
 
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException {
		if (ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot scrShot = ((TakesScreenshot) this.driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			String imgName=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss'.png'").format(new Date());
			FileHandler.copy(SrcFile, new File("screenshots/" + imgName));
			Thread.sleep(2000);
			this.driver.quit();
		}

		else {
			this.driver.quit();
		}
	}

}
