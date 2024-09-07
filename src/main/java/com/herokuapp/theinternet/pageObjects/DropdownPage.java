package com.herokuapp.theinternet.pageObjects;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage{
	
	private By dropDown = By.xpath("//select[@id='dropdown']");
	private By option = By.xpath("//option");
	

	public DropdownPage(WebDriver driver, Logger log) {
		super(driver,log);
		}
	
	public void selectOption(String option) {
		Select select  =new Select(driver.findElement(dropDown));
		select.selectByVisibleText("Option "+option);
	}
	
	public String returnSelectedOption() {
		List<WebElement> e = driver.findElements(option);
		for(WebElement i : e) {
			if(i.getAttribute("selected")!=null) {
				return i.getText();
				
		}}
		return null;
	}
	

} 
