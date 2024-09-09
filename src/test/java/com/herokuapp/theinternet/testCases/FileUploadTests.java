package com.herokuapp.theinternet.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.pageObjects.FileUploadPage;
import com.herokuapp.theinternet.pageObjects.WelcomePage;

import base.TestUtilities;

public class FileUploadTests extends TestUtilities{
	
	@Test(groups= {"master","sanity"})
	public void fileUploadTests() {
		SoftAssert sa = new SoftAssert();
		WelcomePage welcome = new WelcomePage(driver,log);
		FileUploadPage fileUpload = welcome.clickFileUpload();
		String filename = "Test1";
		fileUpload.chooseFileToUpload(filename);
		fileUpload.clickUploadButton();
		sa.assertEquals(fileUpload.verifySuccessfulFileUploadMessage(), "File Uploaded!" , "No match"); 
		sa.assertEquals(fileUpload.verifyUploadedFileName(),filename+".txt","Filename does not match expected");
		
		sa.assertAll();
		
	}

}
