package com.herokuapp.theinternet.testCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.pageObjects.SortableTablesPage;
import com.herokuapp.theinternet.pageObjects.WelcomePage;

import base.TestUtilities;

public class SortableTablesTests extends TestUtilities{
	@Test(groups= {"master","regression"})
	public void sortableTablesTest() {
		SoftAssert sa = new SoftAssert();
		WelcomePage welcome =  new WelcomePage(driver,log);
		SortableTablesPage sort = welcome.clickSortableTables();
		sort.clickLastNameColumn();
        List<String> list = new ArrayList<>(Arrays.asList("Bach","Conway","Doe","Smith"));
		List<String> result = sort.getColumn();
		sa.assertEquals(list, result,"No match");
		
	}

}
