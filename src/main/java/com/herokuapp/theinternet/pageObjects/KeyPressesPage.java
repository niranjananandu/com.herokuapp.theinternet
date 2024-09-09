package com.herokuapp.theinternet.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePage{
	
	private By textBox = By.xpath("//input[@id='target']");
	private By result = By.xpath("//p[@id='result']");

	public KeyPressesPage(WebDriver driver, Logger log) {
		super(driver,log);
	}
	
	public String[] typeText(String text) {
		char[] charArray = text.toCharArray();
		int len =text.length();
		String[] resArray =new String[len];
		for(int i=0;i<len;i++) {
			driver.findElement(textBox).sendKeys(Character.toString(charArray[i]));
			resArray[i] = driver.findElement(result).getText();
		}
		
		return resArray;
	}
	
	public boolean validateData(String[] data) {
		String[] expResult = {"You entered: T","You entered: E","You entered: S","You entered: T"};
		for(int i =0; i<data.length;i++) {
			if(data[i].equals(expResult[i])){
				continue;
			}
			else {
				return false;
			}
		} return true;

	}
	

}
