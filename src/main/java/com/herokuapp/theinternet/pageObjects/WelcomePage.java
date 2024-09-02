package com.herokuapp.theinternet.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage{
	
	private By link_basicAuth = By.xpath("//a[normalize-space()='Form Authentication']");
	public WelcomePage(WebDriver driver) {
		super(driver);
		}

	
	public FormAuthenticationPage clickFormAuth() {
		driver.findElement(link_basicAuth).click();
		return new FormAuthenticationPage(driver);
	}
	
	
	

}
