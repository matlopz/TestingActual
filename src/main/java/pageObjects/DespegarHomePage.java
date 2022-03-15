package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DespegarHomePage {
	@FindBy(xpath = "//a[@href=\"//www.despegar.com.ar/hoteles/\"]")
	WebElement alojamienteolocator;

	private WebDriver driver = null;

	public DespegarHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean DespegarVisible() {
		return this.alojamienteolocator.isDisplayed();
	}

	public DespegarAlojamientoPage iraAlojamiento() {
		this.alojamienteolocator.click();
		return new DespegarAlojamientoPage(this.driver);
	}

}
