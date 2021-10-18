package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.MealPage;

public class MealItemTest extends BasicTest{

	//add meal

	@Test
	public void addMealToCart() throws InterruptedException {

		driver.get(this.baseURL + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(2000);
		locationPopupPage.closePopupLocation();
		Thread.sleep(1000);
		mealPage.addToCart("4");
		Thread.sleep(3000);
		
		Assert.assertTrue(notificationSystemPage.getNotificationText().contains("The Following Errors Occurred:" +"\n" + "Please Select Location"), "[ERROR]: Notification 'The Following Errors Occurred: Please Select Location' was not displayed");
        
		Thread.sleep(5000);
		notificationSystemPage.invisibleNotification();
     	Thread.sleep(2000);
		
     	locationPopupPage.openPopupLocation();
		locationPopupPage.setLocation("City Center - Albany");
		Thread.sleep(2000);
    	mealPage.addToCart("4");
		Thread.sleep(3000);
		
		Assert.assertTrue(notificationSystemPage.getNotificationText().contains("Meal Added To Cart"), "[ERROR]: Notification 'Meal Added To Cart' was not displayed");
		Thread.sleep(2000);
	}
	
	//add to favorite
	
	@Test
	public void addMealToFavorite() throws InterruptedException {
		driver.get(this.baseURL + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(2000);
		locationPopupPage.closePopupLocation();
		Thread.sleep(1000);
		mealPage.addToFavourite();
		Thread.sleep(2000);
		
		Assert.assertTrue(notificationSystemPage.getNotificationText().contains("Please login first!"), "[ERROR]: Notification 'Please login first!' was not displayed");
		Thread.sleep(2000);
		
		driver.get(this.baseURL + "/guest-user/login-form");
		Thread.sleep(2000);
		loginPage.userLogin(email, password);
		Thread.sleep(1000);
		
		driver.get(this.baseURL+ "/meal/lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(2000);
		mealPage.addToFavourite();
		Thread.sleep(2000);
		Assert.assertTrue(notificationSystemPage.getNotificationText().contains("Product has been added to your favorites."), "[ERROR]: Notification 'Product has been added to your favorites.' was not displayed");
		Thread.sleep(2000);
		
	}
	
	//clear cart
	
	@Test
	public void clearCart() throws InterruptedException, IOException {
		driver.get(this.baseURL + "/meals");
		SoftAssert sa=new SoftAssert();
		locationPopupPage.setLocation("City Center - Albany");
		Thread.sleep(3000);
		File file=new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetMeals = wb.getSheet("Meals");
		
		for (int i = 1; i < sheetMeals.getLastRowNum(); i++) {
			String meal=sheetMeals.getRow(i).getCell(0).getStringCellValue();
			driver.navigate().to(meal);
			Thread.sleep(2000);
			mealPage.addToCart("3");
			Thread.sleep(3000);
			
			Assert.assertTrue(notificationSystemPage.getNotificationText().contains("Meal Added To Cart"), "[ERROR]: Notification 'Meal Added To Cart' was not displayed");
			Thread.sleep(2000);
	
		}
		
		sa.assertAll();
		cartSummaryPage.ClearAll();
		Thread.sleep(2000);
		Assert.assertTrue(notificationSystemPage.getNotificationText().contains("All meals removed from Cart successfully"), "[ERROR]: Notification 'All meals removed from Cart successfully' was not displayed");
		Thread.sleep(2000);
		
	}

	
	
}
