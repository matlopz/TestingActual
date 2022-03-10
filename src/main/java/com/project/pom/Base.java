package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {
	private WebDriver driver;
	
	public Base(WebDriver driver) {
		this.setDriver(driver);
	} 
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mat_4\\Desktop\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	public static  WebDriver iniciarBrowser(String browserName) {
		WebDriver driver= null;
		switch(browserName) {
		case "CHROME": {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/recursos/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		case "FIREFOX":{
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/recursos/geckodriver");
			driver = new FirefoxDriver();
			break;
		}
		default :{
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/recursos/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		
		}
		return driver;
		
	}
	
	
	public WebElement findElement(By locator) {
		
		
		return getDriver().findElement(locator);
	}
	
	public List<WebElement> findElements(By locator){
		return getDriver().findElements(locator);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return getDriver().findElement(locator).getText();
	}
	
	public void type(String inputText, By locator) {
		getDriver().findElement(locator).sendKeys(inputText);
	}
	public void types(Keys tipo,By locator) {
		getDriver().findElement(locator).sendKeys(tipo);
	}
	
	public void click(By locator) {
		getDriver().findElement(locator).click();
	}
	public void isSelected(By locator) {
		getDriver().findElement(locator).isSelected();
	}
	
	
	public void clear(By locator) {
		getDriver().findElement(locator).clear();
	}
	
	public boolean isDisplayed(By locator) {
		try {
			return getDriver().findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public void urlpagina(String url) {
		getDriver().get(url);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
}
