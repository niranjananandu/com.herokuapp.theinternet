package com.herokuapp.theinternet.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.pageObjects.EntryAdPage;
import com.herokuapp.theinternet.pageObjects.WelcomePage;

import base.TestUtilities;

public class EntryAdTests extends TestUtilities{
	@Test(groups=  {"master","regression"})
	public void entryAdTests() {
		SoftAssert sa = new SoftAssert();
		WelcomePage welcome = new WelcomePage(driver,log);
		EntryAdPage entry = welcome.clickEntryAd();
		if(entry.verifyAdWindowExists()) {
			sa.assertTrue(entry.getModalWindowText().contains("t's commonly used to encourage a user to take an action"));
			entry.closeModalWindow();
		}
		else {
			sa.assertTrue(false);
		}
		
		if(entry.restart_ad()) {
			sa.assertTrue(entry.getModalWindowText().contains("t's commonly used to encourage a user to take an action"));
			entry.closeModalWindow();
		}
		else {
			sa.assertTrue(false);
		}
			
		sa.assertAll();		
	}
	
	

}
