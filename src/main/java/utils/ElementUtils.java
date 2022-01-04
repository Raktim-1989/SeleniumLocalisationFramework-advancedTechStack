package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {
	
	private WebDriver driver;
	public ElementUtils(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	//get the xpath with the folloiwng method 
	
	public By getBy(String locatorType , String locatorValue)
	{
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);			
			break;
		case "xpath":
			locator = By.xpath(locatorValue);			
			break;
		case "css":
			locator = By.cssSelector(locatorValue);			
			break;
		case "name":
			locator = By.name(locatorValue);			
			break;
		case "linkText":
			locator = By.linkText(locatorValue);			
			break;
			
		default:
			break;
		}
		
		return locator;
		
	}
	
	public WebElement getElement(By locator)
	{
		return driver.findElement(locator);
		
	}
	
	public WebElement getElement(String locatorType , String locatorValue)
	{
		
		return driver.findElement(getBy(locatorType, locatorValue));
	}
	

}
