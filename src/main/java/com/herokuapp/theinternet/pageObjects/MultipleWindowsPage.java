package com.herokuapp.theinternet.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage extends BasePage{
	
	private By clickHere =  By.xpath("//a[normalize-space()='Click Here']");

	public MultipleWindowsPage(WebDriver driver, Logger log) {
		super(driver,log);
	}
	
	public void openNewWindow() {
		driver.findElement(clickHere).click();
	}
	
	public String switchToChildWindow() {
		switchTowindowWithTitle("New Window");
		return driver.getCurrentUrl();
}

	

}
