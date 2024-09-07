package com.herokuapp.theinternet.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContextMenuPage extends BasePage{
	
	private By context  =By.id("hot-spot");

	public ContextMenuPage (WebDriver driver, Logger log) {
		super(driver,log);
	}
	
	
		public void contextClick() {
		rightClick(context);
	}
		
}
