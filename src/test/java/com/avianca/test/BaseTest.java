package com.avianca.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.avianca.pages.BusquedaVueloPage;

public class BaseTest {

    public WebDriver driver;
    
    public BusquedaVueloPage buscarVuelo;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void inicializar() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        
        buscarVuelo = new BusquedaVueloPage(driver);
    }

    @AfterMethod
    public void tearDown () {
        if (driver != null) {
            driver.quit();
        }
    }

}
