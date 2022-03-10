package com.testPrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import pageObjects.WikiHomePage;
import pageObjects.WikiResultPage;
import utils.BaseTest;



public class WikiTest1 extends BaseTest{

	@BeforeMethod
	public void setup() {
		WebDriver driver = BaseTest.iniciarBrowser("CHROME");
		BaseTest.gotoMainPageWiki(driver);
		WikiHomePage homePage = new WikiHomePage(driver);
	}

@Test
  public void ValidarBusquedaWikiPedia() throws Exception {
	WebDriver driver = BaseTest.iniciarBrowser("CHROME");
	BaseTest.gotoMainPageWiki(driver);
	WikiHomePage homePage = new WikiHomePage(driver);
	Assert.assertTrue(homePage.searchInputesVisible());
	WikiResultPage resultPage = homePage.searchInput("Selenium");
	Assert.assertTrue(resultPage.tituloVisible());
  }
}
