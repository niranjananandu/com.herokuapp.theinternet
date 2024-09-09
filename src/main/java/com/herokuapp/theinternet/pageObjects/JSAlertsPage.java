package com.herokuapp.theinternet.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JSAlertsPage extends BasePage {
	
	private By btn_js_alert= By.xpath("//button[normalize-space()='Click for JS Alert']");
	private By btn_js_confirm = By.xpath("//button[normalize-space()='Click for JS Confirm']");
	private By btn_js_prompt = By.xpath("//button[normalize-space()='Click for JS Prompt']");
	private By result_text  = By.xpath("//p[@id='result']");
	
	public JSAlertsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void clickJSAlert() {
		driver.findElement(btn_js_alert).click();		
	}
	
	public void clickJSConfirm() {
		driver.findElement(btn_js_confirm).click();		
	}
	
	public void clickJSPrompt() {
		driver.findElement(btn_js_prompt).click();		
	}
	
	public String getAlertText() {
		return switchtoAlert().getText();
	}
	
	public String getResultText() {
		return driver.findElement(result_text).getText();
	}

	public void sendJSPromptText(String text) {
		driver.switchTo().alert().sendKeys(text);
	}
}
