package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webfunctions {
	
	/**
	 * Waits for 10 seconds
	 * @param driver
	 * @param element
	 */
	public static void waitForElement(WebDriver driver, String element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(element))));		
	}

	
	
	public static void waitForElementByLikText(WebDriver driver, String element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(element))));		
	}
}
