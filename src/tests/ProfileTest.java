package tests;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LocationPopupPage;
import pages.LoginPage;

public class ProfileTest extends BasicTest {

	//edit profile information

	@Test
	public void editProfile() throws InterruptedException {

		driver.get(this.baseURL + "/guest-user/login-form");
		Thread.sleep(2000);
		locationPopupPage.closePopupLocation();
		Thread.sleep(1000);
		loginPage.userLogin(email, password);
		Thread.sleep(1000);

		Assert.assertTrue(notificationSystemPage.getNotificationText().contains("Login Successfull"), "[ERROR]: Notification 'Login Successfull' was not displayed");

		driver.get(this.baseURL + "/member/profile");
		Thread.sleep(1000);
		profilePage.updateProfileInformations("Rambo", "Amadeus", "svetskimegacar@gmail.com", "Pante Jovovica 7", "067666666", "11000");
		Thread.sleep(2000);
		profilePage.getCountry("India");
		profilePage.getState("Goa");
		profilePage.getCity("Aldona");
		profilePage.saveBtn();
		Thread.sleep(2000);

		Assert.assertTrue(notificationSystemPage.getNotificationText().contains("Setup Successful"), "[ERROR]: Notification 'Setup Successful' was not displayed");

		Thread.sleep(2000);
		authPage.LogoutUser();
		Thread.sleep(2000);

		Assert.assertTrue(notificationSystemPage.getNotificationText().contains("Logout Successful"), "[ERROR]: Notification 'Logout Successful' was not displayed");

		Thread.sleep(2000);

	}

	//change profile photo

	@Test
	public void changeProfileImg() throws InterruptedException, AWTException, IOException {

		driver.get(this.baseURL + "/guest-user/login-form");
		Thread.sleep(2000);
		locationPopupPage.closePopupLocation();
		Thread.sleep(1000);
		loginPage.userLogin(email, password);
		Thread.sleep(1000);

		Assert.assertTrue(notificationSystemPage.getNotificationText().contains("Login Successfull"), "[ERROR]: Notification 'Login Successfull' was not displayed");

		driver.get(this.baseURL + "/member/profile");
		Thread.sleep(2000);
		String img = new File("img/rambo.jpg").getCanonicalPath();
		profilePage.uploadImage(img);
		Thread.sleep(2000);

		Assert.assertTrue(notificationSystemPage.getNotificationText().contains("Profile Image Uploaded Successfully"), "[ERROR]: Notification 'Profile Image Uploaded Successfully' was not displayed");

		Thread.sleep(2000);
		notificationSystemPage.invisibleNotification();
		Thread.sleep(2000);
		profilePage.removeImage();
		Thread.sleep(1000);
		
        Assert.assertTrue(notificationSystemPage.getNotificationText().contains("Profile Image Deleted Successfully"), "[ERROR]: Notification 'Profile Image Deleted Successfully' was not displayed");
		//Assert.assertTrue(notificationSystemPage.getNotificationText().contains("Profile Image Deleted Successfully"), "[ERROR]: Notification 'Profile Image Deleted Successfully' was not displayed");
		
		Thread.sleep(2000);
		notificationSystemPage.invisibleNotification();
		Thread.sleep(2000);
		authPage.LogoutUser();
		Thread.sleep(2000);

		Assert.assertTrue(notificationSystemPage.getNotificationText().contains("Logout Successful"), "[ERROR]: Notification 'Logout Successful' was not displayed");

		Thread.sleep(2000);
		
		
	}

}
	
	

