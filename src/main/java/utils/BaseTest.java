package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private WebDriver driver;
	public static void gotoMainPageWiki(WebDriver driver) {
		driver.get("http://wikipedia.org");
	}
	public static void gotoMainPageDespegar(WebDriver driver) {
		driver.get("https://www.despegar.com.ar/");
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
}
