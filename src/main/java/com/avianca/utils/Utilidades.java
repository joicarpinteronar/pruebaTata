package com.avianca.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.avianca.pages.BasePage;

import io.qameta.allure.Attachment;

public class Utilidades extends BasePage {

    public Utilidades(WebDriver driver) {
		super(driver);
		
	}

	public static void waitInMs(Integer milliseconds)  {
        try {
           Thread.sleep(milliseconds);
        } catch (Exception e) {}
    }
    
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}
