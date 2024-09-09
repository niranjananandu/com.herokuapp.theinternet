package com.herokuapp.theinternet.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HoversPage extends BasePage{
	
	String user_profiles = "//img[@alt='User Avatar']";
	String userProfileValue = "//h5[normalize-space()='name: user";
	String profile_link = "//div[@class='figcaption']/a[@href='/users/";

	
	public HoversPage(WebDriver driver, Logger log) {
		super(driver,log);
	}
	
	public void hoverOverUserProfile(String user) {
		By currentUser = By.xpath("("+user_profiles+")["+user+"]");
		By userProfile = By.xpath(profile_link+user+"']");
		moveToElement(currentUser);
		driver.findElement(userProfile).click();
		}
	
	
	public String returnCurrentURL() {		
		return returnCurrentUrl();
	}
	

}
