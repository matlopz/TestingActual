package com.testPrue;

import org.testng.annotations.Test;

import pageObjects.WikiHomePage;
import pageObjects.WikiResultPage;
import utils.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class WikiTest2 extends BaseTest{
	private WebDriver driver = null;

	@BeforeMethod
	public void setup(ITestContext context) {
		String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
		driver = BaseTest.iniciarBrowser(navegador);
		BaseTest.gotoMainPageWiki(driver);

	}

	@Test(dataProvider = "buscar")
	public void ValidarBusquedaWikiPedia(String Busqueda) throws Exception {
		WikiHomePage homePage = new WikiHomePage(driver);
		Assert.assertTrue(homePage.searchInputesVisible());
		WikiResultPage resultPage = homePage.searchInput(Busqueda);
		Assert.assertTrue(resultPage.tituloVisible());
	}

	@AfterMethod
	public void endSetup() {
		driver.close();
	}

	@DataProvider(name = "buscar")
	public Object[][] getData() {
		return new Object[][] { { " Selenium" }, { " java" }, { " argentina" } };

	}

}
