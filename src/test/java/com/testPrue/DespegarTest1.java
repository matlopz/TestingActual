package com.testPrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DespegarAlojamientoPage;
import pageObjects.DespegarHomePage;
import pageObjects.DespegarResultPage;
import utils.BaseTest;

public class DespegarTest1 extends BaseTest {
	
	
	//Villa Carlos Paz, Cordoba, Argentina
  @Test
  public void AlojamientoTest() throws InterruptedException {
	  WebDriver driver = BaseTest.iniciarBrowser("CHROME"); 
	  BaseTest.gotoMainPageDespegar(driver);
	  DespegarHomePage homePage = new DespegarHomePage(driver);
	  Assert.assertTrue(homePage.DespegarVisible());
	  homePage.iraAlojamiento();
	  DespegarAlojamientoPage alojamiento = new DespegarAlojamientoPage(driver);
	  alojamiento.alojamiento("Villa Carlos Paz, Cordoba, Argentina");
	  DespegarResultPage result = new DespegarResultPage(driver);
	  Assert.assertTrue(result.Resultado());
	  driver.close();
  }
}
