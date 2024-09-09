package com.herokuapp.theinternet.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.pageObjects.FramesPage;
import com.herokuapp.theinternet.pageObjects.IFramePage;
import com.herokuapp.theinternet.pageObjects.NestedFramesPage;
import com.herokuapp.theinternet.pageObjects.WelcomePage;

import base.TestUtilities;

public class iFrameTests extends TestUtilities{
	
	@Test(groups= {"sanity","master"})
	public void iframeTest() {		
		SoftAssert sa = new SoftAssert();
		WelcomePage welcome = new WelcomePage(driver,log);
		FramesPage fp = welcome.clickFrames();
		IFramePage ifp = fp.clickiFrames();
		ifp.closeAlert();
		sa.assertEquals(ifp.getTextInsideIframe(),"Your content goes here.","No match");
		sa.assertAll();
		
	}
	
	@Test(groups= {"regression","master"})
	public void nestedFramesTest() {
		SoftAssert sa = new SoftAssert();
		WelcomePage welcome = new WelcomePage(driver,log);
		FramesPage fp = welcome.clickFrames();
		NestedFramesPage nfp = fp.clickNestedFrames();
		sa.assertEquals(nfp.getTextLeftiFrame(), "LEFT", "No match");
		sa.assertEquals(nfp.getTextMiddleiFrame(), "MIDDLE", "No match");
		sa.assertEquals(nfp.getTextRightiFrame(), "RIGHT", "No match");
		sa.assertEquals(nfp.getTextBottomiFrame(), "BOTTOM", "No match");
		sa.assertAll();	
	}

}
