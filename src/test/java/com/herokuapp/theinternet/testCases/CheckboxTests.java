package com.herokuapp.theinternet.testCases;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.pageObjects.CheckboxesPage;
import com.herokuapp.theinternet.pageObjects.WelcomePage;

import base.TestUtilities;

public class CheckboxTests extends TestUtilities {

	@Test(groups = { "regression" ,"master"})
	public void checkAllCheckboxes() {

		WelcomePage welcome = new WelcomePage(driver, log);
		CheckboxesPage check = welcome.clickCheckboxes();
		log.info("Checking all checkboxes");
		check.checkAllCheckboxes();

	}

	@Test(groups = { "sanity","master" })
	public void uncheckAllCheckboxes() {

		WelcomePage welcome = new WelcomePage(driver, log);
		CheckboxesPage check = welcome.clickCheckboxes();
		log.info("Unchecking all checkboxes");
		check.uncheckAllCheckboxes();
	}

}
