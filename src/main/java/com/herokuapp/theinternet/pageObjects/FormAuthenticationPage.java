package com.herokuapp.theinternet.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormAuthenticationPage extends BasePage {
	
	private By txt_username = By.xpath("//input[@id='username']");
	private By txt_password = By.xpath("//input[@id='password']");
	private By btn_login = By.xpath("//button[@type='submit']");
	private By banner_flash = By.xpath("//div[@id='flash']");

	public FormAuthenticationPage(WebDriver driver) {
		super(driver);
		}
	
	public void typeUsername(String username) {
		driver.findElement(txt_username).sendKeys(username);
	}

	public void typePassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public SecureAreaPage clickLoginSuccess() {
		driver.findElement(btn_login).click();
		return new SecureAreaPage(driver);
	}
	
	public void clickLoginFail() {
		driver.findElement(btn_login).click();
	}
	
	public String returnValidationMessage()
	{
		return driver.findElement(banner_flash).getText();
	}
	
}

