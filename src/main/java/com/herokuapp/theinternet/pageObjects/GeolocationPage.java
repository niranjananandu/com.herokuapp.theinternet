package com.herokuapp.theinternet.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GeolocationPage extends BasePage{
	
	private By location =  By.xpath("//button[normalize-space()='Where am I?']");
	private By geolocation =  By.xpath("//p[@id='demo']");
	private By google_link = By.xpath("//a[normalize-space()='See it on Google']");
	
	public GeolocationPage(WebDriver driver,Logger log) {
		super(driver,log);
	}
	
	public void clickLocation() {
		driver.findElement(location).click();
		
	}
	
	public boolean verifyLocation() {
		if(driver.findElement(geolocation).isDisplayed() && driver.findElement(google_link).isDisplayed()) {
			return true;
		
		}
		else {
			return false;
		}

	}

}
