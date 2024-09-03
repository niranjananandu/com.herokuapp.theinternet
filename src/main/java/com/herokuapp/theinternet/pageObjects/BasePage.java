package com.herokuapp.theinternet.pageObjects;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected Logger log;

	public BasePage(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
	}

	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollToTop() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}
	
	public void moveToElement(By locator) {
		Actions action =  new Actions(driver);
		action.moveToElement(driver.findElement(locator)).build().perform();
	}
	
	public void dragAndDrop(By from, By to) {
		Actions action =  new Actions(driver);
		action.dragAndDrop(driver.findElement(from), driver.findElement(to));
	}
	
	public void switchToNewWindow() {
		driver.switchTo().newWindow(WindowType.TAB);
	}
	
	public void switchToNewBrowserWindow() {
		driver.switchTo().newWindow(WindowType.WINDOW);
	}
	
	public void rightClick(By locator) {
		Actions action =  new Actions(driver);
		action.contextClick(driver.findElement(locator)).build().perform();
	}
	
	public void doubleClick(By locator) {
		Actions action =  new Actions(driver);
		action.doubleClick(driver.findElement(locator)).build().perform();
	}
	
	public void keyboardActions(Keys key) {
		Actions action =  new Actions(driver);
		action.sendKeys(key).build().perform();
	}
	
	public void waitFor(ExpectedCondition<WebElement> condition, Duration seconds) {
		seconds = seconds!=null?seconds:Duration.ofSeconds(30);
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(condition);		
	}


}
