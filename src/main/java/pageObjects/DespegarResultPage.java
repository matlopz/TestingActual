package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DespegarResultPage {

	@FindBy(css = ".results-cluster-container:nth-child(1) .btn-text")
	WebElement resultado;
	@FindBy(css = "div.results-cluster-container:nth-child(1) div.price-info-wrapper.-eva-3-mt-xsm:nth-child(2) > span.main-value")
	WebElement precio;
	private WebDriver driver = null;

	public DespegarResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean Resultado() {
		((JavascriptExecutor) driver).executeScript("scroll(0,250)");
		return this.resultado.isDisplayed();
	}

	public void Precio() {
		System.out.println("el precio es $ " + precio.getText());
	}
}
