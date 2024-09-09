package com.herokuapp.theinternet.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage extends BasePage{
	
	private By slider = By.xpath("//div[@class='sliderContainer']/input"); 
	private By val  = By.xpath("//span[@id='range']");
	
	public HorizontalSliderPage(WebDriver driver, Logger log) {
		super(driver,log);
	}
	
	public String moveSliderByValueAndReturn(int value) {
		
		if(value<=5) {
			for(int i=1; i<=value*2; i++) {
				driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
			}			
			
			}else {
				log.info("Invalid step");
				return null;
		}		
		
		return driver.findElement(val).getText();
	}

	
}
