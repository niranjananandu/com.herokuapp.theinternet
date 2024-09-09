package com.herokuapp.theinternet.pageObjects;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EntryAdPage extends BasePage {
	
	private By modal_window = By.xpath("//h3[normalize-space()='This is a modal window']");
	private By btn_close = By.xpath("//p[normalize-space()='Close']");
	private By modal_txt = By.xpath("//div[@class='modal-body']//p[1]");
	private By restart_ad = By.xpath("//a[@id='restart-ad']");

	public EntryAdPage(WebDriver driver, Logger log) {
		super(driver, log);

	}
	
	public boolean verifyAdWindowExists() {
		waitFor(ExpectedConditions.visibilityOfElementLocated(modal_window), Duration.ofSeconds(5));
		return driver.findElement(modal_window).isDisplayed();
	}
	
	public void closeModalWindow() {
		driver.findElement(btn_close).click();
	}
	
	public String getModalWindowText() {
		return driver.findElement(modal_txt).getText();
	}
	
	public boolean restart_ad() {
		driver.findElement(restart_ad).click();
		waitFor(ExpectedConditions.visibilityOfElementLocated(modal_window), Duration.ofSeconds(5));
		return driver.findElement(modal_window).isDisplayed();
	}
	
	
}
