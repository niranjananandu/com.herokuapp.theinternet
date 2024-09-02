package com.herokuapp.theinternet.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {
	
	private By btn_logout = By.xpath("//i[@class='icon-2x icon-signout']");
	private By banner_successMessage = By.xpath("//div[@id='flash']");

	public SecureAreaPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean LogoutIsDisplayed() {
		return driver.findElement(btn_logout).isDisplayed();
	}
	
	public void clickLogout() {
		driver.findElement(btn_logout).click();
	}
	
	public String getSuccessMessage() {
		return driver.findElement(banner_successMessage).getText();
	}
	
	

}
