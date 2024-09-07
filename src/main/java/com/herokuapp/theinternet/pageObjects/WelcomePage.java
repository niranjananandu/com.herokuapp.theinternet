package com.herokuapp.theinternet.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage {

	private By link_basicAuth = By.xpath("//a[normalize-space()='Form Authentication']");
	private By link_frames = By.xpath("//a[normalize-space()='Frames']");
	private By link_checkboxes = By.xpath("//a[normalize-space()='Checkboxes']");
	private By link_contextMenu = By.xpath("//a[normalize-space()='Context Menu']");
	private By link_DragNDrop = By.xpath("//a[normalize-space()='Drag and Drop']");
	private By link_DropDown = By.xpath("//a[normalize-space()='Dropdown']");
	private By link_DynamicLoading = By.xpath("//a[normalize-space()='Dynamic Loading']");


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
	
	public CheckboxesPage clickCheckboxes() {
		driver.findElement(link_checkboxes).click();
		return new CheckboxesPage(driver,log);
	}
	
	public ContextMenuPage clickContextMenu() {
		driver.findElement(link_contextMenu).click();
		return new ContextMenuPage(driver,log);
	}
	
	public DragNDropPage clickDragNDrop() {
		driver.findElement(link_DragNDrop).click();
		return new DragNDropPage(driver,log);
	}
	
	public DropdownPage clickDropdown() {
		driver.findElement(link_DropDown).click();
		return new DropdownPage(driver,log);
	}

	public DynamicLoadingPage clickDynamicLoading() {
		driver.findElement(link_DynamicLoading).click();
		return new DynamicLoadingPage(driver,log);
	}
}
