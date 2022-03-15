package com.testPrue;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.WikiHomePage;
import pageObjects.WikiResultPage;
import utils.BaseTest;

public class WikiTest1 {
	private WebDriver driver = null;

	@BeforeClass
	public void setup() {
		driver = BaseTest.iniciarBrowser("CHROME");
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
