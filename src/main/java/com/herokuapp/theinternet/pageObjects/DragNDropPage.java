package com.herokuapp.theinternet.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragNDropPage extends BasePage{
	
	private By boxA = By.xpath("//div[@id='column-a']");
	private By boxB = By.xpath("//div[@id='column-b']");
	String header = "//div[@id='column-";

	public DragNDropPage(WebDriver driver, Logger log) {
		super(driver,log);
	}
	
	public void dragAtoB() {
		performDragAndDrop(boxA, boxB);
	}
	
	public String getHeaderTextfromBox(String val) {
		String txt =header+val.toLowerCase()+"']";
		return driver.findElement(By.xpath(txt)).getText();		
	}
	

}
