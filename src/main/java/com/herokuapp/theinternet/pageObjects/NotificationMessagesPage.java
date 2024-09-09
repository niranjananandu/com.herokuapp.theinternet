package com.herokuapp.theinternet.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotificationMessagesPage extends BasePage{
	
	private By flash = By.xpath("//div[@id='flash']");
	private By click_Here = By.xpath("//a[normalize-space()='Click here']");

	public NotificationMessagesPage(WebDriver driver,Logger log) {
		super(driver,log);
	}
	
	public String getToastMessage() {
		return driver.findElement(flash).getText();
	}
	
	public void loadNewToast() {
		driver.findElement(click_Here).click();
	}

}
