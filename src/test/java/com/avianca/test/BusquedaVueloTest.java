package com.avianca.test;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.avianca.test.utils.Listeners.TestListener;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

@Listeners({ TestListener.class })
@Epic("Busqueda Vuelo en Avianca")
@Feature("Busqueda Vuelo Tests")

public class BusquedaVueloTest extends BaseTest{
	public Properties fileprops = new Properties();

    public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
        return fileprops;
    }

    @Test(priority=0, description="Buscar Vuelo Disponible en Avianca Clase Economica Tipo M")
    @Severity(SeverityLevel.NORMAL)
    @Description("Realizar una Busqueda de Vuelos Disponibles")
    @Story("Busqueda Vuelo Avianca")
    @TmsLink("XRPRJ-1")
    public void buscarVueloAvianca () throws Exception {
    	buscarVuelo.irPortal(getProperties().getProperty("url"))
    	            .seleccionarSoloIda()
                    .buscarVueloAvianca(
                    		getProperties().getProperty("destino"),
                    		getProperties().getProperty("fechaSalida"))
                    .buscarVuelo()
                    .seleccionarPrecio();
    }

}
