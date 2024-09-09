package com.herokuapp.theinternet.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.pageObjects.DropdownPage;
import com.herokuapp.theinternet.pageObjects.WelcomePage;

import base.TestUtilities;

public class DropDownTests extends TestUtilities{

	@Test(groups= {"master","regression"})
	public void dropDownTest() {
		SoftAssert sa = new SoftAssert();
		WelcomePage welcome  =new WelcomePage(driver,log);
		DropdownPage drop = welcome.clickDropdown();
		log.info("Selecting Option 2");
		drop.selectOption("2");		
		sa.assertEquals(drop.returnSelectedOption(), "Option 2", "No Match");  
		sa.assertAll();
	
	}

}
