package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WikiResultPage {
	@FindBy(id="firstHeading")
	WebElement titulo;
	
	private WebDriver driver = null;
	
	
	public WikiResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean tituloVisible() {
		return this.titulo.isDisplayed();
	}
}
