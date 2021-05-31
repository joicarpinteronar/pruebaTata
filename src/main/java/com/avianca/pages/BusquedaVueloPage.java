package com.avianca.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.avianca.utils.Utilidades;

import io.qameta.allure.Step;

public class BusquedaVueloPage extends BasePage{
	
	By lblSoloIda = By.xpath("//div[2]/ul/li[2]/a");
	By txtDesde = By.xpath("//div[2]/div/form/div/div[2]/div/div/div/fieldset/div/div/div/div/label/div/input");
	By selCiudad = By.xpath("//li/div/b");
	By txtHacia = By.xpath("//div[2]/div/form/div/div[2]/div/div/div/fieldset/div/div[2]/div[2]/div/label/div/input");
	By fechaViaje = By.xpath("//div[2]/fieldset/div/div/div/label/div/input");
	By selFechaIda = By.xpath("//div[3]/div/div/div[4]/div[3]/div[13]");
	By fechaRetorno = By.name("pbFechaRegreso");
	By btnBuscarVuelo = By.cssSelector("button[title='Buscar vuelos']");
	By selHacia = By.xpath("//div[2]/div/ul/li/div/b");
	By rbtnCabinaEconomica = By.xpath("//expander-elem[2]/div/div/div/div/div[2]/div/button/div");
	By selMejorOpcion = By.xpath("//div[5]/button/span");
	By btnContinuar = By.xpath("//button[contains(.,'Continuar')]");
	
	public BusquedaVueloPage(WebDriver driver) {
		super(driver);
		
	}
	
	 @Step("Abrir Portal Avianca. Url {0}")
	    public BusquedaVueloPage irPortal(String url)  {
	        driver.get(url);
	        Utilidades.waitInMs(2000);
	        return new BusquedaVueloPage(driver);
	    }
	 @Step("Seleccionar Solo Ida")
	    public BusquedaVueloPage seleccionarSoloIda() {
	        Utilidades.waitInMs(5000);
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,300)");
	        Utilidades.screenshot();
	        click(lblSoloIda);
	        Utilidades.screenshot();
	        Utilidades.waitInMs(5000);
	        return this;
	    }

	    @Step("Buscar Vuelo Ida y Vuelta")
	    public BusquedaVueloPage buscarVueloAvianca(String hacia, String fechaIda) {
	        Utilidades.waitInMs(3000); 
	        Utilidades.screenshot();
	        click(txtDesde);
	        click(selCiudad);
	        Utilidades.waitInMs(1000);
	        Utilidades.screenshot();
	        writeText(txtHacia, hacia);
	        click(selHacia);
	        Utilidades.waitInMs(1000);
	        Utilidades.screenshot();
	        writeText(fechaViaje, fechaIda);
	        click(selFechaIda);
	        Utilidades.screenshot();
	        Utilidades.waitInMs(2000);    
	        Utilidades.waitInMs(1000);
	        return this;
	    }
	    
	    @Step("Buscar Vuelo en el Rango de Fechas")
	    public BusquedaVueloPage buscarVuelo() {
	        Utilidades.waitInMs(3000); 
	        Utilidades.screenshot();
	        driver.findElement(fechaViaje).sendKeys(Keys.ENTER);
	        Utilidades.screenshot();
	        Utilidades.waitInMs(20000);
	        return this;
	    }
	    
	    @Step("Seleccionar Vuelo y Cabina Economica")
	    public BusquedaVueloPage seleccionarPrecio() {
	        Utilidades.waitInMs(5000);
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,300)");
	        Utilidades.waitInMs(3000);
	        Utilidades.screenshot();
	        Utilidades.screenshot();
	        click(rbtnCabinaEconomica);
	        js.executeScript("window.scrollBy(0,500)");
	        Utilidades.waitInMs(3000);
	        Utilidades.screenshot();
	        click(selMejorOpcion);
	        Utilidades.screenshot();
	        Utilidades.waitInMs(5000);
	        js.executeScript("window.scrollBy(0,500)");
	        Utilidades.screenshot();
	        click(btnContinuar);
	        Utilidades.screenshot();
	        Utilidades.waitInMs(5000);
	        Utilidades.screenshot();
	        return this;
	    }
	

}
