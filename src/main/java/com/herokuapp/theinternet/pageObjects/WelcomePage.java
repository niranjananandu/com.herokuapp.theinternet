package com.herokuapp.theinternet.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage {

	private By link_basicAuth = By.xpath("//a[normalize-space()='Form Authentication']");
	private By link_frames = By.xpath("//a[normalize-space()='Frames']");

	public WelcomePage(WebDriver driver,Logger log) {
		super(driver,log);
	}

	public FormAuthenticationPage clickFormAuth() {
		driver.findElement(link_basicAuth).click();
		return new FormAuthenticationPage(driver,log);
	}

	public FramesPage clickFrames() {
		driver.findElement(link_frames).click();
		return new FramesPage(driver,log);
	}
}
