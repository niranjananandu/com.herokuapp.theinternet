package com.herokuapp.theinternet.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.pageObjects.JSAlertsPage;
import com.herokuapp.theinternet.pageObjects.WelcomePage;

import base.TestUtilities;

public class JSAlertsTests extends TestUtilities{
	
	@Test(groups= {"master"})
	public void jsAlertTests() {
		SoftAssert sa = new SoftAssert();
		WelcomePage welcome =  new WelcomePage(driver,log);
		JSAlertsPage jsAlerts = welcome.clickJSAlerts();
		log.info("Clicking JS Alert");
		jsAlerts.clickJSAlert();		
		sa.assertEquals(jsAlerts.getAlertText(), "I am a JS Alert","No match");
		jsAlerts.acceptAlert();
		log.info("Getting result text");
		sa.assertEquals(jsAlerts.getResultText(), "You successfully clicked an alert","No match");
		takeScreenshot();
		sa.assertAll();
}
	@Test(groups= {"master","regression"})
	public void jsConfirmTests() {
		SoftAssert sa = new SoftAssert();
		WelcomePage welcome =  new WelcomePage(driver,log);
		JSAlertsPage jsAlerts = welcome.clickJSAlerts();
		log.info("Clicking JS Confirm");
		jsAlerts.clickJSConfirm();		
		sa.assertEquals(jsAlerts.getAlertText(), "I am a JS Confirm","No match");
		jsAlerts.acceptAlert();
		log.info("Getting result text");
		sa.assertEquals(jsAlerts.getResultText(), "You clicked: Ok","No match");
		takeScreenshot();
		
		jsAlerts.clickJSConfirm();		
		sa.assertEquals(jsAlerts.getAlertText(), "I am a JS Confirm","No match");
		jsAlerts.dismissAlert();
		log.info("Getting result text");
		sa.assertEquals(jsAlerts.getResultText(), "You clicked: Cancel","No match");
		takeScreenshot();
		
		sa.assertAll();
}
	@Test(groups= {"master"})
	public void jsPromptTests() {
		SoftAssert sa = new SoftAssert();
		WelcomePage welcome =  new WelcomePage(driver,log);
		JSAlertsPage jsAlerts = welcome.clickJSAlerts();
		log.info("Clicking JS Prompt");
		jsAlerts.clickJSPrompt();		
		sa.assertEquals(jsAlerts.getAlertText(), "I am a JS prompt","No match");
		jsAlerts.sendJSPromptText("This is a test");
		jsAlerts.acceptAlert();
		log.info("Getting result text");
		sa.assertEquals(jsAlerts.getResultText(), "You entered: This is a test","No match");
		takeScreenshot();
		
		jsAlerts.clickJSPrompt();		
		sa.assertEquals(jsAlerts.getAlertText(), "I am a JS prompt","No match");
		jsAlerts.sendJSPromptText("This is a test");
		jsAlerts.dismissAlert();
		log.info("Getting result text");
		sa.assertEquals(jsAlerts.getResultText(), "You entered: null","No match");
		takeScreenshot();
		
		
		sa.assertAll();

	
}
}