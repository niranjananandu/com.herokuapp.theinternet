package com.herokuapp.theinternet.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SortableTablesPage extends BasePage{
	
	private By last_name =  By.xpath("//table[@id='table1']//span[contains(text(),'Last Name')]");
	private By  last_name_values_table1 =By.xpath("//table[@id='table1']/tbody/tr/td[1]");
	public SortableTablesPage(WebDriver driver, Logger log) {
		super(driver,log);
	}

	public void clickLastNameColumn() {
		driver.findElement(last_name).click();
	}
	
	public List<String> getColumn() {
		return getColumnValues(last_name_values_table1);
	}
	
	public List<String> getColumnValues(By locator) {
		List<String> text = new ArrayList<String>();
		List<WebElement> values=driver.findElements(locator);
		for(WebElement value: values) {
			text.add(value.getText());
		}return text;
	}
	
	
}
