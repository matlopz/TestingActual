package com.testPrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.pom.provideDespegarPage;


import org.openqa.selenium.WebDriver;


public class DespegarTest {
	
	private WebDriver driver;
	provideDespegarPage despegarpage;
	
	
		
		
	  
	
	
	
  @Test(dataProvider = "ciudad")
  public void despegar(String ciudades) throws InterruptedException {
	  despegarpage = new provideDespegarPage(driver);
		driver = despegarpage.chromeDriverConnection();
		despegarpage.urlpagina("https://www.despegar.com.ar/");
		
	    despegarpage.provideDespegar(ciudades);
	    
  }
  
@DataProvider(name = "ciudad")
public Object [][] dataProvide(){
	return new Object[][] {{" San Rafael, Mendoza, Argentina"}, {" Rio de Janeiro, Rio de Janeiro, Brasil"}, {" Mar del Plata, Buenos Aires, Argentina"}};
}
  

}
