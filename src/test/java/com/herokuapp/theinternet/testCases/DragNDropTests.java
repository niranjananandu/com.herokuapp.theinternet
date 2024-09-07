package com.herokuapp.theinternet.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.pageObjects.DragNDropPage;
import com.herokuapp.theinternet.pageObjects.WelcomePage;

import base.TestUtilities;

public class DragNDropTests extends TestUtilities{
	@Test(groups= {"master"})
	public void dragNDropTest() {
		SoftAssert sa = new SoftAssert();
		WelcomePage welcome  =new WelcomePage(driver,log);
		DragNDropPage drag = welcome.clickDragNDrop();
		log.info("Dragging A to B");
		drag.dragAtoB();
		log.info("Validating headers in box A");
		sa.assertEquals(drag.getHeaderTextfromBox("A"), "B","No match"); 
		log.info("Validating headers in box B");
		sa.assertEquals(drag.getHeaderTextfromBox("B"), "A","No match"); 
		
		sa.assertAll();
	}
	
	

}
