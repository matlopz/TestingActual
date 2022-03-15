package com.testPrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.DespegarAlojamientoPage;
import pageObjects.DespegarHomePage;
import pageObjects.DespegarResultPage;
import utils.BaseTest;

public class DespegarTest1 {
	WebDriver driver;

	@BeforeMethod
	public void setup(ITestContext context) {
		String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
		driver = BaseTest.iniciarBrowser(navegador);
		BaseTest.gotoMainPageDespegar(driver);
	}

	@Test(groups = {"grupo1"})
	public void AlojamientoTest() throws InterruptedException {
		DespegarHomePage homePage = new DespegarHomePage(driver);
		Assert.assertTrue(homePage.DespegarVisible());
		homePage.iraAlojamiento();
		DespegarAlojamientoPage alojamiento = new DespegarAlojamientoPage(driver);
		alojamiento.alojamiento("Villa Carlos Paz, Cordoba, Argentina");

	}

	@Test()
	public void ResultPage() throws InterruptedException {
		DespegarResultPage result = new DespegarResultPage(driver);
		Assert.assertTrue(result.Resultado());
	}

	@AfterClass
	public void endSetup() {
		driver.close();
	}
}
