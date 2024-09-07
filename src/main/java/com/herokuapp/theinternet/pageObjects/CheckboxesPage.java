package com.herokuapp.theinternet.pageObjects;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage extends BasePage{

	private String checkbox ="//form[@id='checkboxes']/input";
	private By checkboxes = By.xpath("//form[@id='checkboxes']/input");

	public CheckboxesPage(WebDriver driver, Logger log) {
		super(driver,log);
	}
	
	public int getNumberOfCheckboxes() {
		List<WebElement> elements= driver.findElements(checkboxes);
		return elements.size();
	}
	
	public void checkAllCheckboxes() {
		for(int i =1;i <=getNumberOfCheckboxes();i++) {
			WebElement check = driver.findElement(By.xpath(checkbox+"["+i+"]"));
			if(check.getAttribute("checked") ==null) {
				check.click();
			}
	}
	}
	
	public void uncheckAllCheckboxes() {
		for(int i =1;i <=getNumberOfCheckboxes();i++) {
			WebElement check = driver.findElement(By.xpath(checkbox+"["+i+"]"));
			if(check.getAttribute("checked") !=null) {
				check.click();
			}
	}
	}


	
}
