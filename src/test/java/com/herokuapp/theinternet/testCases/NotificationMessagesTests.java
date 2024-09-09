package com.herokuapp.theinternet.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.pageObjects.NotificationMessagesPage;
import com.herokuapp.theinternet.pageObjects.WelcomePage;

import base.TestUtilities;

public class NotificationMessagesTests extends TestUtilities {
	@Test(groups= {"master","sanity"})
	public void notificationMessagesTest() {
		
		SoftAssert sa = new SoftAssert();
		WelcomePage welcome =  new WelcomePage(driver,log);
		NotificationMessagesPage notifications = welcome.clickNotificationMessages();
		System.out.println(notifications.getToastMessage());
		sa.assertTrue(notifications.getToastMessage().contains("Action")	,"No match");
		notifications.loadNewToast();
		sleep(10);
		System.out.println(notifications.getToastMessage());
		sa.assertTrue(notifications.getToastMessage().contains("Action"),"No match");
		sa.assertAll();
	}
}
