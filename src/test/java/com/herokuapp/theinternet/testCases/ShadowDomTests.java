package com.herokuapp.theinternet.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.pageObjects.ShadowDOMPage;
import com.herokuapp.theinternet.pageObjects.WelcomePage;

import base.TestUtilities;

public class ShadowDomTests extends TestUtilities{
@Test(groups= {"master","regression"})
	public void shadowDomTest() {
	SoftAssert sa = new SoftAssert();
	WelcomePage welcome =  new WelcomePage(driver,log);
	ShadowDOMPage shadow = welcome.clickShadowDOM();
	
	sa.assertTrue(shadow.getShadowText().contains("Let's have some different text!\r\n"
			+ "In a list!"),"Not found");
	
	
	}
}
