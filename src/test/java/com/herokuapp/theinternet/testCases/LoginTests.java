package com.herokuapp.theinternet.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.pageObjects.FormAuthenticationPage;
import com.herokuapp.theinternet.pageObjects.SecureAreaPage;
import com.herokuapp.theinternet.pageObjects.WelcomePage;

import base.TestUtilities;

public class LoginTests extends TestUtilities{

	@Test	
	public void positiveLoginTest() throws IOException {
		log.info("Starting Positive Login Tests");
		
		WelcomePage welcome = new WelcomePage(driver);
		SoftAssert sa  =new SoftAssert();	
		FormAuthenticationPage form = welcome.clickFormAuth();
		form.typeUsername("tomsmith");
		form.typePassword("SuperSecretPassword!");		
		SecureAreaPage secure = form.clickLoginSuccess();
		sa.assertTrue(secure.LogoutIsDisplayed(),"Logout button is not visible");
		sa.assertTrue(secure.getSuccessMessage().contains("You logged into a secure area!"),"No match");
		secure.clickLogout();
		sa.assertAll();	
		
	}

	@Test(dataProvider="NegativeLoginTest")
	public void negativeLoginTest(String username, String password, String validity, String expectedMessage) throws IOException {
		log.info("Starting Negative Login Tests");		
		WelcomePage welcome = new WelcomePage(driver);
		SoftAssert sa  =new SoftAssert();	
		FormAuthenticationPage form = welcome.clickFormAuth();
		form.typeUsername(username);
		form.typePassword(password);		
		form.clickLoginFail();
		sa.assertTrue(form.returnValidationMessage().contains(expectedMessage),"No match");
		sa.assertAll();	
		
	}


}
