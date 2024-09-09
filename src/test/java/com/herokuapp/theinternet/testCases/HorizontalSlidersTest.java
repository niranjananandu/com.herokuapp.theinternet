package com.herokuapp.theinternet.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.pageObjects.HorizontalSliderPage;
import com.herokuapp.theinternet.pageObjects.WelcomePage;

import base.TestUtilities;

public class HorizontalSlidersTest extends TestUtilities{
	@Test(groups= {"master","regression"})
	public void horizontalSliderTest() {
		SoftAssert sa = new SoftAssert();
		WelcomePage welcome =  new WelcomePage(driver,log);
		HorizontalSliderPage horizontalSlider = welcome.clickHorizontalSlider();
		String val = horizontalSlider.moveSliderByValueAndReturn(3);
		if(val!=null) {
			
			sa.assertEquals(val, "3");
		}
		else {
			sa.assertTrue(false);
		}
		
		sa.assertAll();
	}

}
