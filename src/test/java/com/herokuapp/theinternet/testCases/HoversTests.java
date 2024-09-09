package com.herokuapp.theinternet.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.pageObjects.HoversPage;
import com.herokuapp.theinternet.pageObjects.WelcomePage;

import base.TestUtilities;

public class HoversTests extends TestUtilities{
	@Test(groups= {"master"})
	public void hoversTest() {
		SoftAssert sa = new SoftAssert();
		WelcomePage welcome = new WelcomePage(driver,log);
		HoversPage hovers = welcome.clickHovers();
		
		String user="1";
		log.info("Hovering over User:",user);
		hovers.hoverOverUserProfile(user);
		sa.assertTrue(hovers.returnCurrentURL().contains("/users/"+user));  
		sa.assertAll();
	}

}
