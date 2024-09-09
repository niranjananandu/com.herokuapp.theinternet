package com.herokuapp.theinternet.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePage{
	
	private By choose_file = By.xpath("//input[@id='file-upload']");
	private By btn_upload = By.xpath("//input[@id='file-submit']");
	private By upload_banner = By.xpath("//div[@class='example']/h3");
	private By uploaded_file = By.xpath("//div[@id='uploaded-files']");

	public FileUploadPage(WebDriver driver, Logger log) {
		super(driver,log);
		}
	
	public void chooseFileToUpload(String filename) {
		log.info("Uploading file: ",filename);
		driver.findElement(choose_file).sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\UploadFiles\\"+filename+".txt");
		
	}
	
	public void clickUploadButton() {
		driver.findElement(btn_upload).click();
	}
	
	public String verifySuccessfulFileUploadMessage() {
		return driver.findElement(upload_banner).getText();
	}
	
	public String verifyUploadedFileName() {
		return driver.findElement(uploaded_file).getText();
	}
		
	
}
