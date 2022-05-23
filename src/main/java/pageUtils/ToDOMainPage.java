package pageUtils;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import framework.DriverFactory;
import framework.Webfunctions;

public class ToDOMainPage {
	WebDriver driver;
	
	
	String INPUT_TEXTBOX_XPATH = "//input[@placeholder='What needs to be done?']";
	String CHECKBOX_XPATH = "//input[@type='checkbox' and @class='toggle']";
	String TODO_COUNT_XPATH = "//span[@class='todo-count']";
	String CLEAR_COMPLETE_XPATH = "//button[@class='clear-completed']";
	
	/**
	 * Add item to the list
	 * @param itemName
	 */
	public void addItem(String itemName) {
			driver = DriverFactory.getDriver();			
			Webfunctions.waitForElement(driver, INPUT_TEXTBOX_XPATH);
			driver.findElement(By.xpath(INPUT_TEXTBOX_XPATH)).sendKeys(itemName,Keys.ENTER);
	}
	
	/**
	 * Verify if an item is present
	 * @param itemName
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean verifyItemIsPresent(String itemName) throws InterruptedException {
		driver = DriverFactory.getDriver();
		Thread.sleep(1000);
		String linkxpath = CHECKBOX_XPATH+"/../label[text()='"+itemName+"']";		
		boolean itemAdded = driver.findElement(By.xpath(linkxpath)).isDisplayed();
		return itemAdded;
		
	}
	
	/**
	 * Verify the number of items displayed in the footer
	 * @param message
	 * @return
	 */
	public boolean verifyFooterNumber(String message) {
		driver = DriverFactory.getDriver();
		String count = driver.findElement(By.xpath(TODO_COUNT_XPATH)).getText();
    	return count.contains(message);	
    	
	}
	
	/**
	 * All active and complete are displayed
	 * @return
	 */
	public boolean allActiveCompleteDisplayed() {
		driver = DriverFactory.getDriver();
		boolean all = driver.findElement(By.linkText("All")).isDisplayed();
		boolean active= driver.findElement(By.linkText("Active")).isDisplayed();
		boolean completed = driver.findElement(By.linkText("Completed")).isDisplayed();
		return (all && active && completed);		
	}
	
	
	/**
	 * Clear complete button
	 * @return
	 */
	public boolean clearCompleteNotDisplayed() {
		driver = DriverFactory.getDriver();
		boolean result = (driver.findElements(By.xpath(CLEAR_COMPLETE_XPATH)).size()<=1);
		if(!result) {
			result = driver.findElement(By.xpath(CHECKBOX_XPATH)).isDisplayed();
		}
		return result;		
	}

}
