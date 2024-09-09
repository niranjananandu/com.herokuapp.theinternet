package com.herokuapp.theinternet.pageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
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
	
	public String returnCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	
	protected void performDragAndDrop(By from, By to) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(
				"function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
						+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
						+ "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
						+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
						+ "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
						+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
						+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
						+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
						+ "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
						+ "var dragStartEvent =createEvent('dragstart');\n"
						+ "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
						+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
						+ "var dragEndEvent = createEvent('dragend');\n"
						+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
						+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
						+ "simulateHTML5DragAndDrop(source,destination);",
				driver.findElement(from), driver.findElement(to));
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
	
	public Alert switchtoAlert(){
		return driver.switchTo().alert();		
	}
	
	public void acceptAlert(){
		switchtoAlert().accept();		
	}
	
	public void dismissAlert(){
		switchtoAlert().dismiss();		
	}
	
	public String getAlertText() {
		return switchtoAlert().getText();
	}
	
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}
	
	public void switchTowindowWithTitle(String title) {		
		String firstWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> windowsIterator = allWindows.iterator();
		
		while(windowsIterator.hasNext()) {
			String windowHandle = windowsIterator.next().toString();
			if(!windowHandle.equals(firstWindow)) {
				driver.switchTo().window(windowHandle);
				if(getCurrentPageTitle().equals(title)) {
					break;
				}
			}
		}
		
	}
	

}
