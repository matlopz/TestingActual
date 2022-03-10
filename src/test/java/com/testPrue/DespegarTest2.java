package com.testPrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.DespegarAlojamientoPage;
import pageObjects.DespegarHomePage;
import pageObjects.DespegarResultPage;
import utils.BaseTest;

public class DespegarTest2 {
	
	
	
	@Test(dataProvider = "ciudad")
  public void AlojamientoProvide(String ciudades) throws InterruptedException {
		WebDriver driver = BaseTest.iniciarBrowser("CHROME"); 
		  BaseTest.gotoMainPageDespegar(driver);
		  DespegarHomePage homePage = new DespegarHomePage(driver);
		  Assert.assertTrue(homePage.DespegarVisible());
		  homePage.iraAlojamiento();
		  DespegarAlojamientoPage alojamiento = new DespegarAlojamientoPage(driver);
		  alojamiento.alojamiento(ciudades);
		  DespegarResultPage result = new DespegarResultPage(driver);
		  Assert.assertTrue(result.Resultado());
		  driver.close();
  }
  
  @DataProvider(name = "ciudad")
  public Object [][] dataProvide(){
  	return new Object[][] {{" San Rafael, Mendoza, Argentina"}, {" Rio de Janeiro, Rio de Janeiro, Brasil"}, {" Mar del Plata, Buenos Aires, Argentina"}};
  }
}
