package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarAlojamientoPage {
	@FindBy(css=".ac-container .item-text")
	WebElement destinolocator;
	@FindBy(css=".sbox5-box-places-ovr input")
	WebElement igresoCiudadlocator;
	@FindBy(xpath="//*[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//*[@class='sbox5-monthgrid' or @class='sbox5-monthgrid sbox5-compact-view'][@data-month='2022-03']//*[@class='sbox5-monthgrid-datenumber-number'][text()='10']")			
	WebElement calendarioEntraLocator;
	@FindBy(css = ".calendar-container ")
	WebElement calendario;
	@FindBy(xpath="//div[@class=\"sbox5-box-dates-checkbox-container\"]//div[@class=\"sbox5-dates-input1\"]")
	WebElement entradaLocator;
	@FindBy(xpath="//div[@class=\"sbox5-box-dates-checkbox-container\"]//div[@class=\"sbox5-dates-input2-container\"]")
	WebElement SalidaLocator;
	@FindBy(xpath="//*[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//*[@class='sbox5-monthgrid' or @class='sbox5-monthgrid sbox5-compact-view'][@data-month='2022-03']//*[@class='sbox5-monthgrid-datenumber-number'][text()='14']")			
	WebElement calendarioSalidaLocator;
	@FindBy(css=".sbox5-floating-tooltip-opened .calendar-footer .btn-text")
	WebElement aplicarLocator;
	//habitacion
	@FindBy(css=".stepper__room .stepper__room__row:nth-child(1) .steppers-icon-right")
	WebElement adultoslocator;
	@FindBy(css=".sbox5-box-distributionPassengers-ovr")
	WebElement habitacionlocator;
	@FindBy(css=".stepper__room .stepper__room__row:nth-child(2) .steppers-icon-right")
	WebElement menorlocator;
	@FindBy(css=".select-option[value='5']")
	WebElement seleccionarEdad;
	@FindBy(css="div.sbox5-floating-tooltip-opened div.stepper__room__footer>a:nth-child(1)")
	WebElement aplicarHabitacion;
	@FindBy(css="div.sbox5-box-container div.sbox5-box-content button.sbox5-box-button-ovr.sbox5-3-btn.-secondary.-icon.-lg > em.btn-text")
	WebElement buscarlocator;
	@FindBy(css=".lgpd-banner .btn-text")
	WebElement entendi;
	@FindBy(css=".login-incentive .shifu-3-icon-close")
	WebElement loginInteractiv;
	
	
	private WebDriver driver = null;
	public DespegarAlojamientoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
}

	public WebDriverWait wait(WebElement locator) {
		return this.wait(locator);
	}
	
	public DespegarResultPage alojamiento(String ciudad) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.manage().window().maximize();
		entendi.click();
		loginInteractiv.click();
		((JavascriptExecutor)driver).executeScript("scroll(0,200)");
		//wait.until(ExpectedConditions.vi);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sbox5-box-places-ovr input")));
		igresoCiudadlocator.click();
		igresoCiudadlocator.clear();
		igresoCiudadlocator.sendKeys(ciudad);
		igresoCiudadlocator.sendKeys(Keys.CONTROL);
		igresoCiudadlocator.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ac-container .item-text")));
		destinolocator.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"sbox5-box-dates-checkbox-container\"]//div[@class=\"sbox5-dates-input1\"]")));
		
		entradaLocator.click();
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//*[@class='sbox5-monthgrid' or @class='sbox5-monthgrid sbox5-compact-view'][@data-month='2022-03']//*[@class='sbox5-monthgrid-datenumber-number'][text()='10']")));
		calendarioEntraLocator.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"sbox5-box-dates-checkbox-container\"]//div[@class=\"sbox5-dates-input2-container\"]")));
		SalidaLocator.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//*[@class='sbox5-monthgrid' or @class='sbox5-monthgrid sbox5-compact-view'][@data-month='2022-03']//*[@class='sbox5-monthgrid-datenumber-number'][text()='14']")));
		calendarioSalidaLocator.click();
		
		aplicarLocator.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sbox5-box-distributionPassengers-ovr")));
		habitacionlocator.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".stepper__room .stepper__room__row:nth-child(1) .steppers-icon-right")));
		adultoslocator.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".stepper__room .stepper__room__row:nth-child(2) .steppers-icon-right")));
		menorlocator.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".select-option[value='5']")));
		seleccionarEdad.click();
		aplicarHabitacion.click();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sbox5-box-container div.sbox5-box-content button.sbox5-box-button-ovr.sbox5-3-btn.-secondary.-icon.-lg > em.btn-text")));
		buscarlocator.click();
		return new DespegarResultPage(this.driver);
	}
	
	
}	
