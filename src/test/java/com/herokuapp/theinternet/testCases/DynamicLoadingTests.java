package com.herokuapp.theinternet.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.pageObjects.DynamicExample1Page;
import com.herokuapp.theinternet.pageObjects.DynamicLoadingPage;
import com.herokuapp.theinternet.pageObjects.WelcomePage;

import base.TestUtilities;

public class DynamicLoadingTests extends TestUtilities{
	@Test(groups= {"master"})
	public void dynamicLoadingTest() {
		
		SoftAssert sa = new SoftAssert();
		WelcomePage welcome  =new WelcomePage(driver,log);
		log.info("Navigating to Dynamic Loading Page");
		DynamicLoadingPage dynamic = welcome.clickDynamicLoading();
		log.info("Clicking on Example 1 link");
		DynamicExample1Page example1 = dynamic.clickExample1();
		log.info("Clicking Start button");
		example1.clickStart();
		sa.assertEquals(example1.returnFinalText(), "Hello World!","No match");
		sa.assertAll();
		
	}

}
