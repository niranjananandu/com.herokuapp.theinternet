package com.herokuapp.theinternet.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePage {

	private By link_nested = By.xpath("//a[normalize-space()='Nested Frames']");
	private By link_iframe = By.xpath("//a[normalize-space()='iFrame']");

	public FramesPage(WebDriver driver,Logger log) {
		super(driver,log);
	}

	public NestedFramesPage clickNestedFrames() {
		driver.findElement(link_nested).click();
		return new NestedFramesPage(driver,log);

	}

	public IFramePage clickiFrames() {
		driver.findElement(link_iframe).click();
		return new IFramePage(driver,log);
	}

}
