package com.testPrue;

import org.testng.annotations.Test;

import pageObjects.WikiHomePage;
import pageObjects.WikiResultPage;
import utils.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class WikiTest2 {
	@Test(dataProvider = "buscar")
	  public void ValidarBusquedaWikiPedia(String Busqueda) throws Exception {
		WebDriver driver = BaseTest.iniciarBrowser("CHROME");
		BaseTest.gotoMainPageWiki(driver);
		WikiHomePage homePage = new WikiHomePage(driver);
		Assert.assertTrue(homePage.searchInputesVisible());
		WikiResultPage resultPage = homePage.searchInput(Busqueda);
		Assert.assertTrue(resultPage.tituloVisible());
	  }

  
  
  
  @DataProvider(name = "buscar")
  public Object[][] getData() {
    return new Object[][] {{" Selenium"}, {" java"}, {" argentina"}};
    
  }
  
}
