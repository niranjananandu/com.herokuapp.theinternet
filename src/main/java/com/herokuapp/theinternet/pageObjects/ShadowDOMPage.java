package com.herokuapp.theinternet.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ShadowDOMPage extends BasePage{
	
	private By first_line  =By.xpath("//span[@slot='my-text']");
	private By second_line=  By.xpath("//ul[@slot='my-text']/li[2]");

	public ShadowDOMPage(WebDriver driver, Logger log) {
		super(driver,log);
	}
	
	public String getShadowText() {		
		SearchContext context = driver.findElement(By.cssSelector("my-paragraph:nth-of-type(2)")).getShadowRoot();
		return context.findElement(By.cssSelector("p")).getText();
	}
	
	

}
