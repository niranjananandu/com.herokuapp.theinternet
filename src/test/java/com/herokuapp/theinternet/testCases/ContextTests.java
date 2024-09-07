package com.herokuapp.theinternet.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.pageObjects.ContextMenuPage;
import com.herokuapp.theinternet.pageObjects.WelcomePage;

import base.TestUtilities;

public class ContextTests extends TestUtilities {
	
	@Test(groups= {"master"})
	public void contextClickTest() {
		SoftAssert sa = new SoftAssert();
		WelcomePage welcome = new WelcomePage(driver, log);
		ContextMenuPage context = welcome.clickContextMenu();
		context.contextClick();
		context.switchtoAlert();		
		sa.assertEquals(context.getAlertText(),"You selected a context memnu","No match");  
		context.acceptAlert();
		sa.assertAll();
	}

}
