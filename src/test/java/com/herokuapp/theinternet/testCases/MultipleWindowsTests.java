package com.herokuapp.theinternet.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.pageObjects.MultipleWindowsPage;
import com.herokuapp.theinternet.pageObjects.WelcomePage;

import base.TestUtilities;

public class MultipleWindowsTests extends TestUtilities {
	@Test(groups= {"master"})
	public void multipleWindowTest() {
		
		SoftAssert sa = new SoftAssert();
		WelcomePage welcome =  new WelcomePage(driver,log);
		MultipleWindowsPage windows = welcome.clickMultipleWindows();
		log.info("Opening new window");
		windows.openNewWindow();
		sa.assertTrue( windows.switchToChildWindow().contains("/windows/new"),"No match");
		sa.assertAll();
	
		
	}

}
