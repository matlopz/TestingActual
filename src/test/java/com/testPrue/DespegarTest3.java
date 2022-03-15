package com.testPrue;

import org.testng.annotations.Test;

import pageObjects.DespegarAlojamientoPage;
import pageObjects.DespegarHomePage;
import pageObjects.DespegarResultPage;
import utils.BaseTest;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;

public class DespegarTest3 extends BaseTest{
	private WebDriver driver= null;

	@BeforeClass(alwaysRun=true)
	public void beforeClass(ITestContext context) {
		String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
		driver = BaseTest.iniciarBrowser(navegador);
		BaseTest.gotoMainPageDespegar(driver);
	}

	@Test(groups = {"grupo2"})
	public void Alojamiento() throws InterruptedException {
		DespegarHomePage homePage = new DespegarHomePage(driver);
		Assert.assertTrue(homePage.DespegarVisible());
		homePage.iraAlojamiento();
		DespegarAlojamientoPage alojamiento = new DespegarAlojamientoPage(driver);
		alojamiento.alojamiento("Villa Carlos Paz, Cordoba, Argentina");
		DespegarResultPage result = new DespegarResultPage(driver);
		Assert.assertTrue(result.Resultado());
		result.Precio();
	}

	@AfterClass(alwaysRun=true)
	public void afterClass() {

		driver.close();
	}

}
