package com.testPrue;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.WikiHomePage;
import pageObjects.WikiResultPage;
import utils.BaseTest;

public class WikiTest1 extends BaseTest {
	private WebDriver driver = null;

	@BeforeClass
	public void setup(ITestContext context) {
		String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
		driver = BaseTest.iniciarBrowser(navegador);
		BaseTest.gotoMainPageWiki(driver);
	}

	@Test
	public void ValidarBusquedaWikiPedia() {
		WikiHomePage homePage1 = new WikiHomePage(driver);
		Assert.assertTrue(homePage1.searchInputesVisible());
		WikiResultPage resultPage = homePage1.searchInput("Selenium");
		Assert.assertTrue(resultPage.tituloVisible());
	}

	@AfterClass
	public void endSetup() {
		driver.close();
	}
}
