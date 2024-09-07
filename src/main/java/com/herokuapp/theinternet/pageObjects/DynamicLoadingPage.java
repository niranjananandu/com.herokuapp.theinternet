package com.herokuapp.theinternet.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BasePage{
	
	private By link_example1 = By.linkText("Example 1: Element on page that is hidden");

	public DynamicLoadingPage(WebDriver driver, Logger log) {
		super(driver,log);
	}
	
	public DynamicExample1Page clickExample1() {
		driver.findElement(link_example1).click();
		return new DynamicExample1Page(driver,log);
	}
	
	

}
