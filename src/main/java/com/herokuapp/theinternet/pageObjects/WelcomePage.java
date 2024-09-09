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
	private By link_Entry_ad = By.xpath("//a[normalize-space()='Entry Ad']");
	private By link_file_upload = By.xpath("//a[normalize-space()='File Upload']");
	private By link_hovers = By.xpath("//a[normalize-space()='Hovers']");
	private By link_horizontalSlider = By.xpath("//a[normalize-space()='Horizontal Slider']");
	private By link_jsAlerts = By.xpath("//a[normalize-space()='JavaScript Alerts']");
	private By link_keyPresses =  By.xpath("//a[normalize-space()='Key Presses']");
	private By link_multipleWindows =  By.xpath("//a[normalize-space()='Multiple Windows']");
	private By link_notificationMessages =  By.xpath("//a[normalize-space()='Notification Messages']");
	private By link_shadowDom = By.xpath("//a[normalize-space()='Shadow DOM']");
	private By link_sortableTables = By.xpath("//a[normalize-space()='Sortable Data Tables']");
	private By link_geolocation = By.xpath("//a[normalize-space()='Geolocation']");
	
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
	
	public EntryAdPage clickEntryAd() {
		driver.findElement(link_Entry_ad).click();
		return new EntryAdPage(driver,log);
	}
	
	public FileUploadPage clickFileUpload() {
		driver.findElement(link_file_upload).click();
		return new FileUploadPage(driver,log);
	}
	
	public HoversPage clickHovers() {
		driver.findElement(link_hovers).click();
		return new HoversPage(driver,log);
	}
	
	public HorizontalSliderPage clickHorizontalSlider() 	{
		driver.findElement(link_horizontalSlider).click();
		return new HorizontalSliderPage(driver,log);
	}
	
	public JSAlertsPage clickJSAlerts() {
		driver.findElement(link_jsAlerts).click();
		return new JSAlertsPage(driver,log);
	}
	
	public KeyPressesPage clickKeyPresses() {
		driver.findElement(link_keyPresses).click();
		return new KeyPressesPage(driver,log);
	}
	
	public MultipleWindowsPage clickMultipleWindows() {
		driver.findElement(link_multipleWindows).click();
		return new MultipleWindowsPage(driver,log);
	}
	
	public NotificationMessagesPage clickNotificationMessages() {
		driver.findElement(link_notificationMessages).click();
		return new NotificationMessagesPage(driver,log);
	}
	
	public ShadowDOMPage clickShadowDOM() {
		driver.findElement(link_shadowDom).click();
		return new ShadowDOMPage(driver,log);
	}
	
	public SortableTablesPage clickSortableTables() {
		driver.findElement(link_sortableTables).click();
		return new SortableTablesPage(driver,log);
	}
	
	public GeolocationPage clickGeolocation() {
		driver.findElement(link_geolocation).click();
		return new GeolocationPage(driver,log);
	}

}
