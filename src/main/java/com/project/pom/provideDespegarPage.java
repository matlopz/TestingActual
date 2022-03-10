package com.project.pom;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class provideDespegarPage extends Base {

	By alojamienteolocator = By.xpath("//a[@href=\"//www.despegar.com.ar/hoteles/\"]");
	By destinolocator = By.cssSelector(".ac-container .item-text");
	By igresoCiudadlocator = By.cssSelector(".sbox5-box-places-ovr input");
	//calendario
	By calendarioEntraLocator = By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'][@data-month='2022-03']//div[@class='sbox5-monthgrid-datenumber-number'][text()='9']");
	By entradaLocator  = By.xpath("//div[@class=\"sbox5-box-dates-checkbox-container\"]//div[@class=\"sbox5-dates-input1\"]");
	By SalidaLocator = By.xpath("//div[@class=\"sbox5-box-dates-checkbox-container\"]//div[@class=\"sbox5-dates-input2-container\"]");
	By calendarioSalidaLocator = By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'][@data-month='2022-03']//div[@class='sbox5-monthgrid-datenumber-number'][text()='12']");
	By aplicarLocator = By.cssSelector(".sbox5-floating-tooltip-opened .calendar-footer .btn-text");
	//Habitacion
	By adultoslocator = By.cssSelector(".stepper__room .stepper__room__row:nth-child(1) .steppers-icon-right");
	//By habitacionlocator = By.cssSelector("div.sbox5-3-double-input");
	By habitacionlocator = By.cssSelector(".sbox5-box-distributionPassengers-ovr");
	By menorlocator = By.cssSelector(".stepper__room .stepper__room__row:nth-child(2) .steppers-icon-right");
	
	By seleccionarEdad = By.cssSelector(".select-option[value='5']");
	By aplicarHabitacion = By.cssSelector("div.sbox5-floating-tooltip-opened div.stepper__room__footer>a:nth-child(1)");
	
	By buscarlocator = By.cssSelector("div.sbox5-box-container div.sbox5-box-content button.sbox5-box-button-ovr.sbox5-3-btn.-secondary.-icon.-lg > em.btn-text");
	By resultado = By.cssSelector(".results-cluster-container:nth-child(1) .btn-text");
	By precio = By.cssSelector("div.results-cluster-container:nth-child(1) div.price-info-wrapper.-eva-3-mt-xsm:nth-child(2) > span.main-value");
	By entendi = By.cssSelector(".lgpd-banner .btn-text");
	By loginInteractiv = By.cssSelector(".login-incentive .shifu-3-icon-close");
	
	public provideDespegarPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void provideDespegar(String ciudad) throws InterruptedException {
		//getDriver().manage().window().setPosition(new Point(0, 0));
		//getDriver().manage().window().setSize(new Dimension(1360, 768));
		getDriver().manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(30));
		
		isDisplayed(alojamienteolocator);
		((JavascriptExecutor)getDriver()).executeScript("scroll(0,250)"); 
		click(alojamienteolocator);
		
		click(entendi);
		click(loginInteractiv);
		((JavascriptExecutor)getDriver()).executeScript("scroll(0,250)"); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(igresoCiudadlocator));
		click(igresoCiudadlocator);
		clear(igresoCiudadlocator);
		type(ciudad, igresoCiudadlocator);		
		types(Keys.CONTROL, igresoCiudadlocator);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(destinolocator));
		click(destinolocator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(entradaLocator));
		click(entradaLocator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(calendarioEntraLocator));
		
		click(calendarioEntraLocator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SalidaLocator));
		click(SalidaLocator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(calendarioSalidaLocator));
		click(calendarioSalidaLocator);
		click(aplicarLocator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(habitacionlocator));
		click(habitacionlocator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(adultoslocator));
		click(adultoslocator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(menorlocator));
		click(menorlocator);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(seleccionarEdad));
		click(seleccionarEdad);
		
		
		click(aplicarHabitacion);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(buscarlocator));
		click(buscarlocator);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(resultado)); 	
		((JavascriptExecutor)getDriver()).executeScript("scroll(0,250)"); 
		isDisplayed(resultado);
		
		
		
	}
	
	
	
	
	
	
	
	

}
