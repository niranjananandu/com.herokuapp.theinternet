package com.herokuapp.theinternet.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.herokuapp.theinternet.pageObjects.GeolocationPage;
import com.herokuapp.theinternet.pageObjects.WelcomePage;

import base.TestUtilities;

public class GeolocationTests extends TestUtilities{
	@Test(groups= {"master","sanity"})
	public void geolocationTest() {
		SoftAssert sa = new SoftAssert();
		WelcomePage welcome =  new WelcomePage(driver,log);
		GeolocationPage geolocation = welcome.clickGeolocation();
		geolocation.clickLocation();
		sa.assertTrue(geolocation.verifyLocation(),"Location not displayed");
		sa.assertAll();
	}

}
