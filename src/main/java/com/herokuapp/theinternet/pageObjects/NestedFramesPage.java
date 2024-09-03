package com.herokuapp.theinternet.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage extends BasePage {

	private By topFrame = By.xpath("//frame[@name='frame-top']");
	private By leftFrame = By.xpath("//frame[@name='frame-left']");
	private By txt_insideIframe = By.xpath("//body");
	private By txt_middle = By.xpath("//div[@id='content']");
	private By middleFrame = By.xpath("//frame[@name='frame-middle']");
	private By rightFrame = By.xpath("//frame[@name='frame-right']");
	private By bottomFrame = By.xpath("//frame[@name='frame-bottom']");

	public NestedFramesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public String getTextLeftiFrame() {
		driver.switchTo().frame(driver.findElement(topFrame)).switchTo().frame(driver.findElement(leftFrame));
		String val = driver.findElement(txt_insideIframe).getText();
		driver.switchTo().defaultContent();
		return val;
	}
	
	public String getTextMiddleiFrame() {
		driver.switchTo().frame(driver.findElement(topFrame)).switchTo().frame(driver.findElement(middleFrame));
		String val =  driver.findElement(txt_middle).getText();
		driver.switchTo().defaultContent();
		return val;
		
	}

	public String getTextRightiFrame() {
		driver.switchTo().frame(driver.findElement(topFrame)).switchTo().frame(driver.findElement(rightFrame));
		String val =  driver.findElement(txt_insideIframe).getText();		
		driver.switchTo().defaultContent();
		return val;
	}
	
	public String getTextBottomiFrame() {
		driver.switchTo().frame(driver.findElement(bottomFrame));
		String val= driver.findElement(txt_insideIframe).getText();
		driver.switchTo().defaultContent();
		return val;
	}



}
