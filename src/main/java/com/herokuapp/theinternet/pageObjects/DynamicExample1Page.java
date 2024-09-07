package com.herokuapp.theinternet.pageObjects;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicExample1Page extends BasePage {

	private By btn_Start = By.xpath("//button[normalize-space()='Start']");
	private By txt_final = By.xpath("//div[@id='finish']/h4");

	public DynamicExample1Page(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void clickStart() {
		driver.findElement(btn_Start).click();
	}

	public String returnFinalText() {
		waitFor(ExpectedConditions.visibilityOfElementLocated(txt_final), Duration.ofSeconds(10));
		return driver.findElement(txt_final).getText();

	}
}
