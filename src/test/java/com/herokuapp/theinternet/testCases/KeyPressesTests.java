package com.herokuapp.theinternet.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.pageObjects.KeyPressesPage;
import com.herokuapp.theinternet.pageObjects.WelcomePage;

import base.TestUtilities;

public class KeyPressesTests extends TestUtilities{
	@Test(groups= {"master"})
	public void keyPressesTests() {
		SoftAssert sa = new SoftAssert();
		WelcomePage welcome =  new WelcomePage(driver,log);
		KeyPressesPage keyPress = welcome.clickKeyPresses();
		String input = "Test";
		String[] arr = keyPress.typeText(input);
		sa.assertEquals(keyPress.validateData(arr), true,"No match");
		sa.assertAll();
	}

}
