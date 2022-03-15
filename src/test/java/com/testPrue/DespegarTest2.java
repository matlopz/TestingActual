package com.testPrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.DespegarAlojamientoPage;
import pageObjects.DespegarHomePage;
import pageObjects.DespegarResultPage;
import utils.BaseTest;

public class DespegarTest2 {
	private WebDriver driver = null;

	@BeforeMethod
	public void setup(ITestContext context) {
		String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
		driver = BaseTest.iniciarBrowser(navegador);
		BaseTest.gotoMainPageDespegar(driver);

	}

	@Test( dataProvider = "ciudad")
	public void AlojamientoProvide(String ciudades) throws InterruptedException {

		DespegarHomePage homePage = new DespegarHomePage(driver);
		Assert.assertTrue(homePage.DespegarVisible());
		homePage.iraAlojamiento();
		DespegarAlojamientoPage alojamiento = new DespegarAlojamientoPage(driver);
		alojamiento.alojamiento(ciudades);
		DespegarResultPage result = new DespegarResultPage(driver);
		Assert.assertTrue(result.Resultado());

	}

	@AfterMethod
	public void endSetup() {
		driver.close();
	}

	@DataProvider(name = "ciudad")
	public Object[][] dataProvide() {
		return new Object[][] { { " San Rafael, Mendoza, Argentina" }, { " Villa Carlos Paz, Cordoba, Argentina" },
				{ " Mar del Plata, Buenos Aires, Argentina" } };
	}
}
