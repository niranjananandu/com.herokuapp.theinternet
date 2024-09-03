package com.herokuapp.theinternet.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFramePage extends BasePage{
	
	private By iFrame = By.id("mce_0_ifr");
	private By textBox = By.id("tinymce");
	private By alert = By.xpath("//div[@role='alert']");
	private By alertClose = By.cssSelector("div[aria-label='Close'] svg");
	
	public IFramePage(WebDriver driver,Logger log) {
		super(driver,log);
	}

	
	public String getTextInsideIframe() {
		driver.switchTo().frame(driver.findElement(iFrame));
		return driver.findElement(textBox).getText();
	}
	
	public void closeAlert() {
		if(driver.findElement(alert).isDisplayed())
		{
			driver.findElement(alertClose).click();
		}
		
	}
	
	
	
}
